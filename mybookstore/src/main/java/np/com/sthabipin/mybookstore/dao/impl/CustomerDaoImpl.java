package np.com.sthabipin.mybookstore.dao.impl;

import java.util.List;




import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import np.com.sthabipin.mybookstore.dao.CustomerDao;
import np.com.sthabipin.mybookstore.model.Authorities;
import np.com.sthabipin.mybookstore.model.Cart;
import np.com.sthabipin.mybookstore.model.Customer;
import np.com.sthabipin.mybookstore.model.Users;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addCustomer(Customer customer) {
		
		Session session = sessionFactory.getCurrentSession();
		
		customer.getBillingAddress().setCustomer(customer);
		customer.getShippingAddress().setCustomer(customer);
		
		session.saveOrUpdate(customer);
		session.saveOrUpdate(customer.getBillingAddress());
		session.saveOrUpdate(customer.getShippingAddress());
		
		Users users = new Users();
		users.setUsername(customer.getUserName());
		users.setPassword(customer.getPassword());
		users.setEnabled(true);
		users.setCustomerId(customer.getCustomerId());
		
		Authorities authorities = new Authorities();
		authorities.setUserName(customer.getUserName());
		authorities.setAuthority("ROLE_USER");
		session.saveOrUpdate(users);
		session.saveOrUpdate(authorities);
		
		Cart cart = new Cart();
		cart.setCustomer(customer);
		customer.setCart(cart);
		session.saveOrUpdate(customer);
		session.saveOrUpdate(cart);
		
		session.flush();

	}

	@Override
	public Customer getCustomerById(int customerId) {
		
		Session session = sessionFactory.getCurrentSession();
		return (Customer) session.get(Customer.class, customerId);
	}

	@Override
	public List<Customer> getAllCustomers() {

		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from Customer");
		List<Customer> customerList = query.list();
		
		
		return customerList;
	}

	@Override
	public Customer getCustomerByUsername(String username) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from Customer where username=?");
		query.setString(0, username); // 0 refers to the firstplace which points to the first ? mark that is here , username
		
		return (Customer) query.uniqueResult();
	}

}













