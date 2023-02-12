package solutions.javasoft.dao.repository;

import org.springframework.data.repository.CrudRepository;
import solutions.javasoft.dao.model.PriceList;

public interface PriceListRepository extends CrudRepository<PriceList, Long> {
}
