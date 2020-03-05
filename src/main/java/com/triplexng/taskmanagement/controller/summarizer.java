package com.triplexng.taskmanagement.controller;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("text-summary")
public class summarizer {


    @GetMapping(value = "/{id}", produces = "application/json")
    public String getBook(@PathVariable String id) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://aylien-text.p.rapidapi.com/extract?url=http%253A%252F%252Ftechcrunch.com%252F2014%252F02%252F27%252Faylien-launches-text-analysis-api-to-help-developers-extract-meaning-from-documents%252F")
                .get()
                .addHeader("x-rapidapi-host", "aylien-text.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "bf48e78de8mshd5af01214e80da1p1f3047jsn3db1667cedf9")
                .build();

        Response response = client.newCall(request).execute();
        return response.message();
    }

}
