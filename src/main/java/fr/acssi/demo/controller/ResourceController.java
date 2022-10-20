package fr.acssi.demo.controller;


import fr.acssi.demo.entities.ResourceEntity;
import fr.acssi.demo.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/resources")
public class ResourceController {


    @Autowired
    ResourceService resourceService;

    @PostMapping
    public ResponseEntity<ResourceEntity> createResource(@RequestBody ResourceEntity resourceEntity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(resourceService.save(resourceEntity));

    }

    @GetMapping(path = "{id}")
    public ResponseEntity<ResourceEntity> getResourceById(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(resourceService.findResourceById(id));

    }


    @GetMapping
    public ResponseEntity<List<ResourceEntity>> getAllResources() {
        return ResponseEntity.status(HttpStatus.OK).body(resourceService.findAllResources());
    }


    @PutMapping
    public void createRandomResources() {
        resourceService.createRandomResources();
    }
}
