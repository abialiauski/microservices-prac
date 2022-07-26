package org.micro.user.repository;

import org.micro.user.model.UserElastic;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserElasticRepository extends ElasticsearchRepository<UserElastic, String> {

    @Query("{\"query\": {\"match\": {\"username\": {\"query\":  {\"authors.name\": \"?0\"}}}}}")
    UserElastic findBySpecificNameUsingCustomQuery(String name);
}
