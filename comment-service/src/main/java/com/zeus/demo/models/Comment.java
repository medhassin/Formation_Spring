package com.zeus.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Table(name="comments")
@Getter
@Setter
public class Comment {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private Long productId;
     private String text;
     @Temporal(TemporalType.DATE)
     private LocalDate createdAt;
     @Temporal(TemporalType.DATE)
     private LocalDate updateAt;
}
