package com.gedia.sms.studentmanagementsystem.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * shiro自定义拦截
 *
 * @author jiwenquan
 * @create 2018/7/1 12:20
 *
 */
public class EdopPermissionsAuthorizationFilter extends PermissionsAuthorizationFilter {
    public EdopPermissionsAuthorizationFilter(){

    }

    /**
     * 请求拦截后处理方法
     *
     * @param request
     * @param response
     * @return boolean
     * @throws IOException
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        Subject subject = this.getSubject(request, response);
        if(subject.getPrincipal() == null) {
            //未登录，被拦截请求处理
            String loginUrl = this.getLoginUrl();
            if(StringUtils.hasText(loginUrl) && !loginUrl.contains("login.jsp")) {
                this.saveRequestAndRedirectToLogin(request, response);
            }else{
                WebUtils.toHttp(response).sendError(402);
            }
        } else {
            //无权限，被拦截请求处理
            String unauthorizedUrl = this.getUnauthorizedUrl();
            if(StringUtils.hasText(unauthorizedUrl)) {
                WebUtils.issueRedirect(request, response, unauthorizedUrl);
            } else {
                WebUtils.toHttp(response).sendError(401);
            }
        }

        return false;
    }

    /**
     * 判断请求是否拦截方法
     *
     * @param request
     * @param response
     * @return boolean
     * @throws IOException
     */
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {
        String almAppScode = ((HttpServletRequest) request).getHeader("almAppScode");
        Subject subject = this.getSubject(request, response);
        String[] perms = (String[])((String[])mappedValue);
        boolean isPermitted = false;
        if(perms != null && perms.length > 0) {
            if(perms.length == 1) {
                if(subject.getPrincipal() != null){
                    //通过RolePerssion表数据鉴权
                    if(subject.isPermitted(perms[0])) {
                        isPermitted = true;
                    }

                    if(!isPermitted) { //通过项目角色信息表鉴权
                        Session session = subject.getSession(false);
                        if (session == null) {
                            session = subject.getSession();
                        }
                        Map<String, List<String>> rolesInProject = (Map<String, List<String>>) session.getAttribute("rolesInProject");
                        Map<String, List<String>> permissionRoleHas = (Map<String, List<String>>) session.getAttribute("permissionRoleHas");
                        if (!"".equals(almAppScode)) {
                            //取项目中的角色
                            List<String> roles = rolesInProject.get(almAppScode);
                            if (roles != null || roles.size() > 0) {
                                //取角色对应的权限
                                List<String> permissions = new ArrayList<String>();
                                for(String role : roles){
                                    List<String> partPermissions = permissionRoleHas.get(role);
                                    if(partPermissions != null) {
                                        permissions.addAll(partPermissions);
                                    }
                                }
                                if (permissions != null && permissions.contains(perms[0])) {
                                    //如果包含请求权限，访问授权
                                    isPermitted = true;
                                }
                            }
                        }
                    }
                }
            } else {
                //判断是否登录
                if (subject.getPrincipal() == null) {
                    isPermitted = false;
                }

            }
        }

        return isPermitted;
    }
}
