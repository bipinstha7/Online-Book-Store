package np.com.sthabipin.mybookstore.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import np.com.sthabipin.mybookstore.Service.CartService;
import np.com.sthabipin.mybookstore.dao.CartDao;
import np.com.sthabipin.mybookstore.model.Cart;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartDao;
	
	@Override
	public Cart getCartById(int cartId) {
		
		return cartDao.getCartById(cartId);
	}

	@Override
	public void update(Cart cart) {
		
		cartDao.update(cart);

	}

}
