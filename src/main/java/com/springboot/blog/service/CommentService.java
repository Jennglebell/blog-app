package com.springboot.blog.service;

import com.springboot.blog.payload.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto);

    List<CommentDto> getAllCommentsByPostId(long postId);

    CommentDto getCommentById(Long postId, long commentId);

    CommentDto updateCommentById(Long postId, long commentId, CommentDto commentRequest);

    void deleteComment(Long postId, long commentId);
}
