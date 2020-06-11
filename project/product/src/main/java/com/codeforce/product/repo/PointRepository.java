package com.codeforce.product.repo;


import com.codeforce.product.model.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PointRepository extends JpaRepository<Point, Long> {
    @Query("select p from Point p where p.boxNum <> p.busy")
    ArrayList<Point> findAllFree();


}
