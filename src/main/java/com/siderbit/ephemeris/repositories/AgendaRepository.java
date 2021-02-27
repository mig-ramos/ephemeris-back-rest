package com.siderbit.ephemeris.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siderbit.ephemeris.domains.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Integer> {

}
