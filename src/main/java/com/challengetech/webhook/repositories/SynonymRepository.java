package com.challengetech.webhook.repositories;

import com.challengetech.webhook.entities.Synonym;
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;

import java.util.Optional;

public interface SynonymRepository extends DatastoreRepository<Synonym, String> {

    Optional<Synonym> findByName(String synonym);
}

