package com.qfedu.babytree.shiro;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


//public class QfeduRealm extends AuthorizingRealm {
//
//    @Autowired
//    private UsersService userService;
//
//    @Autowired
//    private RoleService roleService;
//
//    public String getName() {
//
//        return "qfrealm";
//    }
//
//    // 授权
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
//
//        Users user = (Users) arg0.getPrimaryPrincipal();
//
//        // 查询当前用户的所有的角色和所有的权限，并且给他授权
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//
//        List<String> roles = roleService.selectRoleByUserId(user.getUid() + "");
//        // System.out.println(roles);
//
//        Set<String> set = new HashSet<String>(roles);
//        // info.setStringPermissions(stringPermissions);
//        info.setRoles(set);
//        // 返回当前用户的授权信息
//        return info;
//    }
//
//    // 认证
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
//        String username = (String) arg0.getPrincipal();
//        // 数据库操作
//        // 根据当前的用户名查询用户的个人信息，这里主要是密码
//
//        Users user = new Users();
//        user.setUsername(username);
//        // 从数据库中查询出来的用户的真实信息
//        Users userDb = userService.selectByName(user);
//
//
//
//        // 注入第二参数是从数据库中查询出来的正确的密码，shiro会自动判断，如果此密码和刚才传递的密码不一致会上抛异常
//        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userDb, userDb.getPassword(),
//                ByteSource.Util.bytes(userDb.getSalt()), getName());
//
//        return info;
//
//    }
//
//    // 重写自定义realm的clearCache
//    @Override
//    protected void clearCache(PrincipalCollection principals) {
//
//        super.clearCache(principals);
//    }
//
//    // 提供一个公共方法，调用父类提供的清空缓存的代码
//    public void clearCached() {
//
//        super.clearCache(SecurityUtils.getSubject().getPrincipals());
//    }
//
//}




