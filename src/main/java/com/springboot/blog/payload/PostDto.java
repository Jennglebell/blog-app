package com.springboot.blog.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
@Schema(
        description = "PostDto Model Information"
)
public class PostDto {
    private Long id;

    // title should not be null or empty
    // title should have at least 2 characters
    @NotEmpty
    @Size(min = 2, message = "Post title should have at least 2 characters")
    @Schema(
            description = "Bolg Post Title"
    )
    private String title;

    // post content should not be null or empty
    @NotEmpty
    @Schema(
            description = "Blog Post Content"
    )
    private String content;

    // post description should not be null or empty
    // post description should have at least 10 characters
    @NotEmpty
    @Size(min = 10, message = "Post description should have at least 10 characters")
    @Schema(
            description = "Blog Post Description"
    )
    private String description;

    @Schema(
            description = "Blog Post Comments"
    )
    private Set<CommentDto> comments;

    @Schema(
            description = "Blog Post Category"
    )
    private Long categoryId;
}