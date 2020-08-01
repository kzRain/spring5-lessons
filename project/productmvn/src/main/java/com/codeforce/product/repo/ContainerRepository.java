package com.codeforce.product.repo;

import com.codeforce.product.model.Cantainer;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*Alimbetov Ruslan*/
@Repository
public interface ContainerRepository extends PagingAndSortingRepository<Cantainer, Long>, JpaSpecificationExecutor<Cantainer> {

    List<Cantainer> findContainerByCountry(String country);

    List<Cantainer> findContainersByCityContaining(String city);

    List<Cantainer> findContainersByAdressContaining(String adress);


}
