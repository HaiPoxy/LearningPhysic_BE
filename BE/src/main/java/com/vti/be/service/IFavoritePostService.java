package com.vti.be.service;

import com.vti.be.dto.FavoritePostDTO;

import java.util.Optional;

public interface IFavoritePostService {
    FavoritePostDTO createFavoritePost(FavoritePostDTO favoritePostDTO);

    FavoritePostDTO updateFavoritePost(Integer id, FavoritePostDTO favoritePostDTO);

    void deleteFavoritePostById(Integer id);

    Optional<FavoritePostDTO> findFavoritePostById(Integer id);
}
