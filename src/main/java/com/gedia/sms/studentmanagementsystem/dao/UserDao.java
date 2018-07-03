package com.gedia.sms.studentmanagementsystem.dao;

import com.gedia.sms.studentmanagementsystem.entity.RoleDTO;
import com.gedia.sms.studentmanagementsystem.entity.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author jiwenquan
 * @create 2018/7/2 13:49
 */
@Repository("uesrDao")
public interface UserDao {
    List<RoleDTO> findRolesByUser(UserDTO dto);
}
