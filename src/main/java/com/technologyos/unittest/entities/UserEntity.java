package com.technologyos.unittest.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
@Table(name="users")
public class UserEntity implements Serializable {
   @Serial
   private static final long serialVersionUID = 5313493413859894403L;

   @Id
   @GeneratedValue
   private long id;

   @Column(nullable = false, unique = true)
   private String userId;

   @Column(nullable = false, length = 50)
   private String firstName;

   @Column(nullable = false, length = 50)
   private String lastName;

   @Column(nullable = false, length = 120, unique = true)
   private String email;

   @Column(nullable = false)
   private String encryptedPassword;

}
