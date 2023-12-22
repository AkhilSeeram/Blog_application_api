package com.scaler.BlogapiApplication.articles;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
public class ArticlesController {
    @GetMapping("")
    ResponseEntity<String> getAllArticles(){
        return ResponseEntity.accepted().body("these are articles");
    }
    @GetMapping("/{id}")
    ResponseEntity<Void> getArticleById(){
        return null;
    }

    @PostMapping("")
    ResponseEntity<String> createArticle(){

        return ResponseEntity.accepted().body("Article created succesfull");
    }

    @PatchMapping("/{id}")
    ResponseEntity<Void> updateArticle(){
        return null;
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteArticle(){
        return null;
    }

    @PutMapping("/{id}/like")
    ResponseEntity<Void> likeArticle(){
        return null;
    }

    @DeleteMapping("/{id}/like")
    ResponseEntity<Void> unlikeArticle(){
        return null;
    }
}
