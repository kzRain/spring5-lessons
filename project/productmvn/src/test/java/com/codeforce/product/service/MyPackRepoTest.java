package com.codeforce.product.service;


import com.codeforce.product.model.Cantainer;
import com.codeforce.product.model.Pack;
import com.codeforce.product.model.State;
import com.codeforce.product.repo.ContainerRepository;
import com.codeforce.product.repo.StateRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MyPackRepoTest {

    @Autowired
    PackService packService;

    @Autowired
    ContainerRepository containerRepository;

    @Autowired
    ContainerService containerService;

    @Autowired
    StateRepository stateRepository;

    @Autowired
    com.codeforce.product.service.StateService StateService;


    @Test
    public void StateRepoSaveTest() {

        State myState1 = new State("Status1");
        State myState2 = new State("Status2");
        State myState3 = new State("Status3");
        State myState4 = new State("Status4");
        State myState5 = new State("Status5");

        stateRepository.save(myState1);
        stateRepository.save(myState2);
        stateRepository.save(myState3);
        stateRepository.save(myState4);
        stateRepository.save(myState5);

        List<State> states = (List<State>) stateRepository.findAll();
        assert (states.size() == 5);

    }

    @Test
    public void ContainerRepoSaveTest() {
        Cantainer container1 = new Cantainer();
        container1.setCountry("USA");
        container1.setAdress("Ruszvelt AV H25");
        container1.setCity("NY");
        Cantainer container2 = new Cantainer();
        container2.setCountry("USA");
        container2.setAdress("Washington AV H38");
        ;
        container2.setCity("CA");
        Cantainer container3 = new Cantainer();
        container3.setCountry("RuSSIA");
        container3.setAdress("MOSCOW AV Ostankino8");
        ;
        container3.setCity("NJ");
        containerRepository.save(container1);
        containerRepository.save(container2);
        containerRepository.save(container3);
        List<Cantainer> containers = (List<Cantainer>) containerRepository.findAll();
        assert (containers.size() == 3);

    }

    @Test
    public void ContainerServiceSaveTest() {
        Cantainer container1 = new Cantainer();
        container1.setCountry("KZ");
        container1.setAdress("Furmanov street");
        container1.setCity("Almaty");
        containerService.createOrUpdateContainer(container1);
        List<Cantainer> containers = (List<Cantainer>) containerRepository.findAll();
        assert (containers.size() == 4);

    }


    @Test
    public void StateServiceSaveTest() {

        State myState1 = new State("Status6");
        myState1.setId(0l);

        StateService.createOrUpdateState(myState1);

        List<State> states = (List<State>) stateRepository.findAll();
        assert (states.size() == 6);

    }


    @Test
    public void StateDeleteTest() {
        State myState1 = StateService.getByState("Status6");
        stateRepository.delete(myState1);
        List<State> states = (List<State>) stateRepository.findAll();
        assert (states.size() == 5);

    }

    @Test
    public void pack_repo_serviceSave() {
        State myState = stateRepository.findDistinctFirstByStateContaining("Status2").get();
        Cantainer myContayner = containerService.getContainerById(7L);
        Pack myPack = new Pack();
        myPack.setId(0L);
        myPack.setWeigth(300D);
        myPack.setPackKey("ABCD03");
        myPack.setState(myState);
        myPack.setCantainer(myContayner);
        packService.createOrUpdatePack(myPack);
        Pack myPack2 = packService.getPackById(10L);
        myPack2.setState(stateRepository.findDistinctFirstByStateContaining("Status5").get());
        packService.createOrUpdatePack(myPack2);

    }

    @Test
    public void getAllPackByStateTest() {
        State myState = stateRepository.findDistinctFirstByStateContaining("Status2").get();
        List<Pack> packliststate = (List<Pack>) packService.getAllPacksBySate(myState);


    }

    @Test
    public void getAllPackByContainerTest() {
        Cantainer myc = containerService.getContainerById(7L);

        List<Pack> packliststate = (List<Pack>) packService.getAllPacksByContainer(myc);
        assert (packliststate.size() == 2);

    }


    @Test
    public void getMyPAksByParam() {

        List<Pack> my_packsG = packService.getAllByWeigthGreaterThanEqualAndState(300D, stateRepository.findDistinctFirstByStateContaining("Status2").get());
        assert (my_packsG.size() == 2);

        List<Pack> my_packsL = packService.getAllByWeigthLessThanEqualAndState(200D, stateRepository.findDistinctFirstByStateContaining("Status5").get());
        assert (my_packsL.size() == 1);

        Pack myPack_key = packService.getPackByKey("ABCD03");
        assert (myPack_key.getPackKey().equals("ABCD03"));

    }


}
