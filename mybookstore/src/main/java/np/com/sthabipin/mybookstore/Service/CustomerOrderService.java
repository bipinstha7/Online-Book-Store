package np.com.sthabipin.mybookstore.Service;

import np.com.sthabipin.mybookstore.model.CustomerOrder;

public interface CustomerOrderService {
	
	public void addCustomerOrder(CustomerOrder customerOrder);
	
	int getCustomerOrderGrandTotal(int cartId);
}
