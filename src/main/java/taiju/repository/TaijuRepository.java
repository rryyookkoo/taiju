package taiju.repository;

import org.springframework.data.repository.CrudRepository;
import taiju.domain.Taiju;

public interface TaijuRepository extends CrudRepository<Taiju, Integer> {

}
