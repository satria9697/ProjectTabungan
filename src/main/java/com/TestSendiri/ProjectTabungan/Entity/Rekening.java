package com.TestSendiri.ProjectTabungan.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Rekening {
    @Id
    @Column(name = "no_rekening", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_nasabah", nullable = false)
    private Nasabah idNasabah;

    @Column(name = "saldo", nullable = false)
    private Integer saldo;

    @OneToMany(mappedBy = "noRekening")
    private Set<Transaksi> transaksis = new LinkedHashSet<>();


    public Rekening(Nasabah idNasabah,Long id, Integer saldo) {
        this.id = id;
        this.idNasabah = idNasabah;
        this.saldo = saldo;
    }
}