package com.day.sang.core.po;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="passport")
public class PassportPO extends BasePO {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "account")
    private String account;

    @Column(name = "password")
    private String password;

}
