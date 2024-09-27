//package com.vti.be.controller;
//
//import com.vti.be.dto.CommentDTO;
//import com.vti.be.form.CommentCreateForm;
//import com.vti.be.service.ICommentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/v1/comments")
//public class CommentController {
//
//    @Autowired
//    private ICommentService commentService;
//
//    @GetMapping
//    public ResponseEntity<Page<CommentDTO>> getAllComments(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size,
//            @RequestParam(defaultValue = "createdAt") String sortBy,
//            @RequestParam(defaultValue = "desc") String sortDir) {
//        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
//        Pageable pageable = PageRequest.of(page, size, sort);
//        Page<CommentDTO> comments = commentService.getAllComments(pageable);
//        return new ResponseEntity<>(comments, HttpStatus.OK);
//    }
//
//    @PostMapping
//    public ResponseEntity<CommentDTO> createComment(@RequestBody CommentCreateForm commentDTO) {
//        CommentDTO createdComment = commentService.createComment(commentDTO);
//        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<CommentDTO> updateComment(@PathVariable Integer id, @RequestBody CommentDTO commentDTO) throws Exception {
//        CommentDTO updatedComment = commentService.updateComment(id, commentDTO);
//        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteComment(@PathVariable Integer id) throws Exception {
//        commentService.deleteCommentById(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<CommentDTO> getCommentById(@PathVariable Integer id) {
//        Optional<CommentDTO> commentDTO = commentService.findCommentById(id);
//        return commentDTO.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//}
