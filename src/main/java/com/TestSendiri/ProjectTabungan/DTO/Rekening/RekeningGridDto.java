package com.TestSendiri.ProjectTabungan.DTO.Rekening;

import com.TestSendiri.ProjectTabungan.Entity.Rekening;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
@AllArgsConstructor
@Data
public class RekeningGridDto implements Serializable {
    private Long no_Rekening;
    private String namaLengkap;
    private Integer saldo;

    public static RekeningGridDto set(Rekening rekening){
        return new RekeningGridDto(
                rekening.getId(),
                String.format("%s %s", rekening.getIdNasabah().getNamaDepan(), rekening.getIdNasabah().getNamaBelakang()),
                rekening.getSaldo());
    }
}
