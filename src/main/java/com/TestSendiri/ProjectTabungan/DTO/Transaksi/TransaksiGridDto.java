package com.TestSendiri.ProjectTabungan.DTO.Transaksi;

import com.TestSendiri.ProjectTabungan.Entity.Transaksi;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

@Data
public class TransaksiGridDto implements Serializable {
    private final Integer id;
    private final String noTransaksi;
    private final String jenisTransaksi;
    private final LocalDateTime tanggalTransaksi;
    private final Integer jumlahTransaksi;

    public static TransaksiGridDto set(Transaksi transaksi){
        return new TransaksiGridDto(
                transaksi.getId(),
                transaksi.getNoTransaksi(),
                transaksi.getJenisTransaksi(),
                transaksi.getTanggalTransaksi(),
                transaksi.getJumlahTransaksi());
    }

    public static List<TransaksiGridDto> dtoList(List<Transaksi> transaksis){
        Stream<TransaksiGridDto> result = transaksis.stream().map(TransaksiGridDto::set);
        return result.toList();
    }
}
