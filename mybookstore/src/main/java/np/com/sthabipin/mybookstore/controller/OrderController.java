package np.com.sthabipin.mybookstore.controller;

import np.com.sthabipin.mybookstore.Service.CartService;
import np.com.sthabipin.mybookstore.Service.CustomerOrderService;
import np.com.sthabipin.mybookstore.model.Cart;
import np.com.sthabipin.mybookstore.model.Customer;
import np.com.sthabipin.mybookstore.model.CustomerOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CustomerOrderService customerOrderService;
	
	@RequestMapping("/order/{cartId}")
	public String createOrder(@PathVariable(value="cartId") int cartId) {
		
		CustomerOrder customerOrder = new CustomerOrder();
		Cart cart = cartService.getCartById(cartId);
		customerOrder.setCart(cart);
		
		Customer customer = cart.getCustomer();
		customerOrder.setCustomer(customer);
		customerOrder.setBillingAddress(customer.getBillingAddress());
		customerOrder.setShippingAddress(customer.getShippingAddress());;
		
		customerOrderService.addCustomerOrder(customerOrder);
		
		return "redirect:/checkout?cartId="+cartId;
	}

}
