package com.codeforce.product.repo;

import com.codeforce.product.model.Container;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContainerRepository extends CrudRepository<Container, Long> {

    /*
    List<Container> findByCountry(String title);

    List<Container> findByAdress(String adress);

    List<Container> findByAdressContainingIgnoreCase(String adress);
*/

}
