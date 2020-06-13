package kz.cf.spring.lesson3.services;

import kz.cf.spring.lesson3.repos.SingerAuditRepository;
import kz.cf.spring.lesson3.entities.SingerAudit;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import com.google.common.collect.Lists;

@Service("singerAuditService")
@Transactional
public class SingerAuditServiceImpl implements SingerAuditService {

    @Autowired
    private SingerAuditRepository singerAuditRepository;

    @Transactional(readOnly=true)
    public List<SingerAudit> findAll() {
        return Lists.newArrayList(singerAuditRepository.findAll());
    }

    /**
     * API  changed in  2.0.0.M3 findOne became findById
     * @param id
     * @return
     */
    public SingerAudit findById(Long id) {
        return singerAuditRepository.findById(id).get();
    }

    public SingerAudit save(SingerAudit singer) {
        return singerAuditRepository.save(singer);
    }
}
