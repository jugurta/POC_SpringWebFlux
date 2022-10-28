package fr.acssi.demo.router;

import fr.acssi.demo.entities.ResourceEntity;
import fr.acssi.demo.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;

import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class ResourceRouter {

    @Autowired
    ResourceService resourceService;

    @Bean
    public RouterFunction<ServerResponse> getResourcesRoute() {
        return route(GET("/resources"),
                request -> ok().contentType(MediaType.TEXT_EVENT_STREAM).body(resourceService.findAllResources(), ResourceEntity.class));
    }


    @Bean
    public RouterFunction<ServerResponse> getResourceRoute() {
        return route(GET("/resources/{id}"),
                request -> {
                    Integer id = Integer.parseInt(request.pathVariable("id"));
                    return ok().body(resourceService.findResourceById(id), ResourceEntity.class);
                });;
    }

}
;