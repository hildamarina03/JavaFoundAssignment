package bts.mdsd.main;

import java.util.ArrayList;
import java.util.List;

public class RestaurantOperations implements OnlineOrderOps<CustomerOrder, Dish> {

	@Override
	public int getNumberOrders(List<CustomerOrder> orderList) {
		return orderList.size();
	}

	@Override
	public CustomerOrder getOrder(List<CustomerOrder> orderList, int orderIndex) {	
		return orderList.get(orderIndex);
	}

	@Override
	public String getAllOrdersToString(List<CustomerOrder> orderList) {
		String result = "";
		for(int i = 0; i < orderList.size(); i++){
			CustomerOrder order = orderList.get(i);
			result = result + order + "\n";
		}
		return result;
	}

	@Override
	public Dish getDish(List<Dish> dishList, int dishIndex) {
		return dishList.get(dishIndex);
	}

	@Override
	public String getAllDishToString(List<Dish> dishList) {
		String result = "";
		for(int i = 0; i < dishList.size(); i++){
			Dish dish = dishList.get(i);
			result = result + dish + "\n";
		}
		return result;
	}

	@Override
	public List<Dish> getDishesByType(List<Dish> dishList, String dishType) {
		String realDishType = "";
		switch(dishType){
			case "st":
				realDishType = "Starter";
				break;
			case "mc":
				realDishType = "Main course";
				break;
			case "ds":
				realDishType = "Dessert";
				break;
			default:
				 break;
		}
		
		List<Dish> filteredList = new ArrayList<Dish>();
		for (Dish dish: dishList){
			if(dish.getDishtype().equals(realDishType)){
				filteredList.add(dish);
			} 
		}
		return filteredList;	
	}

	@Override
	public List<Dish> getDishesByFeature(List<Dish> dishList, String feature) {
		List<Dish> filteredList = new ArrayList<Dish>();
		for (Dish dish: dishList){
			if( 
				(feature.equals("gfd") && dish.isGfd())  
				|| (feature.equals("vgd") && dish.isVgd())
				|| (feature.equals("hmd") && dish.isHmd())
				|| (feature.equals("sfd") && dish.isSfd())
			){
				filteredList.add(dish);
			}	
		}
		return filteredList;
	}

	@Override
	public String getStatsByDishType(List<Dish> dishList, String dishType) {
		String realDishType = "";
		switch(dishType){
			case "st":
				realDishType = "STARTERS";
				break;
			case "mc":
				realDishType = "MAIN COURSES";
				break;
			case "ds":
				realDishType = "DESSERTS";
				break;
			default:
				 break;
		}
		List<Dish> filteredDishes = this.getDishesByType(dishList, dishType); 
		
		int result = (int) (filteredDishes.size()*100.0f/dishList.size());
		return realDishType + ": " + result + "%"; 
	}

	
	
}