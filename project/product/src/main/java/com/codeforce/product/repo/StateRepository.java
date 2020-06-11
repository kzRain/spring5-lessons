package com.codeforce.product.repo;

import com.codeforce.product.model.Container;
import com.codeforce.product.model.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StateRepository extends CrudRepository<State,Long> {
/*

 List<State> findByState(String state);

 List<State> findByStateContainingIgnoreCase(String state);
*/
}
