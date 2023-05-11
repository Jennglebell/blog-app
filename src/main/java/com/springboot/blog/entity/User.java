package com.springboot.blog.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles", // thrid table name is users_roles
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), // we have given the column name as user_id, and this user_id is referring to the primary key of this users table
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id") // id here refers to roles table id
    )
    private Set<Role> roles;
}
