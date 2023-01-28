package entities.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Category {

    private Integer id;
    private String name;
}
