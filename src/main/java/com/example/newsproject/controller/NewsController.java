package com.example.newsproject.controller;

import com.example.newsproject.model.News;
import com.example.newsproject.repository.NewsRep;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("/news")
@Api(description = "Контроллер Новостей")
public class NewsController {

    private final NewsRep newsRep;

    public NewsController(NewsRep newsRep) {
        this.newsRep = newsRep;
    }

    @ApiOperation(value = "Запрос списка новостей")
    @GetMapping
    public ResponseEntity getNewsList() {
        try {
            return ResponseEntity.ok(newsRep.findAll());
        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().body("Ошибка при запросе списка новостей: " + ex.getMessage());
        }
    }

    @ApiOperation(value = "Запрос одной новости")
    @GetMapping("/{id}")
    public ResponseEntity getNewsById(@ApiParam("ИД новости") @PathVariable Long id) {
        try {
            return ResponseEntity.ok(newsRep.findById(id).get());
        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().body("Ошибка при запросе новости: " + ex.getMessage());
        }
    }

    @ApiOperation(value = "Публикация новости")
    @PostMapping
    public ResponseEntity createNews(@ApiParam("Данные для создания новости") @RequestBody News news) {
        try {
            newsRep.save(new News(news.getTitle(), news.getBody(), news.getAuthor(), new Date()));
            return ResponseEntity.ok("Новость успешно опубликована!");
        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().body("Ошибка при публикации новости: " + ex.getMessage());
        }
    }

    @ApiOperation(value = "Удаление новости")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteNews(@ApiParam("ИД новости") @PathVariable Long id) {
        try {
            newsRep.deleteById(id);
            return ResponseEntity.ok("Новость успешно удалена!");
        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().body("Ошибка при создании новости: " + ex.getMessage());
        }
    }
}
