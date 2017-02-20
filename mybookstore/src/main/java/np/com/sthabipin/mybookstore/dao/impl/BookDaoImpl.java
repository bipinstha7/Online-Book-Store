package np.com.sthabipin.mybookstore.dao.impl;

import java.util.List;





import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import np.com.sthabipin.mybookstore.dao.BookDao;
import np.com.sthabipin.mybookstore.model.Book;


@Repository
@Transactional
public class BookDaoImpl implements BookDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addBook(Book book) {
		
		// get hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//save the customer to the database
		session.saveOrUpdate(book);
		
		session.flush();
		
	}

	@Override
	public Book getBookById(int id) {

		// get hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Book book = (Book) session.get(Book.class, id);
		
		session.flush();
		return book;
	}

	@Override
	public List<Book> getBookList() {
		
		// get the hibernate session
		Session session = sessionFactory.getCurrentSession();
				
		// create a query
		Query theQuery = session.createQuery("from Book order by name");
			
		// execute query and get result list
		List<Book> books = theQuery.list();
			
		session.flush();
		//return the result
		return books;
		
	}

	@Override
	public void deleteBook(Book book) {
		
		// get the hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// delete the object with primary key 
		session.delete(book);
		
		session.flush();
		
	}
	
	@Override
	public void editBook(Book book) {
		
		// get hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//save the customer to the database
		session.saveOrUpdate(book);
		
		session.flush();
		
	}

}
