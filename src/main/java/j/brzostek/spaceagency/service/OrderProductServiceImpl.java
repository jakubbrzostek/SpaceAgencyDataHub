package j.brzostek.spaceagency.service;

import j.brzostek.spaceagency.DAO.OrderProductRepository;
import j.brzostek.spaceagency.DAO.entity.OrderProduct;
import j.brzostek.spaceagency.service.serviceInterface.OrderProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderProductServiceImpl implements OrderProductService {

    private OrderProductRepository orderProductRepository;

    public OrderProductServiceImpl(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    @Override
    public OrderProduct create(OrderProduct orderProduct) {
        return this.orderProductRepository.save(orderProduct);
    }
}
