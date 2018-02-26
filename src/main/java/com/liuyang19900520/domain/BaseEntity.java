package com.liuyang19900520.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liuya
 */
@Data
public class BaseEntity implements Serializable {
    @JsonFormat(timezone = "GMT+9", pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;

    private String createBy;

    @JsonFormat(timezone = "GMT+9", pattern = "yyyy-MM-dd hh:mm:ss")
    private Date updateTime;

    private String updateBy;

    private String deleteFlag;


}
