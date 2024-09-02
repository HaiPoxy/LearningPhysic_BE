package com.vti.be.repository;

import com.vti.be.entity.Theory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITheoryRepository extends JpaRepository<Theory, Integer> {
}
