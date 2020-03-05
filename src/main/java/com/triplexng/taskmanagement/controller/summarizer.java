package com.triplexng.taskmanagement.controller;

import com.aylien.textapi.TextAPIClient;
import com.aylien.textapi.TextAPIException;

import com.aylien.textapi.parameters.ClassifyByTaxonomyParams;
import com.aylien.textapi.parameters.ClassifyParams;
import com.aylien.textapi.parameters.ConceptsParams;
import com.aylien.textapi.parameters.SentimentParams;
import com.aylien.textapi.parameters.SummarizeParams;
import com.aylien.textapi.responses.Classifications;
import com.aylien.textapi.responses.Concepts;
import com.aylien.textapi.responses.Summarize;
import com.aylien.textapi.responses.TaxonomyClassifications;
import com.triplexng.taskmanagement.persistence.model.ArticleContent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;

@RestController
@RequestMapping("text-summary")
public class summarizer {


    @GetMapping(value = "/{id}", produces = "application/json")
    public String[] getBook(@PathVariable int id) throws TextAPIException, MalformedURLException {

        String text = "Sometimes I think we’ve all seen too many apocalyptic movies about global pandemics Make no mistake, the Wuhan coronavirus outbreak is bad news For those who have lost loved ones to it, it’s a tragedy For many investors, it’s a source of major concern In addition to the impact on global travel, the Chinese provinces on virus lockdown account for almost 70% of China’s gross domestic product That means we should all be bearish on Chinese stocks, right? After all, the Shanghai stock exchange opened on Monday with a 9% drop. Not so fast Instead of panicking, let’s take a step back and see what’s happening That way, you won’t miss one of the best opportunities you’ll ever see from this massive economy";
        TextAPIClient client = new TextAPIClient("47afad3a", "1ff0073775cd9625faf2e59067ac69df");

        SummarizeParams.Builder builder = SummarizeParams.newBuilder();
        ClassifyParams.Builder builderClasify = ClassifyParams.newBuilder();
        ConceptsParams.Builder builderConcept = ConceptsParams.newBuilder();
        ClassifyByTaxonomyParams.Builder builderTaxClasify = ClassifyByTaxonomyParams.newBuilder();
        SentimentParams.Builder builderSentiments = SentimentParams.newBuilder();

        java.net.URL url = new java.net.URL("https://banyanhill.com/wuhan-virus-pushing-these-stocks-higher");
        builderClasify.setUrl(url);
        builder.setUrl(url);
        //builder.setText(text);
        builderConcept.setText(text);
        //builder.setTitle("THE WUHAN VIRUS IS PUSHING THESE STOCKS HIGHER");
        builder.setNumberOfSentences(id);

        builderTaxClasify.setText(text);
        builderTaxClasify.setTaxonomy(ClassifyByTaxonomyParams.StandardTaxonomy.IAB_QAG);

        builderSentiments.setText(text);
        builderSentiments.setMode("document");

        Summarize summary = client.summarize(builder.build());

        //builderClasify.setText(text);
        Classifications classifications = client.classify(builderClasify.build());
        Concepts concepts = client.concepts(builderConcept.build());
        TaxonomyClassifications response = client.classifyByTaxonomy(builderTaxClasify.build());



        return summary.getSentences();
        //return classifications.getCategories();
        //return concepts.getConcepts();
        //return response.getCategories();
        //return client.sentiment(builderSentiments.build());
    }

    @PostMapping("/summarize")
    public String[] summarize(@RequestBody ArticleContent articleContent) throws TextAPIException {

        TextAPIClient client = new TextAPIClient("47afad3a", "1ff0073775cd9625faf2e59067ac69df");

        SummarizeParams.Builder builder = SummarizeParams.newBuilder();

        builder.setText(articleContent.getContent());
        builder.setTitle(articleContent.getTitle());
        builder.setNumberOfSentences(articleContent.getNumSentences());

        Summarize summary = client.summarize(builder.build());

        return summary.getSentences();
    }

}
