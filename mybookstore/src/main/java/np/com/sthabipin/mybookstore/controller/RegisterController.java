package np.com.sthabipin.mybookstore.controller;

import java.util.List;

import javax.validation.Valid;

import np.com.sthabipin.mybookstore.Service.CustomerService;
import np.com.sthabipin.mybookstore.model.BillingAddress;
import np.com.sthabipin.mybookstore.model.Customer;
import np.com.sthabipin.mybookstore.model.ShippingAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/register")
	public String registerCustomer(Model model) {
		
		Customer customer = new Customer();
		BillingAddress billingAddress = new BillingAddress();
		ShippingAddress shippingAddress = new ShippingAddress();
		
		customer.setBillingAddress(billingAddress);
		customer.setShippingAddress(shippingAddress);
		
		model.addAttribute("customer", customer);
		
		return "registerCustomer";
	}
	
	@PostMapping("/register")
	public String registerCustomerPost(@Valid @ModelAttribute("customer") Customer customer,BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "registerCustomer";
		}
		
		List<Customer> customerList = customerService.getAllCustomers();
		for(int i=0;i<customerList.size();i++) {
			if(customer.getCustomerEmail().equals(customerList.get(i).getCustomerEmail())) {
				model.addAttribute("emailMsg", "Email already exists");
				
				return "registerCustomer";
			}
			
			if(customer.getUserName().equals(customerList.get(i).getUserName())) {
				model.addAttribute("usernameMsg", "Username already exists");
				
				return "registerCustomer";
			}
		}
		
		
		customer.setEnabled(true);
		customerService.addCustomer(customer);
		
		return "registerCustomerSuccess";
	}
}















