package com.challengetech.webhook.repositories;

import com.challengetech.webhook.entities.Topic;
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;

import java.util.Optional;

public interface TopicRepository extends DatastoreRepository<Topic, String> {

    Optional<Topic> findByName(String topic);
}

