package com.codeforce.product.service;

import com.codeforce.product.model.Container;
import com.codeforce.product.repo.ContainerRepository;
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
public class ContainerService {

    @Autowired
    ContainerRepository containerRepository;

    public List<Container> getAllContainers() {
        List<Container> containerlist = (List<Container>) containerRepository.findAll();
        if (containerlist.size() > 0) {
            return containerlist;
        } else {
            return new ArrayList<Container>();
        }
    }

    public Container getContainerById(Long id) {
        Optional<Container> container = containerRepository.findById(id);
        if (container.isPresent()) {
            return container.get();
        }
        return null;
    }

    public List<Container> getContainersByCountry(String Country) {
        List<Container> containerlist = (List<Container>) containerRepository.findContainerByCountry(Country);
        if (containerlist.size() > 0) {
            return containerlist;
        } else {
            return new ArrayList<Container>();
        }
    }

    public List<Container> getContainersByCity(String city) {
        List<Container> containerlist = (List<Container>) containerRepository.findContainersByCityContaining(city);
        if (containerlist.size() > 0) {
            return containerlist;
        } else {
            return new ArrayList<Container>();
        }
    }

    public List<Container> getContainersByAdress(String adress) {
        List<Container> containerlist = (List<Container>) containerRepository.findContainersByAdressContaining(adress);
        if (containerlist.size() > 0) {
            return containerlist;
        } else {
            return new ArrayList<Container>();
        }
    }


    public Container createOrUpdateContainer(Container entity) {
        Optional<Container> myState = containerRepository.findById(entity.getId());

        if (myState.isPresent()) {
            Container newEntity = myState.get();
            newEntity.setCountry(entity.getCountry());
            newEntity.setPacks(entity.getPacks());
            newEntity.setAdress(entity.getAdress());
            newEntity.setQnumber(entity.getQnumber());
            newEntity = containerRepository.save(newEntity);

            return newEntity;
        } else {
            entity = containerRepository.save(entity);

            return entity;
        }
    }

    public void deleteContainerById(Long id) {
        Optional<Container> container = containerRepository.findById(id);
        if (container.isPresent()) {
            containerRepository.deleteById(id);
        }
    }


    private boolean existsById(Long id) {
        return containerRepository.existsById(id);
    }


    public List<Container> findAll(int pageNumber, int rowPerPage) {
        List<Container> containers = new ArrayList<>();
        Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage,
                Sort.by("id").ascending());
        containerRepository.findAll(sortedByIdAsc).forEach(containers::add);
        return containers;
    }

    public Container save(Container container) {
        if (!StringUtils.isEmpty(container.getQnumber())) {
            if (existsById(container.getId())) {
                System.out.println("State with id: " + container.getId() + " already exists");
            }
            return containerRepository.save(container);
        } else {
            System.out.println("Failed to save  is null or empty");
        }
        return null;

    }

    public void update(Container container) {
        if (!StringUtils.isEmpty(container.getQnumber())) {
            if (!existsById(container.getId())) {
                System.out.println("Cannot find Contact with id: " + container.getId());
            }
            containerRepository.save(container);

        } else {
            System.out.println("Failed to save  is null or empty");
        }
    }


    public Long count() {
        return containerRepository.count();
    }


}
