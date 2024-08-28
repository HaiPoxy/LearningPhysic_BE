package com.vti.be.service;

import com.vti.be.dto.CommentDTO;
import com.vti.be.dto.PostDTO;
import com.vti.be.entity.Post;
import com.vti.be.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Page<PostDTO> getAllPosts(Pageable pageable) {
        return postRepository.findAll(pageable)
                .map(this::convertToDTO);
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        Post post = convertToEntity(postDTO);
        Post savedPost = postRepository.save(post);
        return convertToDTO(savedPost);
    }

    @Override
    public PostDTO updatePost(Integer id, PostDTO postDTO) {
        Optional<Post> existingPost = postRepository.findById(id);
        if (existingPost.isPresent()) {
            Post post = existingPost.get();
            post.setTitle(postDTO.getTitle());
            post.setContent(postDTO.getContent());
            post.setNumberLike(postDTO.getNumberLike());
            post.setStatus(Post.postStatus.valueOf(postDTO.getStatus()));
            Post updatedPost = postRepository.save(post);
            return convertToDTO(updatedPost);
        } else {
            throw new RuntimeException("Post with id " + id + " not found.");
        }
    }

    @Override
    public void deletePostById(Integer id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
        } else {
            throw new RuntimeException("Post with id " + id + " not found.");
        }
    }

    @Override
    public Optional<PostDTO> findPostById(Integer id) {
        return postRepository.findById(id)
                .map(this::convertToDTO);
    }

}