package com.codeforce.product.restController;

import com.codeforce.product.model.Cantainer;
import com.codeforce.product.service.ContainerService;
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
    public ResponseEntity<List<Cantainer>> getAllContainers() {
        List<Cantainer> list = containerService.getAllContainers();
        return new ResponseEntity<List<Cantainer>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cantainer> getContainerById(@PathVariable("id") Long id) {
        Cantainer entity = containerService.getContainerById(id);
        return new ResponseEntity<Cantainer>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cantainer> createOrUpdateContainer(Cantainer container) {
        Cantainer updated = containerService.createOrUpdateContainer(container);
        return new ResponseEntity<Cantainer>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteContainerById(@PathVariable("id") Long id) {
        containerService.deleteContainerById(id);
        return HttpStatus.FORBIDDEN;
    }


}

