package com.day.sang.core.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class BasePO {
    // 创建人ID
    @Column(name = "created_id")
    protected Integer createdId;

    // 创建时间
    @Column(name = "created_at")
    protected String createdAt;

    // 修改人ID
    @Column(name = "updated_id")
    protected Integer updatedId;

    // 修改时间
    @Column(name = "updated_at")
    protected String updatedAt;
}
