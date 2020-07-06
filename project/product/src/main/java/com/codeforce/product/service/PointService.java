package com.codeforce.product.service;

import com.codeforce.product.model.Box;
import com.codeforce.product.model.Pack;
import com.codeforce.product.model.Point;
import com.codeforce.product.repo.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class PointService {
    
   @Autowired
   PointRepository pointRepository;

   public ArrayList<Point> getAllFree() {
        return pointRepository.findAllFree();
   }

   public void addPackToBox(Pack pack, Point point) {
       if (point.getBoxes().size() < point.getBoxNum()) {
           Set<Box> boxesSet = point.getBoxes();
           for (Box box : boxesSet) {
               if (box.isFree()) {
                   box.setPack(pack);
                   box.setFree(false);
                   break;
               } else {
                   return;
               }
           }
       }
   }

}
