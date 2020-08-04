package com.challengetech.webhook.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Field;
import org.springframework.data.annotation.Id;

@Entity(name = "Topic")
@Getter
@Setter
@NoArgsConstructor
public class Topic {

    @Id
    private String name;

    @Field(name = "action_text")
    private String actionText;


}
