package cn.com.gs.library.service.impl.book;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import cn.com.gs.library.dao.book.BookDao;
import cn.com.gs.library.dao.sysUser.UserDao;
import cn.com.gs.library.model.Book;
import cn.com.gs.library.service.IBookService;
import cn.com.gs.library.util.Page;

@Service
public class BookServiceImpl implements IBookService {
	@Resource
	private BookDao bookDao;

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public Book selectBookById(String id) {
		return (Book) bookDao.selectBookById(id);

	}

	@Override
	public void deleteBook(String bookId) {
		bookDao.deleteBook(bookId);
	}

	@Override
	public void insertBook(Book bk) {
		bookDao.insertBook(bk);
	}

	@Override
	public void updateBook(Book bk) {
		bookDao.updateBook(bk);
	}

	@Override
	public Integer batchDeleteBooks(String bookIds) {
		return bookDao.batchDeleteBooks(bookIds);
	}

	@Override
	public Page<Book> searchBookByPage(Page<Book> page, Book bk) {
		Integer total = bookDao.searchTotal(bk);
		int start = page.getStart();
		int end = page.getEnd();
		List<Book> bookList = bookDao.searchBookByPage(bk, start, end);
		page.setTotalNo(total);
		page.setResult(bookList);
		return page;
	}

	@Override
	public Integer searchTotal(Book bk) {
		return null;
	}

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:config/applicationContext-spring.xml");
		String[] str = ctx.getBeanDefinitionNames();
		for(String s : str){
			System.out.println(s);
		}
		
		BookDao bookDao = (BookDao)ctx.getBean("bookDao");
		System.out.println(bookDao.searchTotal(new Book()));
		
		UserDao userDao = (UserDao)ctx.getBean("userDao");
		System.out.println(userDao.getUserByAccount("admin").getId());
	}
}
