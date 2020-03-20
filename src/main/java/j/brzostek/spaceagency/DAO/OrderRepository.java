package j.brzostek.spaceagency.DAO;

import j.brzostek.spaceagency.DAO.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
