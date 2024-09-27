//package com.vti.be.controller;
//
//import com.vti.be.dto.FavoritePostDTO;
//import com.vti.be.service.FavoritePostService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/v1/favorite-posts")
//public class FavoritePostController {
//
//    @Autowired
//    private FavoritePostService favoritePostService;
//
//    @PostMapping
//    public ResponseEntity<FavoritePostDTO> createFavoritePost(@RequestBody FavoritePostDTO favoritePostDTO) {
//        FavoritePostDTO createdFavoritePost = favoritePostService.createFavoritePost(favoritePostDTO);
//        return new ResponseEntity<>(createdFavoritePost, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<FavoritePostDTO> updateFavoritePost(@PathVariable Integer id, @RequestBody FavoritePostDTO favoritePostDTO) {
//        FavoritePostDTO updatedFavoritePost = favoritePostService.updateFavoritePost(id, favoritePostDTO);
//        return new ResponseEntity<>(updatedFavoritePost, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteFavoritePost(@PathVariable Integer id) {
//        favoritePostService.deleteFavoritePostById(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<FavoritePostDTO> getFavoritePostById(@PathVariable Integer id) {
//        Optional<FavoritePostDTO> favoritePostDTO = favoritePostService.findFavoritePostById(id);
//        return favoritePostDTO.map(post -> new ResponseEntity<>(post, HttpStatus.OK))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//}