package fr.acssi.demo.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceEntity {

    @Id
    Integer sequence;
    String name;
    Integer state;
}
