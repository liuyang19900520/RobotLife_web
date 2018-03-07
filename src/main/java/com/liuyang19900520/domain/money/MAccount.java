package com.liuyang19900520.domain.money;

import com.liuyang19900520.domain.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * @author liuya
 */
@Data
public class MAccount extends BaseEntity implements Serializable {

    private Long id;
    private String accountId;
    private String accountName;
    private String targetUserId;
}
