package org.micro.user.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(indexName = "crud")
public class UserElastic {

    @Id
    private String id;
    private String name;
}
