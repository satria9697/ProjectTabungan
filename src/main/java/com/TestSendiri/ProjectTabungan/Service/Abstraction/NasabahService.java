package com.TestSendiri.ProjectTabungan.Service.Abstraction;

import com.TestSendiri.ProjectTabungan.DTO.Nasabah.NasabahGridDto;
import com.TestSendiri.ProjectTabungan.DTO.Nasabah.NasabahUpsertDto;
import com.TestSendiri.ProjectTabungan.Entity.Nasabah;

import java.util.List;

public interface NasabahService {
    public List<NasabahGridDto> findAllNasabah();
    public NasabahGridDto findNasabahById(Integer id);

    public Nasabah insertNasabah(NasabahUpsertDto dto);
    public Nasabah updateNasabah(Integer id, NasabahUpsertDto dto);
    public void deleteNasabah(Integer id);
}
