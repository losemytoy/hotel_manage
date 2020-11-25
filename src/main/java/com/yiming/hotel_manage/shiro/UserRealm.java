package com.yiming.hotel_manage.shiro;

import com.yiming.hotel_manage.pojo.Admin;
import com.yiming.hotel_manage.pojo.User;
import com.yiming.hotel_manage.service.LogService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private LogService logService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
//        Admin admin = null;
//        try {
//            admin = logService.getAdminByAccount(token.getUsername());
//            if (admin == null) {
//                return null;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
////        ByteSource credentialsSalt = ByteSource.Util.bytes(admin.getAdminAccount());
//        return new SimpleAuthenticationInfo(admin, admin.getAdminPwd(), getName());
        LocalUsernamePasswordToken token = (LocalUsernamePasswordToken) authenticationToken;
        User user = null;
        try {
            user = logService.getUserByAccount(token.getUsername());
            if (user == null) {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        ByteSource credentialsSalt = ByteSource.Util.bytes(admin.getAdminAccount());
        return new SimpleAuthenticationInfo(user, user.getUserPwd(), getName());
    }
}
