package demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import demo.model.dto.IndexDto;
import demo.model.dto.WebBroadCastDto;
import demo.model.entity.WebBroadCastEntity;
import demo.model.repository.WebBroadCastRepository;

@Service
public class WebBroadCastServiceImpl implements WebBroadCastService {

	@Autowired
	WebBroadCastRepository webBroadCastRepository;
	
	public Iterable<WebBroadCastEntity> findAll() {
		
		return webBroadCastRepository.findAll();
		
	}
	
	public Page paging(Integer currentPage) {
		
		System.out.println("currentPage : " + currentPage);
		Page page = webBroadCastRepository.findAll(PageRequest.of(currentPage-1, 10));
		System.out.println("Content : " + page.getContent());
		System.out.println("TotalElements : " + page.getTotalElements());
		System.out.println("Size : " + page.getSize());
		
		return page;
		
	}
	
	public void delete(int id) {
		System.out.println("要刪除的id" + id);
		webBroadCastRepository.deleteById(id);
	}
	
	
	
	
//	public Page datatablePaging(int currentPage, int amounts) {
//		
//		 Page<WebBroadCastEntity> page = webBroadCastRepository.findAll(PageRequest.of(currentPage, amounts));
//		 
//		 return page;
//		
//	}
	
	public Page datatablePaging(int currentPage, int amounts, String Search) {
		
		System.out.println(currentPage);
		System.out.println(amounts);
		System.out.println(Search);
		 Page<WebBroadCastEntity> page = webBroadCastRepository.findByTitleLikeOrContentLike("%" + Search + "%", "%" + Search + "%", PageRequest.of(currentPage, amounts));
		 
		 return page;
	}
	
	public WebBroadCastEntity findById(int id) throws Exception{
		
		Optional<WebBroadCastEntity> data = webBroadCastRepository.findById(id);
		
		if(data.isPresent()) {
			return data.get();
		}else {
			throw new Exception();
		}
	}
	
	public void saveEdit(WebBroadCastEntity entity){
		webBroadCastRepository.save(entity);
	}
}
