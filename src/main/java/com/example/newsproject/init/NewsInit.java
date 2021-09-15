package com.example.newsproject.init;

import com.example.newsproject.model.News;
import com.example.newsproject.repository.NewsRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Component
public class NewsInit implements ApplicationRunner {

    private NewsRep newsRep;

    private static final DateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy HH:mm");

    @Autowired
    public NewsInit(NewsRep newsRep) {
        this.newsRep = newsRep;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        long count = newsRep.count();

        if (count == 0) {
            News news1 = new News("Тестовая новость 1", "Текст тестовой новости 1", "Автор 1", dateFormat.parse("14.09.2021 20:25"));
            News news2 = new News("Тестовая новость 2", "Текст тестовой новости 2", "Автор 2", dateFormat.parse("14.09.2021 20:27"));
            News news3 = new News("Тестовая новость 3", "Текст тестовой новости 3", "Автор 3", dateFormat.parse("14.09.2021 20:28"));

            newsRep.save(news1);
            newsRep.save(news2);
            newsRep.save(news3);
        }
    }
}
