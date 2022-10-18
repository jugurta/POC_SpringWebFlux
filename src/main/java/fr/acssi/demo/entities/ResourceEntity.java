package fr.acssi.demo.entities;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResourceEntity {

    @Id
    Integer sequence;
    String name;
    Integer state;
}
