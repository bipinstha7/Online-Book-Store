package np.com.sthabipin.mybookstore.controller;

import java.util.List;

import np.com.sthabipin.mybookstore.Service.BookService;
import np.com.sthabipin.mybookstore.Service.CartItemService;
import np.com.sthabipin.mybookstore.Service.CartService;
import np.com.sthabipin.mybookstore.Service.CustomerService;
import np.com.sthabipin.mybookstore.model.Book;
import np.com.sthabipin.mybookstore.model.Cart;
import np.com.sthabipin.mybookstore.model.CartItem;
import np.com.sthabipin.mybookstore.model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/rest/cart")
public class CartResources {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/{cartId}")
	public @ResponseBody Cart getCartById(@PathVariable(value="cartId")int cartId) {
		return cartService.getCartById(cartId);
	}
	
	@PutMapping("/add/{bookId}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void addItem(@PathVariable(value="bookId") int bookId, @AuthenticationPrincipal User activeUser) {
		
		Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
		Cart cart = customer.getCart();
		Book book = bookService.getBookById(bookId);
		List<CartItem> cartItems = cart.getCartItems();
		
		for(int i=0;i<cartItems.size();i++) {
			if(book.getBookId() == cartItems.get(i).getBook().getBookId()) { //in cart if the book is already exist
				CartItem cartItem = cartItems.get(i);
				cartItem.setQuantity(cartItem.getQuantity()+1);
				cartItem.setTotalPrice(book.getBookPrice()*cartItem.getQuantity());
				cartItemService.addCartItem(cartItem);
				
				return;
			}
		}
		
		CartItem cartItem = new CartItem();
		cartItem.setBook(book);
		cartItem.setQuantity(1);
		cartItem.setTotalPrice(book.getBookPrice()*cartItem.getQuantity());
		cartItem.setCart(cart);
		cartItemService.addCartItem(cartItem);
	}
	
	@PutMapping("/remove/{bookId}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void removeItem(@PathVariable(value="bookId") int bookId) {
		
		CartItem cartItem = cartItemService.getCartItemByBookId(bookId);
		cartItemService.removeCartItem(cartItem);
	}
	
	@DeleteMapping("/{cartId}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void clearCart(@PathVariable(value="cartId") int cartId) {
		Cart cart = cartService.getCartById(cartId);
		cartItemService.removeAllCartItems(cart);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload")
	public void handleClientErrors(Exception e) {
		
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal server error")
	public void handleServerErrors(Exception e) {
		
	}
}












