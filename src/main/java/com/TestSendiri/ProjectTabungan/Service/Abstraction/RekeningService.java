package com.TestSendiri.ProjectTabungan.Service.Abstraction;

import com.TestSendiri.ProjectTabungan.DTO.Rekening.RekeningGridDto;
import com.TestSendiri.ProjectTabungan.DTO.Rekening.RekeningUpsertDto;
import com.TestSendiri.ProjectTabungan.Entity.Rekening;

public interface RekeningService {

public RekeningGridDto cekRekeningNasabah(Long noRekening);
public Rekening insertRekening(Integer idNasabah, RekeningUpsertDto dto);
public Long generateNoRekening();
}
