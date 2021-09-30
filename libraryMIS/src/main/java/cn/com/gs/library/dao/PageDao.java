package cn.com.gs.library.dao;

import org.springframework.stereotype.Repository;

import cn.com.gs.library.dao.book.BaseDao;
import cn.com.gs.library.model.Book;

@Repository
public class PageDao extends BaseDao{
	public int selectCountBook(Book bk){
		Integer page = (Integer)sqlSession.selectOne("com.library.model.PageMapper.selectCountBook", bk);
		return page;
	}
}
