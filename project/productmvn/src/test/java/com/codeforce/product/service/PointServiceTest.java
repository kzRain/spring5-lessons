package com.codeforce.product.service;

import com.codeforce.product.model.Box;
import com.codeforce.product.model.Cantainer;
import com.codeforce.product.model.Pack;
import com.codeforce.product.model.Point;
import com.codeforce.product.model.State;
import com.codeforce.product.repo.*;
import com.codeforce.product.utils.Form_UI;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.Optional;
import java.util.Set;

public class PointServiceTest {


    @Autowired
    private ContainerRepository containerRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private BoxRepository boxRepository;

    @Autowired
    private PackRepository packRepository;

    @Autowired
    private PointRepository pointRepository;

    @Autowired
    private PointService pointService;

    private Cantainer cantainer;

    private Point point;

    @BeforeAll
    public void setUp() {

        cantainer = new Cantainer(Form_UI.getCountryList().get(12), "Almaty", "Abay 12", "123");
        cantainer = containerRepository.save(cantainer);

        State state = new State();
        state.setDescription("Поступил к распределению");
        state.setState("RAPRED");
        stateRepository.save(state);

        State state2 = new State();
        state2.setDescription("Распределен");
        state2.setState("ForInform");
        stateRepository.save(state2);

        State mysate = stateRepository.findDistinctFirstByStateContaining("RAPRED").get();

        Pack pack1 = new Pack();
        pack1.setWeigth(15);
        pack1.setPackKey("packet0001");
        pack1.setState(mysate);
        pack1.setCantainer(cantainer);
        packRepository.save(pack1);

      Point point= new Point();

       Set<Box> pointBoxes= point.getBoxes();
        if (pointBoxes.size()==0){
            pointBoxes.add(new Box());
            pointBoxes.add(new Box());
            pointBoxes.add(new Box());
            pointBoxes.add(new Box());
            pointBoxes.add(new Box());
        }
        point.setBoxes(pointBoxes);
        point=pointRepository.save(point);

    }

    @Test
    public void raspredContainer(){


        long freeBefor = point.getBoxes().stream().filter(b-> b.isFree()).count();
        
        pointService.addPackToBox(point,cantainer);
        long after = point.getBoxes().stream().filter(b-> b.isFree()).count();

        System.out.println("freeBefor"+freeBefor+"|"+"after"+after);
//        //Create Pack
//        Integer expectedPointFreeBox = pointService.freeBox() - container.packs.size();
//        pointService.raspred(point, container);
//        Integer pointFreeBox = pointService.freeBox();
//        Assert.isTrue(expectedPointFreeBox==pointFreeBox, "Неверное распределение пакетов на точке");
//
    }

    @AfterAll
    public void end() {

    }
}
