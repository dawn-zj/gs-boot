package cn.com.gs.library.service;

import cn.com.gs.library.model.Book;
import cn.com.gs.library.util.Page;

public interface IBookService {
	public abstract Page<Book> searchBookByPage(Page<Book> page, Book bk);
	public abstract Integer searchTotal(Book bk);
	public abstract Book selectBookById(String id);
	
	public abstract void deleteBook(String bookId);
	public abstract Integer batchDeleteBooks(String bookIds);
	
	public abstract void insertBook(Book bk);
	
	public abstract void updateBook(Book bk);
}
