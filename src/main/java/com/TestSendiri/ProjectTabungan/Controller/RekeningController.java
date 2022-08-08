package com.TestSendiri.ProjectTabungan.Controller;

import com.TestSendiri.ProjectTabungan.DTO.Rekening.RekeningUpsertDto;
import com.TestSendiri.ProjectTabungan.Service.Abstraction.RekeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rekening")
public class RekeningController {

    @Autowired
    private RekeningService service;

    @GetMapping("cek-nasabah/{noRekening}")
    public ResponseEntity<Object> cekRekeningNasabah(@PathVariable Long noRekening){
        try{
            var rekening = service.cekRekeningNasabah(noRekening);
            return ResponseEntity.status(HttpStatus.OK).body(rekening);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("insert/{idNasabah}")
    public ResponseEntity<Object> insertRekening(@PathVariable int idNasabah, @RequestBody RekeningUpsertDto dto){
        try{
            var rekening = service.insertRekening(idNasabah, dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(rekening);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
