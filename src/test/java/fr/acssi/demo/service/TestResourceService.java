package fr.acssi.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.acssi.demo.entities.ResourceEntity;
import fr.acssi.demo.repository.ResourceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import java.util.Optional;

public class TestResourceService {

    @Mock
    ResourceRepository resourceRepository;



    @InjectMocks
    private ResourceService resourceService;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void TestMapping() throws Exception {

        ResourceEntity resource = new ResourceEntity(1, "2", 3);

        Mockito.doReturn(resource).when(resourceRepository).save(resource);
        ResourceEntity testResourceEntity = resourceService.save(resource);
        Assertions.assertEquals(resource.getName(), testResourceEntity.getName());
        Assertions.assertEquals(resource.getSequence(), testResourceEntity.getSequence());
        Assertions.assertEquals(resource.getState(), testResourceEntity.getState());

    }


    @Test
    public void testFinding() {
        ResourceEntity resource = new ResourceEntity(1, "2", 3);
        Mockito.doReturn(Optional.of(resource)).when(resourceRepository).findById(1);
        ResourceEntity testResourceEntity = resourceService.findResourceById(1);
        Assertions.assertEquals(resource.getName(), testResourceEntity.getName());
        Assertions.assertEquals(resource.getSequence(), testResourceEntity.getSequence());
        Assertions.assertEquals(resource.getState(), testResourceEntity.getState());
    }

}
