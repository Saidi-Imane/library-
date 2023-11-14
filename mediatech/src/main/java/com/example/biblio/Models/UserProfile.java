package com.example.biblio.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Entity
@Table(name = "userProfile")
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile implements Serializable
{
    @Id
    @GeneratedValue
    private int id;
    private String avatar;
    private String telephone;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
