package com.codeforce.product.service;

import com.codeforce.product.model.Box;
import com.codeforce.product.model.Point;
import com.codeforce.product.repo.BoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BoxService {

    @Autowired
    BoxRepository boxRepository;

    public List<Box> getAllBoxes() {
        List<Box> boxList = boxRepository.findAll();
        if (boxList.size()>0) {
            return boxList;
        }
        else {
            return new ArrayList<>();
        }
    }

    public List<Box> getAllFreeBoxes() {
        List<Box> boxList = boxRepository.findAll();
        List<Box> freeBoxes = new ArrayList<>();
        if (boxList.size()>0) {
            boxList.forEach(x->{
                if (x.isFree()) {
                    freeBoxes.add(x);
                }
            });
            return freeBoxes;
        }
        else {
            return new ArrayList<>();
        }
    }
}
