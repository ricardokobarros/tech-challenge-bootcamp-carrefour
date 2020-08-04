package com.challengetech.webhook.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

@Entity(name = "Synonym")
@Getter
@Setter
@NoArgsConstructor
public class Synonym {

    @Id
    private String name;

    private String synonym;


}
