package com.codeforce.product.repo;

import com.codeforce.product.model.Container;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/*Alimbetov Ruslan*/
@Repository
public interface ContainerRepository  extends PagingAndSortingRepository<Container, Long>, JpaSpecificationExecutor<Container> {

     List<Container>   findContainerByCountry(String country);

     List<Container> findContainersByCityContaining(String city);

     List<Container> findContainersByAdressContaining(String adress);



}
