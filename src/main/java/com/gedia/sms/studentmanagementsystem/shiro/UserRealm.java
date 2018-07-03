package com.gedia.sms.studentmanagementsystem.shiro;

import com.gedia.sms.studentmanagementsystem.entity.PermissionDTO;
import com.gedia.sms.studentmanagementsystem.entity.RoleDTO;
import com.gedia.sms.studentmanagementsystem.entity.UserDTO;
import com.gedia.sms.studentmanagementsystem.service.PermissionService;
import com.gedia.sms.studentmanagementsystem.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * shiro 自定义验证，授权器
 *
 * @author jiwenquan
 * @create 2018/7/2 15:20
 */
public class UserRealm  extends AuthorizingRealm {
	@Autowired
	private UserService userService;
	@Autowired
	private PermissionService permissionService;

	/**
	 * shiro授权
	 *
	 * @param principal
	 * @return AuthorizationInfo
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		String account = (String) principal.getPrimaryPrincipal();
		UserDTO user = new UserDTO();
		user.setAccount(account);
		//根据用户查询用户角色
		List<RoleDTO> roleObjs = userService.findRolesByUser(user);
		Set<String> roles = new HashSet<String>();
		Set<String> permissions = new HashSet<String>();

		//根据角色添加权限
		for(RoleDTO roleObj : roleObjs){
			roles.add(roleObj.getRoleName());
			List<PermissionDTO> permissionObjs = permissionService.findPermissionByRole(roleObj);
			for(PermissionDTO permissionObj : permissionObjs){
				permissions.add(permissionObj.getPermissionCode());
			}
		}

		//添加无访问控制的权限
		List<PermissionDTO> permissionObjs = permissionService.findPermissionUnlimit();
		for(PermissionDTO permissionObj : permissionObjs){
			permissions.add(permissionObj.getPermissionCode());
		}
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

		//给用户分配角色
		authorizationInfo.addRoles(roles);

		//给用户分配权限
		authorizationInfo.addStringPermissions(permissions);
		return authorizationInfo;
	}

	/**
	 * shiro登录验证
	 *
	 * @param token
	 * @return AuthenticationInfo
	 * @throws AuthenticationException
     */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String account = upToken.getUsername();
		String pwd = "123";
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(account,pwd,
				getClass().getName());
		return info;

	}

}
