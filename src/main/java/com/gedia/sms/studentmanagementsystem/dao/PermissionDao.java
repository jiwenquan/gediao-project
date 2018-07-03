package com.gedia.sms.studentmanagementsystem.dao;

import com.gedia.sms.studentmanagementsystem.entity.PermissionDTO;
import com.gedia.sms.studentmanagementsystem.entity.RoleDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author jiwenquan
 * @create 2018/7/2 14:09
 */
@Repository("permissionDao")
public interface PermissionDao {

    List<PermissionDTO> queryAllPermission();

    List<PermissionDTO> findPermissionByRole(RoleDTO role);

    List<PermissionDTO> queryPermissionUnlimit();
}
