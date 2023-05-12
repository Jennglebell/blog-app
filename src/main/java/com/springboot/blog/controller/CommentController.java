package com.springboot.blog.controller;

import com.springboot.blog.payload.CommentDto;
import com.springboot.blog.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/posts/{postId}/comments")
    @Operation(
            summary = "Create Comment REST API",
            description = "Create Comment REST API is used to create a single comment and save into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 200 CREATED"
    )
    public ResponseEntity<CommentDto> createComment(@PathVariable(value = "postId") long postId,
                                                    @Valid @RequestBody CommentDto commentDto) {
        return new ResponseEntity<>(commentService.createComment(postId, commentDto), HttpStatus.CREATED);
    }

    @GetMapping("/posts/{postId}/comments")
    @Operation(
            summary = "Get All Comments REST API",
            description = "Get All Comments REST API is used to get all comments from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    public List<CommentDto> getCommentsByPostId(@PathVariable(value = "postId") long postId) {
        return commentService.getAllCommentsByPostId(postId);
    }

    @GetMapping("/posts/{postId}/comments/{id}")
    @Operation(
            summary = "Get Comment By Id REST API",
            description = "Get Comment By Id REST API is used to get a single comment by id from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    public ResponseEntity<CommentDto> getCommentById(@PathVariable(value = "postId") Long postId,
                                                     @PathVariable(value = "id") Long commentId) {
        CommentDto commentDto = commentService.getCommentById(postId, commentId);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }

    @PutMapping("/posts/{postId}/comments/{id}")
    @Operation(
            summary = "Update Comment By Id REST API",
            description = "Update Comment By Id REST API is used to update a single comment by id from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    public ResponseEntity<CommentDto> updateCommentById(@PathVariable(value = "postId") Long postId,
                                                        @PathVariable(value = "id") Long commentId,
                                                        @Valid @RequestBody CommentDto commentDto) {
        CommentDto updatedComment = commentService.updateCommentById(postId, commentId, commentDto);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }

    @DeleteMapping("/posts/{postId}/comments/{id}")
    @Operation(
            summary = "Delete Comment By Id REST API",
            description = "Delete Comment By Id REST API is used to delete a single comment by id from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    public ResponseEntity<String> deleteComment(@PathVariable(value = "postId") Long postId,
                                                 @PathVariable(value = "id") Long commentId) {
        commentService.deleteComment(postId, commentId);
        return new ResponseEntity<>("Comment deleted successfully", HttpStatus.OK);
    }
}
