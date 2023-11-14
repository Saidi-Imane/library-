package com.example.biblio.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "user")
public class User implements Serializable {
    @Id
    private int userId;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @ManyToMany
    @JoinTable(name = "user_roles",joinColumns = @JoinColumn(name = "userId"),
    inverseJoinColumns = @JoinColumn(name = "roleId")
    )
    private List<Role> roles;
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private UserProfile profile;

}
