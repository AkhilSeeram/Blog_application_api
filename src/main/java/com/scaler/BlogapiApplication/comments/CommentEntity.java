package com.scaler.BlogapiApplication.comments;

import com.scaler.BlogapiApplication.articles.ArticleEntity;
import com.scaler.BlogapiApplication.common.BaseEntity;
import com.scaler.BlogapiApplication.users.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
@Entity(name = "comments")
public class CommentEntity extends BaseEntity {
    @Column(length = 100)
    String title;
    @Column(nullable = false,length = 1000)
    String body;

    @ManyToOne
    UserEntity author;
    @ManyToOne
    ArticleEntity article;

}
