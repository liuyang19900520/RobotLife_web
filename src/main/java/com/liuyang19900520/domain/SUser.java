package com.liuyang19900520.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liuya
 */
@Data
public class SUser extends BaseEntity implements Serializable {

    private Long id;
    private String userId;
    private String userName;
    private String password;
    private String avatar;
    private String nickName;
    private Date birthday;
    private String phone;
    private String email;



}
