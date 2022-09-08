package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.model.entity.MvcOrderEntity;
import demo.model.repository.MvcOrderDtlRepository;
import demo.model.repository.MvcOrderRepository;

@Service
public class OrderServiceImpl {

	@Autowired
	MvcOrderRepository mvcOrderRepository;

	@Autowired
	MvcOrderDtlRepository mvcOrderDtlRepository;

	public List<MvcOrderEntity> getAllOrders() {

		List<MvcOrderEntity> dataList = mvcOrderRepository.findAll();
//		System.out.println(dataList);
//		System.out.println("印出產品名稱:" + dataList.get(0).getMvcOrderDtlEntity().get(0).getMvcProductEntity().getProdName());
//		System.out.println("印出產品名稱:" + dataList.get(0).getMvcOrderDtlEntity().get(1).getMvcProductEntity().getProdName());

		dataList.get(0).getOrderStatus();

		for (int i = 0; i < dataList.size(); i++) {

			MvcOrderEntity mvcOrderEntity = dataList.get(i);
			String orderStatus = mvcOrderEntity.getOrderStatus();
			String payType = mvcOrderEntity.getPayType();

			if ("A".equalsIgnoreCase(orderStatus)) {
				mvcOrderEntity.setOrderStatus("訂單成立");
			} else if ("B".equalsIgnoreCase(orderStatus)) {
				mvcOrderEntity.setOrderStatus("訂單不成立");
			}

			if ("P01".equals(payType)) {
				mvcOrderEntity.setPayType("ApplePay");
			} else if ("P02".equals(payType)) {
				mvcOrderEntity.setPayType("GooglePay");
			}
		}
		return dataList;
	}
}
