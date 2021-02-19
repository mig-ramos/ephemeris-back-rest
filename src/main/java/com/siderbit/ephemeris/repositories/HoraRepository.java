package com.siderbit.ephemeris.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siderbit.ephemeris.domains.Hora;

@Repository
public interface HoraRepository extends JpaRepository<Hora, Integer> {

}
