package demo.service;

import org.springframework.data.domain.Page;

import demo.model.entity.WebBroadCastEntity;

public interface WebBroadCastService {
	
	Iterable<WebBroadCastEntity> findAll();
	
	Page paging(Integer currentPage);

}
