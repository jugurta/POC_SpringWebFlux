package fr.acssi.demo.service;


import fr.acssi.demo.entities.ResourceEntity;
import fr.acssi.demo.repository.ResourceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Random;


@Service

public class ResourceService {
    public Mono<ResourceEntity> save(ResourceEntity resourceEntity) {
        return resourceRepository.save(resourceEntity);
    }


    @Autowired
    ResourceRepository resourceRepository;

    public Mono<ResourceEntity> findResourceById(Integer id) {

        Mono<ResourceEntity> resource = resourceRepository.findById(id);
        return resource;
    }
    public void createRandomResources()
    {
        for (int i=0;i<200; i++)
        {
            Random r = new Random();
            ResourceEntity resourceEntity = new ResourceEntity();
            resourceEntity.setSequence(r.nextInt());
            resourceEntity.setName(r.nextInt()+"");
            resourceEntity.setState(r.nextInt());
            resourceRepository.save(resourceEntity);
        }
    }

    public Flux<ResourceEntity> findAllResources() {
        return resourceRepository.findAll();
    }

}
