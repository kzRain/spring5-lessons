package com.codeforce.product.config;

import com.codeforce.product.model.*;
import com.codeforce.product.repo.ContainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class Dbunit {

    @Autowired
    ContainerRepository containerRepository;

    @PostConstruct
    public void pointInit() {

        Container container = new Container();
        container.setCountry("Kazakhstan");
        container.setCity("Almaty");
        container.setAdress("Mendikulova");
        container.setQnumber("2412342134vrvrv34545334gtrbgrtbgrt");

        State state = new State();
        state.setState("Delivered to Container " + container.getCountry() + " " + container.getCity() + " " + container.getAdress());
        state.setDescription("Awaiting transportation to Point");

        Pack pack = new Pack();
        pack.setContainer(container);
        pack.setPackKey("DE-KZ Air-Delivery");
        pack.setWeigth(10.0);
        pack.setState(state);

        container.addPack(pack);

        Point point = new Point();
        point.setContainer(container);
        point.setBoxNum(10);
        point.setAddress("Nazarbayev street");
        point.setToken(UUID.randomUUID());
        point.setBusy(0);
        point.setNum("1");

        Set<Box> boxes = new HashSet<>(point.getBoxNum());
        for (int i = 0; i < point.getBoxNum(); i++) {
            Box box = new Box();
            box.setPoint(point);
            box.setUuid(UUID.randomUUID());
            boxes.add(box);
        }
        point.setBoxes(boxes);

        Set<Point> points = new HashSet<>();
        points.add(point);
        container.setPoints(points);

        containerRepository.save(container);
    }
}
