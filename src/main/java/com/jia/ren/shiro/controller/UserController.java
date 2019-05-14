package com.jia.ren.shiro.controller;


import com.jia.ren.shiro.mapper.PermissionMapper;
import com.jia.ren.shiro.pojo.Permission;
import com.jia.ren.shiro.pojo.User;
import com.jia.ren.shiro.service.PermissionService;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    PermissionService permissionService;

    @GetMapping("/test")
    public String test(Model model){
        model.addAttribute("name","renjia");
        return "test";
    }

//    @GetMapping("/getPermission")
//    public List<Permission> getPermissionByUserName(@RequestParam("userName") String userName){
//        List<Permission> permission = permissionService.getPermissionByUserName(userName);
//        System.out.println(userName);
//        System.out.println(permission);
//        System.out.println("111");
//        return permission;
//    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public List<Permission> login(@RequestParam("username") String username, @RequestParam("password") String password ) {

        // 获取subject
        Subject subject = SecurityUtils.getSubject();

        // 封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        //Map<String ,Object > resMap = new LinkedHashMap<>();
        //resMap.put("res_code","000");
        //resMap.put("res_msg","success");
        try {
            // 执行登录方法
            subject.login(token);

            // 验证用户是否已经登录
//            Collection<Session> sessions = sessionDAO.getActiveSessions();
//
//            if (subject.isAuthenticated()) {
//                for (Session session:sessions) {
//                    if(username.equals(session.getAttribute("loginedUser"))) {
//                        if(session.getId().equals(subject.getSession().getId())) {
//                            subject.logout();
//                            resMap.put("res_body","用户已登录");
//                        } else {
//                            resMap.put("res_body","用户在别处登录");
//                            session.setTimeout(0);
//                        }
//                        return resMap;
//                    }
//                }
//            }
//            subject.getSession().setAttribute("loginedUser",username);
            // 设置session过期时间
            //subject.getSession().setTimeout(50000);
            // 获取用户对象
            User user = (User)subject.getPrincipal();

            // 获取用户菜单

            List<Permission> permissions = permissionService.getPermissionByUserName(user.getUserName());
            System.out.println(permissions);

            // 合并菜单
            List<Permission> mergedPermissions = new ArrayList<>();

            // 一级菜单直接放入mergedMenus
            for(Permission permission :permissions) {
                if(permission.getParent().equals("0")) {
                    System.out.println(permission);
                    mergedPermissions.add(permission);
                }
            }
//             二级菜单放在一级菜单下
            for(Permission permission:permissions) {
                if(permission.getParent()!=null) {
                    System.out.println(permission.getParent());
                    for(Permission mergedPermission:mergedPermissions) {
                        // 找到父菜单
                        if(String.valueOf(mergedPermission.getId()).equals(permission.getParent())) {
                            // 如果父节点没有子节点List就创建一个
                            List<Permission> childPermissions;
                            if (mergedPermission.getChildPermissions() == null) {
                                childPermissions = new ArrayList<>();
                            } else {
                                childPermissions = mergedPermission.getChildPermissions();
                            }
                            childPermissions.add(permission);
                            mergedPermission.setChildPermissions(childPermissions);
                            break;
                        }
                    }
                }
            }
            System.out.println(mergedPermissions);
            return mergedPermissions;

        } catch (UnknownAccountException e) {
            List<Permission> mergedMenus = new ArrayList<>();
            Permission menu = new Permission();
            menu.setMsg("用户不存在");
            mergedMenus.add(menu);
            return mergedMenus;
        } catch (IncorrectCredentialsException e) {
            List<Permission> mergedMenus = new ArrayList<>();
            Permission menu = new Permission();
            menu.setMsg("密码错误");
            mergedMenus.add(menu);
            return mergedMenus;
            //resMap.put("res_code","002");
            //resMap.put("res_msg","Error");
            //resMap.put("res_body","");
            //return resMap;
        }

    }

    @RequestMapping(value = "/loginOut")
    public void loginOut(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }

    @RequestMapping("/testLogin")
    public String testSelect() {
        return "testLogin";
    }

    /**
     * 未登录就请求其他url
     */
    @RequestMapping("/needLogin")
    public Map needLogin() {
        HashMap<String,Object> info = new HashMap<>();
        info.put("info","you need login");
        return info;
    }

    /**
     * 未授权
     */
    @RequestMapping("/noAuth")
    public Map<String, Object> noAuth() {
        HashMap<String,Object> info = new HashMap<>();
        info.put("info","you have no auth");
        return info;
    }
}
