package fr.acssi.demo.controller;


import fr.acssi.demo.entities.ResourceEntity;
import fr.acssi.demo.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/resources")
public class ResourceController {

    @Autowired
    ResourceService resourceService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createResource(@RequestBody ResourceEntity body) {
        resourceService.save(body);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void createMultipleResource() {
        resourceService.createRandomResources();
    }

    @GetMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ResourceEntity> getResourceById(@PathVariable int id) {
        return resourceService.findResourceById(id);
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Flux<ResourceEntity> getAllResources() {
        return resourceService.findAllResources();
    }


}
