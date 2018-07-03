package com.gedia.sms.studentmanagementsystem.shiro;

import com.gedia.sms.studentmanagementsystem.entity.PermissionDTO;
import com.gedia.sms.studentmanagementsystem.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * shiro URL拦截器
 *
 * @author jiwenquan
 * @create 2018/7/2 13:20
 */
public class UrlFilter {
    @Autowired
    private PermissionService permissionService;
    /**
     * 获取所有需权限验证的请求链接
     *
     * @return Map
     * @throws Exception
     */
    public Map<String,String> getAllPermission(){
        Map<String,String> permissionInfo = new HashMap<String,String>();
        List<PermissionDTO> permissions = permissionService.queryAllPermission();
        for(PermissionDTO permission : permissions){
            if("1".equals(permission.getIsShiroCtrl())){
                permissionInfo.put(permission.getUrl(), permission.getPermissionCode());
            }

        }
        return permissionInfo;
    }
}
