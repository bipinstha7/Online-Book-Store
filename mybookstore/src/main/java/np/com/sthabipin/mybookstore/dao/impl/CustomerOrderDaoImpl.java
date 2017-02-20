package np.com.sthabipin.mybookstore.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import np.com.sthabipin.mybookstore.dao.CustomerOrderDao;
import np.com.sthabipin.mybookstore.model.CustomerOrder;

@Repository
@Transactional
public class CustomerOrderDaoImpl implements CustomerOrderDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addCustomerOrder(CustomerOrder customerOrder) {
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customerOrder);
		session.flush();

	}

}
