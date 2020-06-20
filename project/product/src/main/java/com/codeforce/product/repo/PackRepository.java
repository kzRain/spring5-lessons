package com.codeforce.product.repo;

import com.codeforce.product.model.Container;
import com.codeforce.product.model.Pack;
import com.codeforce.product.model.State;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/*Alimbetov Ruslan*/
@Repository
public interface PackRepository extends PagingAndSortingRepository<Pack, Long>, JpaSpecificationExecutor<Pack> {

    List<Pack> findAllByState(State mySate);

    List<Pack> findAllByContainer(Container myContainer);

    List<Pack> findAllByWeigthGreaterThanEqualAndState(Double weight, State mystate);

    List<Pack> findAllByWeigthLessThanEqualAndState(Double weight, State mystate);

    Optional<Pack> findPackByPackkey(String packkey);





}
