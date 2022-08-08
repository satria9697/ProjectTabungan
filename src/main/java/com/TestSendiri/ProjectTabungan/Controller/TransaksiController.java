package com.TestSendiri.ProjectTabungan.Controller;

import com.TestSendiri.ProjectTabungan.DTO.Transaksi.TransaksiInsertDto;
import com.TestSendiri.ProjectTabungan.Entity.Rekening;
import com.TestSendiri.ProjectTabungan.Service.Abstraction.RekeningService;
import com.TestSendiri.ProjectTabungan.Service.Abstraction.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/transaksi")
public class TransaksiController {

    @Autowired
    private TransaksiService service;

    @Autowired
    private RekeningService rekeningService;

    @PostMapping("insert/{noRekening}")
    public ResponseEntity<Object> insertTransaksi(@PathVariable Long noRekening, @RequestBody TransaksiInsertDto dto){
        try{
            var transaksi = service.insertTransaksi(noRekening, dto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Berhasil Membuat Transaksi untuk Rekening dengan Nomor Rekening : " + noRekening);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server Error");
        }
    }

    @DeleteMapping("delete/{idTransaksi}")
    public ResponseEntity<Object> deleteTransaksi(@PathVariable Integer idTransaksi){
        try{
            service.deleteTransaksi(idTransaksi);
            return ResponseEntity.status(HttpStatus.OK).body("Berhasil Menghapus Transaksi Dengan ID : " + idTransaksi);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server Error");
        }
    }

    @GetMapping("date/{tanggalTransaksi}")
    public ResponseEntity<Object> getTransaksiByDate(@PathVariable @DateTimeFormat(pattern = "ddMMyyyy") LocalDateTime tanggalTransaksi){
        try{
            var transaksi = service.getTransaksiByDate(tanggalTransaksi);
            return ResponseEntity.status(HttpStatus.OK).body(transaksi);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server Error");
        }
    }

    @GetMapping("no-rekening/{noRekening}")
    public ResponseEntity<Object> getTransaksiByNoRekening(@PathVariable Long noRekening){
        try{
            var transaksi = service.getTransaksiByRekening(noRekening);
                return ResponseEntity.status(HttpStatus.OK).body(transaksi);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server Error");
        }
    }
}
