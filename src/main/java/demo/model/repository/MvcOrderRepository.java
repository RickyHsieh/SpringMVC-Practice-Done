package demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.model.entity.MvcOrderEntity;

public interface MvcOrderRepository extends JpaRepository<MvcOrderEntity, String> {
	
//@Query(
//		value="SELECT MVC_ORDER.*, MVC_ORDER_DTL.*  "
//		+ " FROM MVC_ORDER "
//		+ " INNER JOIN MVC_ORDER_DTL "
//		+ " ON MVC_ORDER.ORDER_NO = MVC_ORDER_DTL.ORDER_NO ", nativeQuery = true)
//List<MvcOrderEntity> findOrderDtl();
//	
}
