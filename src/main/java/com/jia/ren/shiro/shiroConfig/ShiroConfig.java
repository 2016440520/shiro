package com.jia.ren.shiro.shiroConfig;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //创建ShiroFilterFactoryBean

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //关联SecurityManager
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //添加Shiro内置过滤器
        /**
         * Shiro内置过滤器，可以实现权限相关的拦截器
         *      常用的过滤器
         *          anon：无需认证（登录）就可以访问
         *          authc：必须认证才可以访问
         *          user：如果使用rememberMe的功能才可以访问
         *          perms：该资源必须的到资源权限才可以访问
         *          role：该资源必须得到角色权限才可以访问
         *
         */
        Map<String ,String > filterMap = new LinkedHashMap<String ,String >();
        //filterMap.put("/add","authc");
        //filterMap.put("/update","authc");
        //给/下面的全部都添加认证访问 filterMap.put("/*","authc");由于这个是链表Map跟顺序有关，不要随意修改这个put的顺序
        //给login和登录放行
        filterMap.put("/test","anon");
        filterMap.put("/login","anon");
        filterMap.put("/loginOut","anon");
        //授权过滤器
        //注意：当前授权拦截后，shiro会自动跳转到未授权页面
        filterMap.put("/add","perms[insert]");
        filterMap.put("/update","perms[update]");

        //拦截所有的接口请求
        filterMap.put("/*","authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        //设置登录页面(接口)
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        //设置为授权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("noAuth");

        return  shiroFilterFactoryBean;

    }


    //创建DefalutWebSecurityManager
    @Bean(name = "defaultWebSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //关联Realm
        defaultWebSecurityManager.setRealm(userRealm);
        return defaultWebSecurityManager;
    }

    //创建Realm类
    @Bean(name = "userRealm")
    public UserRealm getRealm(){
        UserRealm userRealm = new UserRealm();
        return userRealm;
    }

}
