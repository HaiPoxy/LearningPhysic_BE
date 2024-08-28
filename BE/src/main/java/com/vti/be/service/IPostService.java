package com.vti.be.service;

import com.vti.be.dto.CommentDTO;
import com.vti.be.dto.PostDTO;
import com.vti.be.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.stream.Collectors;

public interface IPostService {
    Page<PostDTO> getAllPosts(Pageable pageable);

    PostDTO createPost(PostDTO postDTO);

    PostDTO updatePost(Integer id, PostDTO postDTO);

    void deletePostById(Integer id);

    Optional<PostDTO> findPostById(Integer id);

    default PostDTO convertToDTO(Post post) {
        PostDTO dto = new PostDTO();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        dto.setNumberLike(post.getNumberLike());
        dto.setStatus(post.getStatus().name());
        dto.setAccountId(post.getAccount().getId());
        dto.setCreatedAt(post.getCreatedAt());
        dto.setUpdatedAt(post.getUpdatedAt());
        dto.setComments(post.getComments().stream().map(comment -> {
            CommentDTO commentDTO = new CommentDTO();
            commentDTO.setId(comment.getId());
            commentDTO.setContent(comment.getContent());
            commentDTO.setPostId(comment.getPost().getId());
            if (comment.getCommentParent() != null) {
                commentDTO.setParentCommentId(comment.getCommentParent().getId());
            }
            commentDTO.setCreatedAt(comment.getCreatedAt());
            commentDTO.setUpdatedAt(comment.getUpdateAt());
            return commentDTO;
        }).collect(Collectors.toList()));
        return dto;
    }

    default Post convertToEntity(PostDTO postDTO) {
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setNumberLike(postDTO.getNumberLike());
        post.setStatus(Post.postStatus.valueOf(postDTO.getStatus()));
        return post;
    }
}
