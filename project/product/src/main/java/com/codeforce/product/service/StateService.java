package com.codeforce.product.service;

import com.codeforce.product.model.State;
import com.codeforce.product.repo.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class StateService {

    @Autowired
    StateRepository stateRepository;

    public List<State> getAllStates() {
        List<State> statelist = (List<State>) stateRepository.findAll();
        if(statelist.size() > 0) {
            return statelist;
        } else {
            return new ArrayList<State>();
        }
    }

    public State getStateById(Long id) {
        Optional<State> state = stateRepository.findById(id);
        if(state.isPresent()) {
            return state.get();
        }
        return null;
    }



    public State createOrUpdateState(State entity)
    {
        Optional<State> myState = stateRepository.findById(entity.getId());

        if(myState.isPresent())
        {
            State newEntity = myState.get();
            newEntity.setState(entity.getState());
            newEntity.setPacks(entity.getPacks());
            newEntity = stateRepository.save(newEntity);

            return newEntity;
        } else {
            entity = stateRepository.save(entity);

            return entity;
        }
    }

    public void deleteStateById(Long id)
    {
        Optional<State> state = stateRepository.findById(id);
        if(state.isPresent())
        {
            stateRepository.deleteById(id);
        }
    }
}
