package com.codeforce.product.service;

import com.codeforce.product.model.*;
import com.codeforce.product.repo.PackRepository;
import com.codeforce.product.repo.PointRepository;

import com.codeforce.product.repo.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PointService {

    @Autowired
    PointRepository pointRepository;

    @Autowired
    StateRepository stateRepository;
    
    @Autowired
    PackRepository packRepository;
    
    public ArrayList<Point> getAllFree() {
        return pointRepository.findAllFree();
    }

    public void addPackToBox(Point point, Cantainer container){
        if (point.getBoxes().stream().filter(b-> b.isFree()).count()>0 
                && container.getPacks().stream().filter( p-> p.getState().getState().equals("RAPRED")).count()>0 ){

            
            State mysate = stateRepository.findDistinctFirstByStateContaining("ForInform").get();

            for (Pack pack: container.getPacks().stream().filter( p-> p.getState().getState().equals("RAPRED")).collect(Collectors.toList()) ){
                for (Box box: point.getBoxes().stream().filter(b-> b.isFree()).collect(Collectors.toList())){
                    if (box.isFree()){
                        box.setPack(pack);
                        box.setFree(false);;
                        pack.setState(mysate);
                    }
                }
                if ( pack.getState().equals("ForInform")){
                    packRepository.save(pack);
                }
                
            }
            pointRepository.save(point);
           
        }
        
        
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
