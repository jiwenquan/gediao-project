package com.gedia.sms.studentmanagementsystem.service;

import com.gedia.sms.studentmanagementsystem.dao.PermissionDao;
import com.gedia.sms.studentmanagementsystem.entity.PermissionDTO;
import com.gedia.sms.studentmanagementsystem.entity.RoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author jiwenquan
 * @create 2018/7/2 14:10
 */
@Service
public class PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    public List<PermissionDTO> queryAllPermission() {
        return permissionDao.queryAllPermission();
    }

    public List<PermissionDTO> findPermissionByRole(RoleDTO role){
        return permissionDao.findPermissionByRole(role);
    }

    public List<PermissionDTO> findPermissionUnlimit() {
        return permissionDao.queryPermissionUnlimit();
    }
}
