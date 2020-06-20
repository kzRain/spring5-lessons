package com.codeforce.product.repo;
import com.codeforce.product.model.State;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
/*Alimbetov Ruslan*/


@Repository
public interface StateRepository extends PagingAndSortingRepository<State, Long>,
        JpaSpecificationExecutor<State> {

    Optional<State>  findDistinctFirstByStateContaining(String state);


}

