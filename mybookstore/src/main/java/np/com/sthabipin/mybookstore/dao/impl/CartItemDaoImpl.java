package np.com.sthabipin.mybookstore.dao.impl;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import np.com.sthabipin.mybookstore.dao.CartItemDao;
import np.com.sthabipin.mybookstore.model.Cart;
import np.com.sthabipin.mybookstore.model.CartItem;

@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addCartItem(CartItem cartItem) {
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartItem);
		session.flush();

	}

	@Override
	public void removeCartItem(CartItem cartItem) {
		
		Session session = sessionFactory.getCurrentSession();
		session.delete(cartItem);
		session.flush();

	}

	@Override
	public void removeAllCartItems(Cart cart) {
		
		List<CartItem> cartItems = cart.getCartItems();
		
		for(CartItem item: cartItems) {
			removeCartItem(item);
		}

	}

	@Override
	public CartItem getCartItemByBookId(int bookId) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CartItem where bookId=?");
		query.setInteger(0, bookId);
		session.flush();
		
		return (CartItem) query.uniqueResult();
	}

}












