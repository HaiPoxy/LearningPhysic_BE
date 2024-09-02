package com.vti.be.repository;

import com.vti.be.entity.UserExamAttempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserExamAttemptRepository extends JpaRepository<UserExamAttempt, Integer> {
}
