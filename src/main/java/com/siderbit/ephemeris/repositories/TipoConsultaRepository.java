package com.siderbit.ephemeris.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siderbit.ephemeris.domains.TipoConsulta;

@Repository
public interface TipoConsultaRepository extends JpaRepository<TipoConsulta, Integer> {

}
