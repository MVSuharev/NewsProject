package com.example.newsproject.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
@Api(description = "Корневой контроллер")
public class RootController {

    @ApiOperation(value = "Интерфейс Swagger")
    @GetMapping
    public String swaggerUi() {
        return "redirect:/swagger-ui.html";
    }
}