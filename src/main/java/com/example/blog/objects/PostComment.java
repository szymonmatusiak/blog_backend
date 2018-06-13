package com.example.blog.objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "PostComment")
@Table(name = "post_comment")
@Getter
@Setter
@NoArgsConstructor
public class PostComment {

    @Id
    @GeneratedValue
    private Long id;

    private String review;

}
