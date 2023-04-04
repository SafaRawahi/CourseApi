package com.example.demo.CourseApi.Slack;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;


@Component
public class SlackClient {

    public String sendMessage(String text) {

        return "Done";

//                WebClient.create().post()
//                .uri("https://hooks.slack.com/services/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")
//                .contentType(MediaType.APPLICATION_JSON)
//                .bodyValue(new SlackPayload(text))
//                .retrieve()
//                .bodyToMono(String.class)
//                .block();
    }
}
