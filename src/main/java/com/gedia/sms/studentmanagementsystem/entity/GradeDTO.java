package com.gedia.sms.studentmanagementsystem.entity;

import java.util.Date;

/**
 * 年级
 *
 * @author jiwenquan
 * @create 2018/6/28 12:50
 */
public class GradeDTO {

    /**
     * 主键id
     */
    private String id;
    /**
     * 年级名称
     */
    private String gradeName;
    /**
     * 备注
     */
    private String remark;
    private Date created;
    private Date updated;
    private String createUser;
    private String updateUser;
}
