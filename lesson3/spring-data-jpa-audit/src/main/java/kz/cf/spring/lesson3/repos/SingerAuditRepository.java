package kz.cf.spring.lesson3.repos;

import kz.cf.spring.lesson3.entities.SingerAudit;
import org.springframework.data.repository.CrudRepository;

public interface SingerAuditRepository extends CrudRepository<SingerAudit, Long> {
}
