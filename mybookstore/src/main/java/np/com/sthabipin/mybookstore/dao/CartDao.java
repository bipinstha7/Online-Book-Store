package np.com.sthabipin.mybookstore.dao;

import java.io.IOException;

import np.com.sthabipin.mybookstore.model.Cart;

public interface CartDao {

	Cart getCartById(int cartId);
	
	Cart validate(int cartId) throws IOException;

	public void update(Cart cart);
	
}
