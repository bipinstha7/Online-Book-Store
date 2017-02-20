package np.com.sthabipin.mybookstore.Service;

import np.com.sthabipin.mybookstore.model.Cart;
import np.com.sthabipin.mybookstore.model.CartItem;

public interface CartItemService {

	public void addCartItem(CartItem cartItem);
	
	public void removeCartItem(CartItem cartItem);
	
	public void removeAllCartItems(Cart cart);

	public CartItem getCartItemByBookId(int bookId);
}
