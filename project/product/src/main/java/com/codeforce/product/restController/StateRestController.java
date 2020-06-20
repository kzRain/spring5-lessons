package com.codeforce.product.restController;


import com.codeforce.product.model.State;
import com.codeforce.product.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*Alimbetov Ruslan*/

@RestController
@RequestMapping("/api/states")
public class StateRestController {

    @Autowired
    StateService stateService;

    @GetMapping
    public ResponseEntity<List<State>> getAllStates() {
        List<State> list = stateService.getAllStates();
        return new ResponseEntity<List<State>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<State> getStateById(@PathVariable("id") Long id) {
        State entity = stateService.getStateById(id);
        return new ResponseEntity<State>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<State> createOrUpdateStates(State state) {
        State updated = stateService.createOrUpdateState(state);
        return new ResponseEntity<State>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteStateById(@PathVariable("id") Long id) {
        stateService.deleteStateById(id);
        return HttpStatus.FORBIDDEN;
    }


}
