package com.codeforce.product.service;

import com.codeforce.product.model.State;
import com.codeforce.product.repo.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*Alimbetov Ruslan*/
@Service
public class StateService {

    @Autowired
    StateRepository stateRepository;

    public State getByState(String mySate) {
        Optional<State> mystate = stateRepository.findDistinctFirstByStateContaining(mySate);
        if (mystate.isPresent()) {
            return mystate.get();
        }
        return null;
    }

    public List<State> getAllStates() {
        List<State> statelist = (List<State>) stateRepository.findAll();
        if (statelist.size() > 0) {
            return statelist;
        } else {
            return new ArrayList<State>();
        }
    }

    public State getStateById(Long id) {
        Optional<State> state = stateRepository.findById(id);
        if (state.isPresent()) {
            return state.get();
        }
        return null;
    }


    public State createOrUpdateState(State entity) {
        Optional<State> myState = stateRepository.findById(entity.getId());

        if (myState.isPresent()) {
            State newEntity = myState.get();
            newEntity.setState(entity.getState());
            newEntity.setDescription(entity.getDescription());
            newEntity.setPacks(entity.getPacks());
            newEntity = stateRepository.save(newEntity);

            return newEntity;
        } else {
            entity = stateRepository.save(entity);

            return entity;
        }
    }


    public void deleteStateById(Long id) {
        Optional<State> state = stateRepository.findById(id);
        if (state.isPresent()) {
            stateRepository.deleteById(id);
        }
    }


    private boolean existsById(Long id) {
        return stateRepository.existsById(id);
    }

    public List<State> findAll(int pageNumber, int rowPerPage) {
        List<State> states = new ArrayList<>();
        Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage,
                Sort.by("id").ascending());
        stateRepository.findAll(sortedByIdAsc).forEach(states::add);
        return states;
    }

    public State save(State state) {
        if (!StringUtils.isEmpty(state.getState())) {
            if (state.getId() != null && existsById(state.getId())) {
                System.out.println("State with id: " + state.getId() + " already exists");
            }
            return stateRepository.save(state);
        } else {
            System.out.println("Failed to save  is null or empty");
        }
        return null;

    }

    public void update(State state) {
        if (!StringUtils.isEmpty(state.getState())) {
            if (!existsById(state.getId())) {
                System.out.println("Cannot find Contact with id: " + state.getId());
            }
            stateRepository.save(state);

        } else {
            System.out.println("Failed to save  is null or empty");
        }
    }


    public Long count() {
        return stateRepository.count();
    }


}
