package com.scaler.BlogapiApplication.comments;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles/{articleId}/comments")
public class CommentsController {
}
