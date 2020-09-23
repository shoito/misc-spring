package com.example.demo.controller;
import com.google.common.io.CharStreams;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @PostMapping("/rb")
    @ResponseBody
    public String rb(HttpServletRequest servletRequest, @Validated @RequestBody Message message) {
        String body = "";

        try (BufferedReader reader = servletRequest.getReader()) {
            body = CharStreams.toString(reader);
            System.out.println(body);
            System.out.println(message.body);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return body;
    }

    @PostMapping("/sr")
    @ResponseBody
    public String sr(HttpServletRequest servletRequest, Message message) {
        String body = "";

        try (BufferedReader reader = servletRequest.getReader()) {
            body = CharStreams.toString(reader);
            System.out.println(body);
            System.out.println(message.body);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return body;
    }
}

class Message {
    public String body;
}
