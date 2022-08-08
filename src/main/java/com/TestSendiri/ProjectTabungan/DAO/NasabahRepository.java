package com.TestSendiri.ProjectTabungan.DAO;

import com.TestSendiri.ProjectTabungan.DTO.Nasabah.NasabahGridDto;
import com.TestSendiri.ProjectTabungan.Entity.Nasabah;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NasabahRepository extends JpaRepository<Nasabah, Integer> {


    @Query("""
        SELECT new com.TestSendiri.ProjectTabungan.DTO.Nasabah.NasabahGridDto(
        n.id, n.namaDepan, n.namaBelakang, n.tempatLahir, n.tanggalLahir, n.jenisKelamin, n.alamat, n.noHandphone)
        FROM Nasabah As n
    """)
    public List<NasabahGridDto> findAllNasabah();
}