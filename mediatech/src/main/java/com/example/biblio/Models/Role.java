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
@Table(name = "role")
public class Role implements Serializable {
    @Id
    private int roleId;
    @Column(nullable = false)
    private String name;
    @ManyToMany
    @JoinTable(name = "user_roles",joinColumns = @JoinColumn(name = "roleId"),
            inverseJoinColumns = @JoinColumn(name = "userId")
    )
    private List<User> users;

}
