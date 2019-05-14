package com.jia.ren.shiro.shiroConfig;

import com.jia.ren.shiro.pojo.Permission;
import com.jia.ren.shiro.pojo.Role;
import com.jia.ren.shiro.pojo.User;
import com.jia.ren.shiro.service.PermissionService;
import com.jia.ren.shiro.service.RoleService;
import com.jia.ren.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 自定义的realm类 要继承
 */

public class UserRealm  extends AuthorizingRealm {

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    //执行授权逻辑
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        //给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        //用来存角色权限
        Set<String> roles=new HashSet<String>();
        List<Role> rolesByUserName = roleService.getRolesByUserName(user.getUserName());
        for(Role role:rolesByUserName) {
            System.out.println(role);
            roles.add(role.getRoleName());
        }
        //给认证用户把在数据库里面的角色拿出来给他授权
        info.setRoles(roles);

        System.out.println(user.getUserName());
        List<Permission> permissionsByUserName = permissionService.getPermissionByUserName(user.getUserName());
        for(Permission permission:permissionsByUserName) {
            info.addStringPermission(permission.getPermissionName());
        }
        return info;
    }


    //注入UsersService
    @Autowired
    private UserService userService;

    //执行认证逻辑
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.findUserByName(token.getUsername());

        //判断登录名
        if(user==null){
            //用户名不存在
            return null;//Shiro会抛出UnknownAccountException异常
        }

        //判断密码
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
