package j.brzostek.spaceagency.DAO;

import j.brzostek.spaceagency.DAO.entity.OrderProduct;
import j.brzostek.spaceagency.DAO.entity.OrderProductPK;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends CrudRepository<OrderProduct, OrderProductPK> {
}
