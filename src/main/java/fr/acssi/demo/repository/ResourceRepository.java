package fr.acssi.demo.repository;

import fr.acssi.demo.entities.ResourceEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ResourceRepository extends ReactiveMongoRepository<ResourceEntity,Integer> {

    Flux<ResourceEntity> findAll();
}
