package com.TestSendiri.ProjectTabungan.Service.Implementation;

import com.TestSendiri.ProjectTabungan.DAO.RekeningRepository;
import com.TestSendiri.ProjectTabungan.DAO.TransaksiRepository;
import com.TestSendiri.ProjectTabungan.DTO.Transaksi.TransaksiGridDto;
import com.TestSendiri.ProjectTabungan.DTO.Transaksi.TransaksiInsertDto;
import com.TestSendiri.ProjectTabungan.Entity.Transaksi;
import com.TestSendiri.ProjectTabungan.Service.Abstraction.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
public class TransaksiServiceImpl implements TransaksiService {
    @Autowired
    private TransaksiRepository transaksiRepository;
    @Autowired
    private RekeningRepository rekeningRepository;

    @Override
    public Transaksi insertTransaksi(Long noRekening, TransaksiInsertDto dto) {
        var rekening = rekeningRepository.findById(noRekening).get();
        var transaksi = new Transaksi(
                rekening,
                generateNoTransaksi(),
                dto.getJenisTransaksi(),
                LocalDateTime.now(),
                dto.getJumlahTransaksi()
        );

        if (transaksi.getJenisTransaksi().equals("kredit")||
                transaksi.getJenisTransaksi().equals("debit")) {
            transaksi.getJenisTransaksi();
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Jenis transaksi hanya bisa 'kredit' atau 'debit'");
        }
        transaksiRepository.save(transaksi);

        int saldoTerbaru = dto.getJumlahTransaksi();
        if(dto.getJenisTransaksi().equals("kredit")){
            saldoTerbaru = rekening.getSaldo() - dto.getJumlahTransaksi();
        } else if(dto.getJenisTransaksi().equals("debit")){
            saldoTerbaru = rekening.getSaldo() + dto.getJumlahTransaksi();
        }
        rekening.setSaldo(saldoTerbaru);
        rekeningRepository.save(rekening);

        return transaksi;
    }

    @Override
    public String generateNoTransaksi() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
        String tgltrx = LocalDate.now().format(formatter);

        if(transaksiRepository.getLastNoTransaksi() == null){
            return tgltrx + "000001";
        }
        else {

            int length = transaksiRepository.getLastNoTransaksi().length();
            Long id = Long.parseLong( transaksiRepository.getLastNoTransaksi().substring(11, length));
            id++;
            return tgltrx + String.format("%06d", id);
        }
    }

    @Override
    public void deleteTransaksi(Integer idTransaksi) {
        transaksiRepository.deleteById(idTransaksi);

    }

    @Override
    public List<TransaksiGridDto> getTransaksiByRekening(Long noRekening) {
        var transaksiByRekening = TransaksiGridDto.dtoList(transaksiRepository.getTransaksiByNoRekening(noRekening));
        return transaksiByRekening ;
    }

    @Override
    public List<TransaksiGridDto> getTransaksiByDate(LocalDateTime tanggalTransaksi) {
        var transaksiByDate = TransaksiGridDto.dtoList(transaksiRepository.getTransaksiByDate(tanggalTransaksi));
        return transaksiByDate;
    }

}
