package com.phonet.project.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;

/**
 * Created by yuri on 06.09.17.
 */

@Entity
@Table
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Double sum;

    @Column(nullable = false)
    private String companyName;

}
