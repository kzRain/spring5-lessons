package com.codeforce.product.service;

import com.codeforce.product.model.*;

import com.codeforce.product.repo.ContainerRepository;
import com.codeforce.product.utils.Form_UI;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.Optional;

public class ContainerServiceTest {

    private Cantainer container;

    @Autowired
    private ContainerRepository containerRepository;

    @Autowired
    private ContainerService containerService;

    @BeforeAll
    public void setUp() {
        container = new Cantainer(Form_UI.getCountryList().get(12), "Almaty", "Abay 12", "123");
        container = containerRepository.save(container);
        Optional<Cantainer> find = containerRepository.findById(container.getId());
        Assert.isTrue(find.isPresent(), "Не создался контейнер");
    }

    @Test
    public void fillContainer(){
        //Create Pack
//        Pack pack = new Pack();
//        container = containerService.addPack(container, pack);
//        Assert.isTrue(!containerService.isEmpty(container),"Не возможно добавить пакет в контейнер");
    }

    @AfterAll
    public void end() {
        containerRepository.delete(container);
        Optional<Cantainer> find = containerRepository.findById(container.getId());
        Assert.isTrue(!find.isPresent(), "Контейнер не удалился");
    }
}
