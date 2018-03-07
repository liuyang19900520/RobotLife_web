package com.liuyang19900520.domain.money;

import com.liuyang19900520.domain.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * @author liuya
 */
@Data
public class MCategory extends BaseEntity implements Serializable {

    private Long id;
    private String categoryId;
    private String categoryName;
    private String parentId;
    private String ioe;
    private String accountId;
}
