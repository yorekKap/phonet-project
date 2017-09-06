package com.phonet.project.domain.dto;

import com.phonet.project.domain.Account;
import lombok.Data;

/**
 * Created by yuri on 06.09.17.
 */
@Data
public class TransactionDto {
    private Double sum;
    private Long accountId;

}
