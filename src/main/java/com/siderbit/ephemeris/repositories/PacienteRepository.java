package com.siderbit.ephemeris.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siderbit.ephemeris.domains.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

}
