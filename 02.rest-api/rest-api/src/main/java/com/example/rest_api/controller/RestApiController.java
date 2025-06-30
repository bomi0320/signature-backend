package com.example.rest_api.controller;

import com.example.rest_api.model.BookQueryParam;
import com.fasterxml.jackson.databind.EnumNamingStrategies;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.random.RandomGenerator;

@Slf4j
@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping(path = "/hello")
    public String hello(){
        var html = "<html> <body> <h1> Hello Spring Boot </h1> </body> </html>";

        return html;
    }

    // http://localhost:8080/api/echo/steve/age/20/is-man/true
    @GetMapping(path = "/echo/{message}/age/{age}/is-man/{isMan}")
    public String echo(
            @PathVariable(name = "message") String msg,
            @PathVariable int age,
            @PathVariable boolean isMan
    ){
        System.out.println("echo message: " + msg);
        System.out.println("echo age: " + age);
        System.out.println("echo isMan: " + isMan);

        // TODO 대문자로 변환해서 RETURN => toUpperCase
        // String 타입의 변수 외에 다른 타입 받아보기
        // boolean, integer

        return msg.toUpperCase();
    }

    // http://localhost:8080/api/book?category=IT&issuedYear=2023&issued-month=01&issued_day=31
    @GetMapping(path = "/book")
    public void queryParam(
            @RequestParam String category,
            @RequestParam String issuedYear,
            @RequestParam(name = "issued-month") String issuedMonth,
            @RequestParam (name = "issued_day") String issuedDay
    ){
        System.out.println(category);
        System.out.println(issuedYear);
        System.out.println(issuedMonth);
        System.out.println(issuedDay);
    }

    // http://localhost:8080/api/book2?category=IT&issuedYear=2023&issuedMonth=01&issuedDay=31
    @GetMapping(path = "/book2")
    public void queryParamDto(
            BookQueryParam bookQueryParam
    ){
        System.out.println(bookQueryParam);
    }

    // TODO Parmameter 2가지 받기. int 형태로 받아서 두 수의 덧셈, 곱셈 리턴해주는 메서드 작성
    // TODO String 타입, boolean 타입 받아보기

    // http://localhost:8080/api/addition?a=3&b=4
    @GetMapping(path = "/addition")
    public void addition(
            @RequestParam int a,
            @RequestParam int b
    ){
        System.out.println(a + b);
    }

    // http://localhost:8080/api/addition?a=3&b=4
    @GetMapping(path = "/multiplication")
    public void multiplication(
            @RequestParam int a,
            @RequestParam int b
    ){
        System.out.println(a * b);
    }

    @DeleteMapping(path = {
            "/user/{userName}/delete",
            "/user/{userName}/del"
        }
    )
    public void delete(
            @PathVariable String userName
    ){
        log.info("user-name : {}", userName);
    }
}
