package com.TestSendiri.ProjectTabungan.DTO.Transaksi;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

@Data
public class TransaksiInsertDto implements Serializable {
    private final String noTransaksi;
    private final String jenisTransaksi;
    private final LocalDate tanggalTransaksi;
    private final Integer jumlahTransaksi;
}
