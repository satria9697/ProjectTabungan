package com.TestSendiri.ProjectTabungan.DTO.Rekening;

import lombok.Data;

import java.io.Serializable;

@Data
public class RekeningUpsertDto implements Serializable {
    private final Long no_Rekening;
    private final Integer saldo = 0;
}
