package com.vti.be.repository;

import com.vti.be.entity.Ebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEbookRepository extends JpaRepository<Ebook, Integer> {
}
