package com.user.app.model.user;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户基础表
 * </p>
 *
 * @author zeng
 * @since 2020-03-10
 */
@Data
public class UserBase implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String code;
    private String salt;
    private String password;
    private Date ct;
    private Date ut;
    private Long cid;
    private Long uid;
    private Integer ava;
}
