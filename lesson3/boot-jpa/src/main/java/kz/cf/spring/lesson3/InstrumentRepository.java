package kz.cf.spring.lesson3;

import kz.cf.spring.lesson3.entities.Instrument;
import org.springframework.data.repository.CrudRepository;

/**
 * Created  on 5/12/17.
 */
public interface InstrumentRepository extends CrudRepository<Instrument, Long> {

}
