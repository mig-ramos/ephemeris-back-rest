package com.siderbit.ephemeris.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siderbit.ephemeris.domains.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
