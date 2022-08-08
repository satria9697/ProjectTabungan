package com.TestSendiri.ProjectTabungan.DAO;

import com.TestSendiri.ProjectTabungan.Entity.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

public interface TransaksiRepository extends JpaRepository<Transaksi, Integer> {
    @Query(value = """
            SELECT TOP 1 no_transaksi
            FROM Transaksi
            ORDER BY no_transaksi DESC
            """, nativeQuery = true)
   public String getLastNoTransaksi();

    @Query(value = """
            SELECT * 
            FROM Transaksi 
            WHERE no_rekening = :noRekening 
            """, nativeQuery = true)
    List<Transaksi> getTransaksiByNoRekening(@Param("noRekening")Long noRekening);

    @Query(value = """
            SELECT * 
            FROM Transaksi 
            WHERE tanggal_transaksi = :tanggalTransaksi
            """, nativeQuery = true)
    List<Transaksi> getTransaksiByDate(@Param("tanggalTransaksi") LocalDateTime tanggalTransaksi);


}