package com.codeforce.product.service;

import com.codeforce.product.model.Cantainer;
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

    public List<Cantainer> getAllContainers() {
        List<Cantainer> containerlist = (List<Cantainer>) containerRepository.findAll();
        if (containerlist.size() > 0) {
            return containerlist;
        } else {
            return new ArrayList<Cantainer>();
        }
    }

    public Cantainer getContainerById(Long id) {
        Optional<Cantainer> container = containerRepository.findById(id);
        if (container.isPresent()) {
            return container.get();
        }
        return null;
    }

    public List<Cantainer> getContainersByCountry(String Country) {
        List<Cantainer> containerlist = (List<Cantainer>) containerRepository.findContainerByCountry(Country);
        if (containerlist.size() > 0) {
            return containerlist;
        } else {
            return new ArrayList<Cantainer>();
        }
    }

    public List<Cantainer> getContainersByCity(String city) {
        List<Cantainer> containerlist = (List<Cantainer>) containerRepository.findContainersByCityContaining(city);
        if (containerlist.size() > 0) {
            return containerlist;
        } else {
            return new ArrayList<Cantainer>();
        }
    }

    public List<Cantainer> getContainersByAdress(String adress) {
        List<Cantainer> containerlist = (List<Cantainer>) containerRepository.findContainersByAdressContaining(adress);
        if (containerlist.size() > 0) {
            return containerlist;
        } else {
            return new ArrayList<Cantainer>();
        }
    }


    public Cantainer createOrUpdateContainer(Cantainer entity) {
        Optional<Cantainer> myState = containerRepository.findById(entity.getId());

        if (myState.isPresent()) {
            Cantainer newEntity = myState.get();
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
        Optional<Cantainer> container = containerRepository.findById(id);
        if (container.isPresent()) {
            containerRepository.deleteById(id);
        }
    }


    private boolean existsById(Long id) {
        return containerRepository.existsById(id);
    }


    public List<Cantainer> findAll(int pageNumber, int rowPerPage) {
        List<Cantainer> containers = new ArrayList<>();
        Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage,
                Sort.by("id").ascending());
        containerRepository.findAll(sortedByIdAsc).forEach(containers::add);
        return containers;
    }

    public Cantainer save(Cantainer container) {
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

    public void update(Cantainer container) {
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
