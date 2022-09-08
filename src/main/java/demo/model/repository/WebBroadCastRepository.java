package demo.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import demo.model.dto.IndexDto.WebBoardCastDto;
import demo.model.entity.WebBroadCastEntity;

public interface WebBroadCastRepository extends JpaRepository<WebBroadCastEntity, Integer> {
	
//	Page findByTitleLikeOrContentlikePage(String search, String search2,Integer currentPage );

	Page findByTitleLikeOrContentLike(String search, String search2, Pageable page);
}
