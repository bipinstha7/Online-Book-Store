package np.com.sthabipin.mybookstore.Service;

import java.util.List;

import np.com.sthabipin.mybookstore.model.Book;

public interface BookService {

	List<Book> getBookList();
	
	Book getBookById(int id);
	
	public void addBook(Book book);
	
	public void editBook(Book book);
	
	public void deleteBook(Book book);
}
