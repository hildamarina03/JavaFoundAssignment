package bts.mdsd.main;

public class CustomerOrder {

	private String orderCustomerName;
	private Dish orderDish;
	
	
	public CustomerOrder(String orderCustomerName, Dish orderDish) {
		this.orderCustomerName = orderCustomerName;
		this.orderDish = orderDish;
	}
	public String getOrderCustomerName() {
		return this.orderCustomerName;
	}
	public void setOrderCustomerName(String orderCustomerName) {
		this.orderCustomerName = orderCustomerName;
	}
	public Dish getOrderDish() {
		return orderDish;
	}
	public void setOrderDish(Dish orderDish) {
		this.orderDish = orderDish;
	}
	
	@Override
	public String toString() {
		return "For " + this.getOrderCustomerName() +": " + this.getOrderDish().toString();
	}
	
}