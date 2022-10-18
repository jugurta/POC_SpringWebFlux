package fr.acssi.demo.service;


import fr.acssi.demo.entities.ResourceEntity;
import fr.acssi.demo.repository.ResourceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service

public class ResourceService {
    public void save(ResourceEntity resourceEntity) {
        resourceRepository.save(resourceEntity).subscribe();
    }


    @Autowired
    ResourceRepository resourceRepository;

    public Mono<ResourceEntity> findResourceById(Integer id) {

        Mono<ResourceEntity> resource = resourceRepository.findById(id);
        return resource;
    }
    public void createMultipeResources()
    {
        for (int i=0; i<200; i++)
        {
        ResourceEntity resourceEntity = new ResourceEntity();
        resourceEntity.setSequence(i);
        resourceEntity.setName(i+"");
        resourceEntity.setState(i);
        resourceRepository.save(resourceEntity).subscribe();
        }
    }

    public Flux<ResourceEntity> findAllResources() {
        return resourceRepository.findAll();
    }

}
