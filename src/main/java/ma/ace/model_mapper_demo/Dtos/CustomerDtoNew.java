package ma.ace.model_mapper_demo.Dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CustomerDtoNew {
    String name;
    String email;
    String password;
}
