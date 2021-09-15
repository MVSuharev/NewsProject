package com.example.newsproject.repository;

import com.example.newsproject.model.News;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NewsRep extends CrudRepository<News, Long> {

}
