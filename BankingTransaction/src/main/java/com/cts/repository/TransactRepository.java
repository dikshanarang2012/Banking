package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.model.Transact;

@Repository
public interface TransactRepository extends JpaRepository<Transact, Long> {

}
