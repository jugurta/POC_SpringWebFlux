package fr.acssi.demo.controller;


import fr.acssi.demo.entities.ResourceEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;

@RestController
@RequestMapping("/resourceClient")
public class ResourceClientController {

    final static String URL = "http://localhost:8080/resources";
    @GetMapping
    public void getResources() {
        RestTemplate restTemplate = new RestTemplate();
        Arrays.stream(restTemplate.getForEntity(URL, ResourceEntity[].class).getBody()).forEach(System.out::println);

    }


    @GetMapping(path = "{id}")
    public void getResourceById(@PathVariable int id) {
        RestTemplate restTemplate = new RestTemplate();
        ResourceEntity resourceEntity = restTemplate.getForEntity(UriComponentsBuilder.fromHttpUrl(URL).path("/{id}").build(id).toString(),ResourceEntity.class).getBody();
        System.out.println(resourceEntity);

    }

}
