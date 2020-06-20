package kz.cf.spring5.lesson3.services;

import kz.cf.spring5.lesson3.repos.SingerRepository;
import kz.cf.spring5.lesson3.entities.Singer;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import com.google.common.collect.Lists;

@Service("springJpaSingerService")
@Repository
@Transactional
@SuppressWarnings("unchecked")
public class SingerServiceImpl implements SingerService {
    @Autowired
    private SingerRepository singerRepository;

    @Transactional(readOnly=true)
    public List<Singer> findAll() {
        return Lists.newArrayList(singerRepository.findAll());
    }

    @Transactional(readOnly=true)
    public List<Singer> findByFirstName(String firstName) {
        return singerRepository.findByFirstName(firstName);
    }

    @Transactional(readOnly=true)
    public List<Singer> findByFirstNameAndLastName(
        String firstName, String lastName) {
        return singerRepository.findByFirstNameAndLastName(
            firstName, lastName);
    }
}
