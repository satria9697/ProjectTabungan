package com.TestSendiri.ProjectTabungan.Service.Abstraction;

import com.TestSendiri.ProjectTabungan.DTO.Transaksi.TransaksiGridDto;
import com.TestSendiri.ProjectTabungan.DTO.Transaksi.TransaksiInsertDto;
import com.TestSendiri.ProjectTabungan.Entity.Transaksi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface TransaksiService {
    public Transaksi insertTransaksi(Long noRekening, TransaksiInsertDto dto);
    public String generateNoTransaksi();
    public void deleteTransaksi(Integer idTransaksi);
    public List<TransaksiGridDto> getTransaksiByRekening(Long noRekening);
    public List<TransaksiGridDto> getTransaksiByDate(LocalDateTime tanggalTransaksi);

}
