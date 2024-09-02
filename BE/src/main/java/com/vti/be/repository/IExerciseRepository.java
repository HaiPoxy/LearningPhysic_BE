package com.vti.be.repository;

import com.vti.be.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExerciseRepository extends JpaRepository<Exercise, Integer> {
}
