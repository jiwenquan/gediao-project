package com.gedia.sms.studentmanagementsystem.service;

import com.gedia.sms.studentmanagementsystem.dao.UserDao;
import com.gedia.sms.studentmanagementsystem.entity.RoleDTO;
import com.gedia.sms.studentmanagementsystem.entity.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author jiwenquan
 * @create 2018/7/2 13:55
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<RoleDTO> findRolesByUser(UserDTO dto) {
        return userDao.findRolesByUser(dto);
    }
}
