package com.codeforce.product.repo;

import com.codeforce.product.model.Container;
import com.codeforce.product.model.Pack;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PackRepository extends CrudRepository<Pack,Long> {

    /*
    List<Pack> findByPackkey(String Packkey);
    List<Pack> findByPackkeyContainingIgnoreCase(String Packkey);
    List<Pack> findByWeigthLessThanEqual(double weigth);
    List<Pack> findByWeigthGreaterThanEqual(double weigth);
*/



}
