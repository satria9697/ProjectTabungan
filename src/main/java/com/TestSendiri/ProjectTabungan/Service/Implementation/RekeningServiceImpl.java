package com.TestSendiri.ProjectTabungan.Service.Implementation;

import com.TestSendiri.ProjectTabungan.DAO.NasabahRepository;
import com.TestSendiri.ProjectTabungan.DAO.RekeningRepository;
import com.TestSendiri.ProjectTabungan.DTO.Rekening.RekeningGridDto;
import com.TestSendiri.ProjectTabungan.DTO.Rekening.RekeningUpsertDto;
import com.TestSendiri.ProjectTabungan.Entity.Rekening;
import com.TestSendiri.ProjectTabungan.Service.Abstraction.RekeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RekeningServiceImpl implements RekeningService {
    @Autowired
    private RekeningRepository rekeningRepository;

    @Autowired
    private NasabahRepository nasabahRepository;

    @Override
    public RekeningGridDto cekRekeningNasabah(Long noRekening) {
        Rekening rekening = rekeningRepository.findById(noRekening).get();
        RekeningGridDto result = RekeningGridDto.set(rekening);
        return result;
    }

    @Override
    public Rekening insertRekening(Integer idNasabah, RekeningUpsertDto dto) {
        var nasabah = nasabahRepository.findById(idNasabah).get();
        var rekening = new Rekening(nasabah, generateNoRekening(), dto.getSaldo());
        var result= rekeningRepository.save(rekening);
        return result;
    }

    @Override
    public Long generateNoRekening() {
        Random rand = new Random();
        int maxDigit = 100000000;
        int noRekening = rand.nextInt(maxDigit);
        return Long.parseLong("1210"+String.format("%08d",noRekening));
    }
}
