package com.vti.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.be.entity.RegistrationInfo;

@Repository
public interface RegistrationInfoRepository extends JpaRepository<RegistrationInfo, Integer> {

}
