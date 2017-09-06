package com.phonet.project.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by yuri on 06.09.17.
 */
@Table
@Entity
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Double sum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;
}
