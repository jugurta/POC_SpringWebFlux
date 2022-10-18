package fr.acssi.demo.controller;


import fr.acssi.demo.entities.ResourceEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/resourceClient")
public class ResourceClientController {


    WebClient client = WebClient.create("http://localhost:8080");

    @GetMapping
    public void getResources() {
        Flux<ResourceEntity> resourceEntityFlux = client.get().uri("/resources").retrieve().bodyToFlux(ResourceEntity.class);
        resourceEntityFlux.subscribe(System.out::println);
    }

    @GetMapping(path = "{id}")
    public void getResourceById(@PathVariable int id) {
        Mono<ResourceEntity> resourceEntityMono = client.get().uri("/resources/{id}", id).retrieve().bodyToMono(ResourceEntity.class);
        resourceEntityMono.subscribe(System.out::println);

    }

}
