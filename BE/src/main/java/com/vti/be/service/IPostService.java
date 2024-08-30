package com.vti.be.service;

import com.vti.be.dto.PostDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IPostService {
    PostDTO createPost(PostDTO postDTO);

    Page<PostDTO> getAllPosts(Pageable pageable);

    PostDTO updatePost(Integer id, PostDTO postDTO);

    void deletePostById(Integer id);

    Optional<PostDTO> findPostById(Integer id);
}
