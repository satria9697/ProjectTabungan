package com.TestSendiri.ProjectTabungan.Service.Implementation;

import com.TestSendiri.ProjectTabungan.DAO.NasabahRepository;
import com.TestSendiri.ProjectTabungan.DTO.Nasabah.NasabahGridDto;
import com.TestSendiri.ProjectTabungan.DTO.Nasabah.NasabahUpsertDto;
import com.TestSendiri.ProjectTabungan.Entity.Nasabah;
import com.TestSendiri.ProjectTabungan.Service.Abstraction.NasabahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class NasabahServiceImpl implements NasabahService {

    @Autowired
    private NasabahRepository repository;

    @Override
    public List<NasabahGridDto> findAllNasabah() {
        var nasabah = repository.findAllNasabah();
        return nasabah;
    }

    @Override
    public NasabahGridDto findNasabahById(Integer id) {
        var nasabah = repository.getById(id);
        return NasabahGridDto.set(nasabah);
    }

    @Override
    public Nasabah insertNasabah(NasabahUpsertDto dto) {
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Nasabah nasabah = new Nasabah(
                dto.getNamaDepan(),
                dto.getNamaBelakang(),
                dto.getTempatLahir(),
                LocalDate.parse(dto.getTanggalLahir(), date),
                dto.getJenisKelamin(),
                dto.getAlamat(),
                dto.getNoHandphone()
        );
        Nasabah save = repository.save(nasabah);
        return save;
    }

    @Override
    public Nasabah updateNasabah(Integer id, NasabahUpsertDto dto) {
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Nasabah oldNasabah = repository.getById(id);
        if (oldNasabah == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nasabah tidak ditemukan");
        } else {
            oldNasabah.setNamaDepan(dto.getNamaDepan());
            oldNasabah.setNamaBelakang(dto.getNamaBelakang());
            oldNasabah.setTempatLahir(dto.getTempatLahir());
            oldNasabah.setTanggalLahir(LocalDate.parse(dto.getTanggalLahir(),date));
            oldNasabah.setJenisKelamin(dto.getJenisKelamin());
            oldNasabah.setAlamat(dto.getAlamat());
            oldNasabah.setNoHandphone(dto.getNoHandphone());
        }
        Nasabah save = repository.save(oldNasabah);
        return save;
    }

    @Override
    public void deleteNasabah(Integer id) {
            repository.deleteById(id);
        }
    }


