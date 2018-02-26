package com.liuyang19900520.config.shiro;

import com.liuyang19900520.domain.SUser;
import com.liuyang19900520.service.SUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 验证用户登录
 * 
 * @author Administrator
 */
@Component("userRealm")
public class UserRealm extends AuthorizingRealm {

	@Autowired
	private SUserService userService;

	public UserRealm() {
		setName("UserRealm");

	}

	// 权限资源角色
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// add Permission Resources
		info.setStringPermissions(userService.findPermissions(username));
		// add Roles String[Set<String> roles]
		// info.setRoles(roles);
		return info;
	}

	// 登录验证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upt = (UsernamePasswordToken) token;
		String userName = upt.getUsername();
		SUser user = userService.findByAccount(userName);
		if (user == null) {
			throw new UnknownAccountException();
		}
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userName, user.getPassword(), getName());
		return info;
	}
}