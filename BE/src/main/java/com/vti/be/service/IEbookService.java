package com.vti.be.service;

import com.vti.be.entity.Ebook;
import com.vti.be.form.EbookCreateForm;
import org.springframework.data.domain.Page;

import java.util.List;

public interface I {
    Page<Ebook> findAll(int pageNo, int pageSize, String sortBy, String sortDir);

    Ebook findById(Integer id);

    void create(EbookCreateForm form);

    void update(Ebook form);

    void deleteById(Integer id);

    void deleteAllById(List<Integer> ids);
}
