package demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.model.entity.MvcOrderDtlEntity;
import demo.model.entity.MvcOrderDtlEntityPkey;

public interface MvcOrderDtlRepository extends JpaRepository<MvcOrderDtlEntity,  MvcOrderDtlEntityPkey> {
	
//	List<MvcOrderDtlEntity> findByOrderNo(String orderNo);

}
