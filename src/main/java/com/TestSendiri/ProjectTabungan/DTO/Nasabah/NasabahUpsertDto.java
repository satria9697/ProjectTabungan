package com.TestSendiri.ProjectTabungan.DTO.Nasabah;

import lombok.Data;

import java.io.Serializable;
@Data
public class NasabahUpsertDto implements Serializable {
    private Integer id;
    private String namaDepan;
    private String namaBelakang;
    private String tempatLahir;
    private String tanggalLahir;
    private String jenisKelamin;
    private String alamat;
    private String noHandphone;
}
