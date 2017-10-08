package com.hanky.study.entity;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class TransInput {
    private String transType;
    private BigDecimal amount;
    private String payerAcctNo;
    private String payeeAcctNo;
}
