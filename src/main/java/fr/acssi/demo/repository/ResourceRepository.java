package fr.acssi.demo.repository;

import fr.acssi.demo.entities.ResourceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends MongoRepository<ResourceEntity,Integer> {
}
