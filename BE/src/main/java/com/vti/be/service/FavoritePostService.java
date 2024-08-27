package com.vti.be.service;


import com.vti.be.dto.FavoritePostDTO;
import com.vti.be.entity.FavoritePost;
import com.vti.be.repository.FavoritePostRepository;
import com.vti.be.repository.IAccountRepository;
import com.vti.be.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FavoritePostService implements IFavoritePostService {

    @Autowired
    private FavoritePostRepository favoritePostRepository;

    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public FavoritePostDTO createFavoritePost(FavoritePostDTO favoritePostDTO) {
        FavoritePost favoritePost = convertToEntity(favoritePostDTO);
        FavoritePost savedFavoritePost = favoritePostRepository.save(favoritePost);
        return convertToDTO(savedFavoritePost);
    }

    @Override
    public FavoritePostDTO updateFavoritePost(Integer id, FavoritePostDTO favoritePostDTO) {
        Optional<FavoritePost> existingFavoritePost = favoritePostRepository.findById(id);
        if (existingFavoritePost.isPresent()) {
            FavoritePost favoritePost = existingFavoritePost.get();
            favoritePost.setAccount(accountRepository.findById(favoritePostDTO.getAccountId())
                    .orElseThrow(() -> new RuntimeException("Account not found")));
            favoritePost.setPost(postRepository.findById(favoritePostDTO.getPostId())
                    .orElseThrow(() -> new RuntimeException("Post not found")));
            FavoritePost updatedFavoritePost = favoritePostRepository.save(favoritePost);
            return convertToDTO(updatedFavoritePost);
        } else {
            throw new RuntimeException("FavoritePost with id " + id + " not found.");
        }
    }

    @Override
    public void deleteFavoritePostById(Integer id) {
        if (favoritePostRepository.existsById(id)) {
            favoritePostRepository.deleteById(id);
        } else {
            throw new RuntimeException("FavoritePost with id " + id + " not found.");
        }
    }

    @Override
    public Optional<FavoritePostDTO> findFavoritePostById(Integer id) {
        return favoritePostRepository.findById(id)
                .map(this::convertToDTO);
    }

    private FavoritePostDTO convertToDTO(FavoritePost favoritePost) {
        FavoritePostDTO dto = new FavoritePostDTO();
        dto.setId(favoritePost.getId());
        dto.setAccountId(favoritePost.getAccount().getId());
        dto.setPostId(favoritePost.getPost().getId());
        return dto;
    }

    private FavoritePost convertToEntity(FavoritePostDTO favoritePostDTO) {
        FavoritePost favoritePost = new FavoritePost();
        favoritePost.setAccount(accountRepository.findById(favoritePostDTO.getAccountId())
                .orElseThrow(() -> new RuntimeException("Account not found")));
        favoritePost.setPost(postRepository.findById(favoritePostDTO.getPostId())
                .orElseThrow(() -> new RuntimeException("Post not found")));
        return favoritePost;
    }
}
