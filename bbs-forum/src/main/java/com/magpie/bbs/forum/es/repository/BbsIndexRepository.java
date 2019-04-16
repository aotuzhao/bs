package com.magpie.bbs.forum.es.repository;

import com.magpie.bbs.forum.es.entity.BbsIndex;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BbsIndexRepository extends CrudRepository<BbsIndex, String>{

	List<BbsIndex> getByContent(String content);
	
	Page<BbsIndex> getByContent(String content, Pageable pageable);
	
}
