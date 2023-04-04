package com.example.demo.CourseApi.Controllers;

import com.example.demo.CourseApi.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping(value = "controller")
public class GeneralController {
    @Autowired
    SlackClient slackClient;

    @GetMapping(value = "test")
    public String test(){
        return "${spring.profiles.active}";
    }

    @GetMapping(value = "slackMessage")
    public void message(@RequestParam String text){

        slackClient.sendMessage(text);
    }
}
