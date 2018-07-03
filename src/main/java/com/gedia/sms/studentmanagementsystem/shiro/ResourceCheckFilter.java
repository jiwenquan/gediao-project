package com.gedia.sms.studentmanagementsystem.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * shiro 资源拦截器
 *
 * @author jiwenquan
 * @create 2018/7/2 11:00
 *
 */
public class ResourceCheckFilter extends AccessControlFilter {

	private String unanUrl = "";
	
	public String getUnanUrl() {
		return unanUrl;
	}

	public void setUnanUrl(String unanUrl) {
		this.unanUrl = unanUrl;
	}
	public ResourceCheckFilter(String unanUrl) {
		this.unanUrl = unanUrl;
	}

	/**
	 * 判断请求是否拦截方法
	 *
	 * @param req
	 * @param res
	 * @return boolean
	 * @throws Exception
	 */
	@Override
	protected boolean isAccessAllowed(ServletRequest req,
                                      ServletResponse res, Object arg2) throws Exception {
		//获取当前登录用户
		Subject subject = getSubject(req, res);
		String url = getPathWithinApplication(req);
		return subject.isPermitted(url);
	}

	/**
	 * 请求拦截后处理方法
	 *
	 * @param req
	 * @param res
	 * @return boolean
	 * @throws Exception
     */
	@Override
	protected boolean onAccessDenied(ServletRequest req, ServletResponse res)
			throws Exception {
		HttpServletResponse response = (HttpServletResponse)res;
		HttpServletRequest request = (HttpServletRequest)req;
		String url = request.getContextPath() == null?unanUrl:request.getContextPath()+unanUrl;
		response.sendRedirect(url);
		return false;
	}

}
