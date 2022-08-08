package com.TestSendiri.ProjectTabungan.Controller;

import com.TestSendiri.ProjectTabungan.DTO.Nasabah.NasabahUpsertDto;
import com.TestSendiri.ProjectTabungan.RestResponse;
import com.TestSendiri.ProjectTabungan.Service.Abstraction.NasabahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/nasabah")
public class NasabahController {
    @Autowired
    private NasabahService service;

    @GetMapping("find-all")
    public ResponseEntity<Object> getAllNasabah(){
    try{
        var nasabah = service.findAllNasabah();
        return ResponseEntity.status(HttpStatus.OK).body(nasabah);
    } catch (Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("find-by-id/{id}")
    public ResponseEntity<Object> getNasabahById(@PathVariable Integer id){
        try{
            var nasabah = service.findNasabahById(id);
            return ResponseEntity.status(HttpStatus.OK).body(nasabah);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Nasabah Tidak Ditemukan");
        }
    }

    @PostMapping("insert")
    public ResponseEntity<Object> insertNasabah(@RequestBody NasabahUpsertDto newNasabah) {
        try {
            var nasabah = service.insertNasabah(newNasabah);
            return ResponseEntity.status(HttpStatus.OK).body("Nasabah Berhasil Ditambahkan");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server Error");
        }
    }


    @PutMapping("update/{id}")
    public ResponseEntity<Object> updateNasabah (@PathVariable Integer id, @RequestBody NasabahUpsertDto updateDto){
        try{
            var nasabah = service.updateNasabah(id, updateDto);
            return ResponseEntity.status(HttpStatus.OK).body("Nasabah Berhasil Diupdate");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server Error");
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Object> deleteNasabah (@PathVariable Integer id){
        try{
            service.deleteNasabah(id);
            return ResponseEntity.status(HttpStatus.OK).body("Nasabah dengan id "+id+" berhasil dihapus");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server Error");
        }
    }

}
