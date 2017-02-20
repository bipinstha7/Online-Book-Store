package np.com.sthabipin.mybookstore.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import np.com.sthabipin.mybookstore.Service.BookService;
import np.com.sthabipin.mybookstore.dao.BookDao;
import np.com.sthabipin.mybookstore.model.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	
	@Override
	public List<Book> getBookList() {
		
		
		return bookDao.getBookList();
	}

	@Override
	public Book getBookById(int id) {
		
		return bookDao.getBookById(id);
	}

	@Override
	public void addBook(Book book) {
		
		bookDao.addBook(book);

	}

	@Override
	public void editBook(Book book) {
		
		bookDao.editBook(book);
		
	}

	@Override
	public void deleteBook(Book book) {
		
		bookDao.deleteBook(book);

	}

}
