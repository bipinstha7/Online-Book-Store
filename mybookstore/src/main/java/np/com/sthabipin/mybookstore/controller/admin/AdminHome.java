package np.com.sthabipin.mybookstore.controller.admin;

import java.util.List;

import np.com.sthabipin.mybookstore.Service.BookService;
import np.com.sthabipin.mybookstore.Service.CustomerService;
import np.com.sthabipin.mybookstore.model.Book;
import np.com.sthabipin.mybookstore.model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminHome {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping
	public  String adminPage() {
		return "admin";
	}
	
	@RequestMapping("/bookInventory") 
	public String bookInventory(Model model) {
		
		List<Book> books = bookService.getBookList();
		model.addAttribute("books", books);
		
		return "bookInventory";
	}
	
	@RequestMapping("/customer")
	public String customerManagement(Model model) {
		
		List<Customer> customerList = customerService.getAllCustomers();
		model.addAttribute("customerList", customerList);
		
		return "customerManagement";
	}
}














