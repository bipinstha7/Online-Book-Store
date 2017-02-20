package np.com.sthabipin.mybookstore.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import np.com.sthabipin.mybookstore.Service.CartItemService;
import np.com.sthabipin.mybookstore.dao.CartItemDao;
import np.com.sthabipin.mybookstore.model.Cart;
import np.com.sthabipin.mybookstore.model.CartItem;

@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemDao cartItemDao;
	
	@Override
	public void addCartItem(CartItem cartItem) {
		
		cartItemDao.addCartItem(cartItem);

	}

	@Override
	public void removeCartItem(CartItem cartItem) {
		
		cartItemDao.removeCartItem(cartItem);

	}

	@Override
	public void removeAllCartItems(Cart cart) {
		
		cartItemDao.removeAllCartItems(cart);

	}

	@Override
	public CartItem getCartItemByBookId(int bookId) {
		
		return cartItemDao.getCartItemByBookId(bookId);
	}

}
