package com.codeforce.product.service;

import com.codeforce.product.model.Container;
import com.codeforce.product.model.Pack;
import com.codeforce.product.model.State;
import com.codeforce.product.repo.PackRepository;
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
public class PackService {

    @Autowired
    PackRepository packRepository;

    public List<Pack> getAllPacks() {
        List<Pack> packlist = (List<Pack>) packRepository.findAll();
        if(packlist.size() > 0) {
            return packlist;
        } else {
            return new ArrayList<Pack>();
        }
    }

    public List<Pack> getAllPacksBySate(State mysSate) {
        List<Pack> packlist = (List<Pack>) packRepository.findAllByState(mysSate);
        if(packlist.size() > 0) {
            return packlist;
        } else {
            return new ArrayList<Pack>();
        }
    }
    public List<Pack> getAllPacksByContainer(Container myContainer) {
        List<Pack> packlist = (List<Pack>) packRepository.findAllByContainer(myContainer);
        if(packlist.size() > 0) {
            return packlist;
        } else {
            return new ArrayList<Pack>();
        }
    }



    public Pack getPackById(Long id) {
        Optional<Pack> pack = packRepository.findById(id);
        if(pack.isPresent()) {
            return pack.get();
        }
        return null;
    }
    public Pack getPackByKey(String key) {
        Optional<Pack> pack = packRepository.findPackByPackkey(key);
        if(pack.isPresent()) {
            return pack.get();
        }
        return null;
    }

    public List<Pack> getAllByWeigthGreaterThanEqualAndState(Double weight, State mySate) {
        List<Pack> packlist = (List<Pack>) packRepository.findAllByWeigthGreaterThanEqualAndState(weight,mySate);
        if(packlist.size() > 0) {
            return packlist;
        } else {
            return new ArrayList<Pack>();
        }
    }
    public List<Pack> getAllByWeigthLessThanEqualAndState(Double weight, State mySate) {
        List<Pack> packlist = (List<Pack>) packRepository.findAllByWeigthLessThanEqualAndState(weight,mySate);;
        if(packlist.size() > 0) {
            return packlist;
        } else {
            return new ArrayList<Pack>();
        }
    }


    public Pack createOrUpdatePack(Pack entity)
    {
        Optional<Pack> mypack = packRepository.findById(entity.getId());

        if(mypack.isPresent())
        {
            Pack newEntity = mypack.get();
            newEntity.setState(entity.getState());
            newEntity.setPackkey(entity.getPackkey());
            newEntity.setWeigth(entity.getWeigth());
            newEntity.setContainer(entity.getContainer());

            newEntity = packRepository.save(newEntity);

            return newEntity;
        } else {
            entity = packRepository.save(entity);

            return entity;
        }
    }

    public void deletePackById(Long id)
    {
        Optional<Pack> pack = packRepository.findById(id);
        if(pack.isPresent())
        {
            packRepository.deleteById(id);
        }
    }



    private boolean existsById(Long id) {
        return packRepository.existsById(id);
    }


    public List<Pack> findAll(int pageNumber, int rowPerPage) {
        List<Pack> packs = new ArrayList<>();
        Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage,
                Sort.by("id").ascending());
        packRepository.findAll(sortedByIdAsc).forEach(packs::add);
        return packs;
    }

    public  Pack save(Pack pack)  {
        if (!StringUtils.isEmpty(pack.getPackkey())) {
            if (existsById(pack.getId())) {
                System.out.println ("State with id: " + pack.getId() + " already exists");
            }
            return packRepository.save(pack);
        }
        else {
            System.out.println ("Failed to save  is null or empty");
        }
        return  null;

    }

    public void  update(Pack pack) {
        if (!StringUtils.isEmpty(pack.getPackkey())) {
            if (!existsById(pack.getId())) {
                System.out.println("Cannot find Contact with id: " + pack.getId());
            }
            packRepository.save(pack);

        } else {
            System.out.println("Failed to save  is null or empty");
        }
    }


    public Long count() {
        return packRepository.count();
    }



}
