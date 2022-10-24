package fr.acssi.demo.service;

import fr.acssi.demo.entities.ResourceEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TestResourceServiceWithoutMocks {



    @Autowired
    ResourceService resourceService;

    @Test
    public void testCreation()
    {
        ResourceEntity resource = new ResourceEntity(1, "2", 3);
        ResourceEntity testResource = resourceService.save(resource);
        Assertions.assertEquals(resource.getName(), testResource.getName());
        Assertions.assertEquals(resource.getSequence(), testResource.getSequence());
        Assertions.assertEquals(resource.getState(), testResource.getState());
    }
}
