package com.codeforce.product.service;

import com.codeforce.product.model.Point;
import com.codeforce.product.repo.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PointService {
    
   @Autowired
   PointRepository pointRepository;

    public ArrayList<Point> getAllFree() {
        return pointRepository.findAllFree();
    }



    public void addBoxToPoint(Point point, int i) {
        Point point_1 = pointRepository.findById(point.getId()).get();
        if(point_1.getBoxNum() >= point_1.getBusy() + i){
            point_1.setBusy(point_1.getBusy() + i);
        }
        pointRepository.save(point_1);
    }


    public boolean check_token_exists(Point point) {
        ArrayList<Point> list = (ArrayList<Point>) pointRepository.findAll();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getToken().equals(point.getToken())){
                return true;
            }
        }
        return false;
    }
}
