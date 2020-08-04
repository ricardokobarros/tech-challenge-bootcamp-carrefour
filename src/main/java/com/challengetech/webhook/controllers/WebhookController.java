package com.challengetech.webhook.controllers;

import com.challengetech.webhook.services.WebhookService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WebhookController {

    @Autowired
    private WebhookService service;
    @PostMapping("/webhook/")
    public HttpEntity handle(@RequestBody String payload) {

        try {
            JsonObject json = new Gson().fromJson(payload, JsonObject.class);

            String topic = json.getAsJsonObject("queryResult")
                    .getAsJsonObject("parameters")
                    .getAsJsonPrimitive("Topic").getAsString();

            return ResponseEntity.ok().body(service.getResponse(topic));
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }


    }
}
