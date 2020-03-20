package j.brzostek.spaceagency.DAO;

import j.brzostek.spaceagency.DAO.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {
    List<Product> findByAcquisitionDate(Instant acquisition);
    List<Product> findByAcquisitionDateGreaterThan(Instant acquisition);
    List<Product> findByAcquisitionDateLessThan(Instant acquisition);
    List<Product> findByAcquisitionDateBetween(Instant acquisitionDate, Instant acquisitionDate2);
    List<Product> findByProductIdIn(@Param("ids") Long[] ids);
}
