package np.com.sthabipin.mybookstore.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import np.com.sthabipin.mybookstore.Service.CartService;
import np.com.sthabipin.mybookstore.Service.CustomerOrderService;
import np.com.sthabipin.mybookstore.dao.CustomerOrderDao;
import np.com.sthabipin.mybookstore.model.Cart;
import np.com.sthabipin.mybookstore.model.CartItem;
import np.com.sthabipin.mybookstore.model.CustomerOrder;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

	@Autowired
	private CustomerOrderDao customerOrderDao;
	
	@Autowired
	private CartService cartService;
	
	@Override
	public void addCustomerOrder(CustomerOrder customerOrder) {
		
		customerOrderDao.addCustomerOrder(customerOrder);

	}

	@Override
	public int getCustomerOrderGrandTotal(int cartId) {
		
		int grandTotal = 0;
		Cart cart = cartService.getCartById(cartId);
		List<CartItem> cartItems = cart.getCartItems();
		
		for(CartItem item: cartItems) {
			grandTotal += item.getTotalPrice();
			
		}
		return grandTotal;
	}

}
