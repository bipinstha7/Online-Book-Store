package np.com.sthabipin.mybookstore.Service;

import np.com.sthabipin.mybookstore.model.Cart;

public interface CartService {

	public Cart getCartById(int cartId);
	
	public void update(Cart cart);
}
