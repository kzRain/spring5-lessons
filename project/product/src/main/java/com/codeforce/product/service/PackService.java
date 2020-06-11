package com.codeforce.product.service;

import com.codeforce.product.model.Pack;
import com.codeforce.product.repo.PackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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

    public Pack getPackById(Long id) {
        Optional<Pack> pack = packRepository.findById(id);
        if(pack.isPresent()) {
            return pack.get();
        }
        return null;
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
}
