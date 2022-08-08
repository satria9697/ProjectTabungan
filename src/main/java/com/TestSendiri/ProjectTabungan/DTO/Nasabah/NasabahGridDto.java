package com.TestSendiri.ProjectTabungan.DTO.Nasabah;

import com.TestSendiri.ProjectTabungan.Entity.Nasabah;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class NasabahGridDto implements Serializable {
    private Integer id;
    private String namaDepan;
    private String namaBelakang;
    private String tempatLahir;
    private LocalDate tanggalLahir;
    private String jenisKelamin;
    private String alamat;
    private String noHandphone;

    public static NasabahGridDto set(Nasabah nasabah){
        return new NasabahGridDto(
                nasabah.getId(),
                nasabah.getNamaDepan(),
                nasabah.getNamaBelakang(),
                nasabah.getTempatLahir(),
                nasabah.getTanggalLahir(),
                nasabah.getJenisKelamin(),
                nasabah.getAlamat(),
                nasabah.getNoHandphone());
    }
}
