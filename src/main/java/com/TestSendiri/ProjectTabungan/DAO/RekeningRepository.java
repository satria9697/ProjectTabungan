package com.TestSendiri.ProjectTabungan.DAO;

import com.TestSendiri.ProjectTabungan.Entity.Rekening;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RekeningRepository extends JpaRepository<Rekening, Long> {
}