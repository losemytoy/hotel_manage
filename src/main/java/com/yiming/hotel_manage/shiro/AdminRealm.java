package com.yiming.hotel_manage.shiro;

import com.yiming.hotel_manage.pojo.Admin;
import com.yiming.hotel_manage.pojo.Role;
import com.yiming.hotel_manage.pojo.User;
import com.yiming.hotel_manage.service.AdminService;
import com.yiming.hotel_manage.service.LogService;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.Authenticator;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdminRealm extends AuthorizingRealm {

    @Autowired
    private LogService logService;

    @Autowired
    private AdminService adminService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        Admin admin = null;
        try {
            admin = logService.getAdminByAccount(token.getUsername());
            if (admin == null) {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        ByteSource credentialsSalt = ByteSource.Util.bytes(admin.getAdminAccount());
        return new SimpleAuthenticationInfo(admin, admin.getAdminPwd(), getName());
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行=====》授权");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        Admin admin = (Admin) principalCollection.getPrimaryPrincipal();
        List<String> perms;

        //系统最高权限管理员
        if(Admin.SUPER_ADMIN == admin.getAdminAccount()){
            perms = adminService.getAllPerms();
        }else {
            perms = adminService.getAdminPerms(admin.getAdminAccount());
        }

        Set<String> permsSet = new HashSet<>();
        for (String perm:perms){
            permsSet.addAll(Arrays.asList(perm.trim().split(",")));
        }

        info.setStringPermissions(permsSet);
        return info;
    }


}
