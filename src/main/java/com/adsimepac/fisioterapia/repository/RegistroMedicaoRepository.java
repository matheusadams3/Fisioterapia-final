package com.adsimepac.fisioterapia.repository;

import com.adsimepac.fisioterapia.model.RegistroMedicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistroMedicaoRepository extends JpaRepository<RegistroMedicao, Long> {

    // Buscar medição por consulta (relação 1:1)
    Optional<RegistroMedicao> findByConsultaId(Long consultaId);
}
