package com.challengetech.webhook.services;

import com.challengetech.webhook.entities.Synonym;
import com.challengetech.webhook.entities.Topic;
import com.challengetech.webhook.repositories.SynonymRepository;
import com.challengetech.webhook.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class WebhookService {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private SynonymRepository synonymRepository;

    public Map getResponse(String topic){
        String synonymText = getSynonym(topic);
        String actionText= StringUtils.isEmpty(synonymText)?"":getActionText(synonymText);
        return buildReply(actionText);

    }

    public Map buildReply(String info){
        Map<String,String> reply = new HashMap<>();
        if(StringUtils.isEmpty(info)){
            info="Não sei como responder a isso. Por favor tente me explicar de uma outra forma";
        }
        reply.put("fulfillmentText",info);
        return reply;
    }

    public String getSynonym(String queryText){
        Optional<Synonym> optional=synonymRepository.findByName(queryText);
        if (optional.isPresent()){
            return optional.get().getSynonym();
        }
        return "";
    }

    public String getActionText(String synonymText){
        synonymText=synonymText.trim();
        Optional<Topic> optional = topicRepository.findByName(synonymText);
        if (optional.isPresent()){
            return optional.get().getActionText();
        }
        return "";

    }





}
