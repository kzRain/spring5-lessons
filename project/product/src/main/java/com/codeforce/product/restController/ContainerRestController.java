package com.codeforce.product.restController;

import com.codeforce.product.model.Container;
import com.codeforce.product.model.State;
import com.codeforce.product.service.ContainerService;
import com.codeforce.product.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*Alimbetov Ruslan*/
@RestController
@RequestMapping("/api/containers")
public class ContainerRestController {

    @Autowired
    ContainerService containerService;

    @GetMapping
    public ResponseEntity<List<Container>> getAllContainers() {
        List<Container> list = containerService.getAllContainers();
        return new ResponseEntity<List<Container>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Container> getContainerById(@PathVariable("id") Long id) {
        Container entity = containerService.getContainerById(id);
        return new ResponseEntity<Container>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Container> createOrUpdateContainer(Container container) {
        Container updated = containerService.createOrUpdateContainer(container);
        return new ResponseEntity<Container>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteContainerById(@PathVariable("id") Long id) {
        containerService.deleteContainerById(id);
        return HttpStatus.FORBIDDEN;
    }


}

