package com.example.blog.objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Post")
@Table(name = "post")
@Getter
@Setter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue
    private Long id;
    private Date created;
    private Date modified;
    private String title;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id")
    private Set<PostComment> comments = new HashSet<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id")
    @OrderBy("id  asc ")
    private Set<Paragraph> paragraphs = new HashSet<>();

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,}, fetch = FetchType.EAGER)
    @JoinTable(name = "post_tags",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags = new HashSet<>();
}

