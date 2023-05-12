package com.springboot.blog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category { // one Cat has multiple Posts and many Posts belong to one Cat
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    // Post class has a field called category, we use this as mappedBy
    // mappedBy tells the Hibernate that we are using 1-many bidrectional mapping and do not create additional join table
    // orphanRemoval: for child entities that don't have parent reference, they will be removed from db
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts;
}
