package kz.cf.spring5.lesson3.services;

import kz.cf.spring5.lesson3.entities.SingerAudit;

import java.util.List;

public interface SingerAuditService {
    List<SingerAudit> findAll();
    SingerAudit findById(Long id);
    SingerAudit save(SingerAudit singerAudit);
    SingerAudit findAuditByRevision(Long id, int revision);
}
