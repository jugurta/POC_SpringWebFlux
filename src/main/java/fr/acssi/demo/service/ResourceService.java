package fr.acssi.demo.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.acssi.demo.controller.exceptions.ResourceNotFoundException;
import fr.acssi.demo.entities.ResourceEntity;
import fr.acssi.demo.repository.ResourceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;


@Service
@Slf4j
public class ResourceService {

    @Autowired
    ResourceRepository resourceRepository;

    public ResourceEntity save(ResourceEntity resourceEntity) {
        return resourceRepository.save(resourceEntity);


    }

    public ResourceEntity findResourceById(Integer id) {

        Optional<ResourceEntity> resource = resourceRepository.findById(id);
        if (resource.isEmpty())
            throw new ResourceNotFoundException();
        return resource.get();
    }

    public List<ResourceEntity> findAllResources() {
        return resourceRepository.findAll();
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

}
