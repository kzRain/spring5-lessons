package com.codeforce.product.config;

import com.codeforce.product.model.Point;
import com.codeforce.product.repo.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Service
public class Dbunit {

    @Autowired
    PointRepository pointRepository;

    @PostConstruct
    public void pointInit(){
        Point point = new Point(null,"123", "Almaty", 30, 30 , UUID.randomUUID());
        pointRepository.save(point);
        pointRepository.save(new Point(null,"234", "Almaty", 70, 30, UUID.randomUUID() ));
    }
}
