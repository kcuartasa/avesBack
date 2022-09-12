package com.co.ias.aves.repository;

import com.co.ias.aves.model.Ave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AveRepository extends JpaRepository<Ave, String> {

    Optional<Ave> findByDsNombreComunOrDsNombreCientifico(String nombreComun, String nombreCientifico);

}
