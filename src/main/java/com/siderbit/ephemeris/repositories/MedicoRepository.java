package com.siderbit.ephemeris.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siderbit.ephemeris.domains.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {

}
