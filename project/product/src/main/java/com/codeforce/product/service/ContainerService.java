package com.codeforce.product.service;

import com.codeforce.product.model.Container;
import com.codeforce.product.model.State;
import com.codeforce.product.repo.ContainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContainerService {

    @Autowired
    ContainerRepository containerRepository;

    public List<Container> getAllStates() {
        List<Container> containerlist = (List<Container>) containerRepository.findAll();
        if(containerlist.size() > 0) {
            return containerlist;
        } else {
            return new ArrayList<Container>();
        }
    }

    public Container  getContainerById(Long id) {
        Optional<Container> container = containerRepository.findById(id);
        if(container.isPresent()) {
            return container.get();
        }
        return null;
    }



    public Container createOrUpdateContainer(Container entity)
    {
        Optional<Container> myState = containerRepository.findById(entity.getId());

        if(myState.isPresent())
        {
            Container newEntity = myState.get();
            newEntity.setCountry(entity.getCountry());
            newEntity.setPacks(entity.getPacks());
            newEntity.setAdress(entity.getAdress());

            newEntity = containerRepository.save(newEntity);

            return newEntity;
        } else {
            entity = containerRepository.save(entity);

            return entity;
        }
    }

    public void deleteContainerById(Long id)
    {
        Optional<Container> container = containerRepository.findById(id);
        if(container.isPresent())
        {
            containerRepository.deleteById(id);
        }
    }
}
