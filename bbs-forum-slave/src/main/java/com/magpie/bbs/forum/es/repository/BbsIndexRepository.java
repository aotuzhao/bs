package com.magpie.bbs.forum.es.repository;

import com.magpie.bbs.forum.es.entity.BbsIndex;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 * @Description: es查询
 * @date: 2019/4/16 21:22
 * @author：zhaoxuezhao
 */
public interface BbsIndexRepository extends CrudRepository<BbsIndex, String>{
	/**
	 *
	 * @Title: getByContent
	 * @Description: 根据内容查询
	 * @date: 2019/4/16 21:20
	 * @author：zhaoxuezhao
	 */
	List<BbsIndex> getByContent(String content);

	/**
	 *
	 * @Title: getByContent
	 * @Description: 根据内容查询并分页
	 * @date: 2019/4/16 21:21
	 * @author：zhaoxuezhao
	 */
	Page<BbsIndex> getByContent(String content, Pageable pageable);
	
}
