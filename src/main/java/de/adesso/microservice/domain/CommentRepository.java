package de.adesso.microservice.domain;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {
    public List<Comment> findByArticleID(String articleID);
}