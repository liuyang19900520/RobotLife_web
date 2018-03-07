package com.liuyang19900520.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author liuya
 */
@Data
public class SModule extends BaseEntity implements Serializable {

    /**
     * 路径
     */
    public static final String URL_TYPE = "URL";
    /**
     * 功能点
     */
    public static final String FUNCTION_TYPE = "FUNCTION";

    private Long id;

    private String moduleId;

    private String moduleName;

    private String parentId;

    private String moduleLevel;

    private String moduleUrl;

    private String moduleImg;

    private Integer moduleRank;

    private List<SModule> childrenModule;


}
