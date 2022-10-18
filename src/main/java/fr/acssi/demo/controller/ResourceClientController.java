package fr.acssi.demo.controller;


import fr.acssi.demo.entities.ResourceEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/resourceClient")
public class ResourceClientController {


    WebClient client = WebClient.create("http://localhost:8080");

    @GetMapping
    public void getResources() {

        Flux<ResourceEntity> resourceEntityFlux = client.get().uri("/resources").retrieve().bodyToFlux(ResourceEntity.class);

        resourceEntityFlux.subscribe(System.out::println);

    }

}
