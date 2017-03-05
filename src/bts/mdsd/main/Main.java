package bts.mdsd.main;

import java.io.IOException;
import java.util.List;

public class Main {
		
	public static void main(String[] args) throws IOException {
		List<CustomerOrder> orders = ReadOrders.fileToOrders("/Users/hilda/Workspace/JavaFoundAssignment/src/bts/mdsd/main/online_order_sample.csv");
		List<Dish> dishes = ReadOrders.ordersToDishes(orders);
		RestaurantOperations op = new RestaurantOperations();
		
		System.out.println("NUMBER OF ORDERS: " + op.getNumberOrders(orders) + "\n");
		System.out.println("FIRST ORDER: " + op.getOrder(orders, 0) + "\n");
		System.out.println("LAST ORDER: " + op.getOrder(orders, orders.size()-1) + "\n");
		System.out.println("ALL ORDERS:\n" + op.getAllOrdersToString(orders) );
		System.out.println("FIRST ORDER`S DISH: " + op.getDish(dishes, 0) + "\n");
		System.out.println("LAST ORDER`S DISH: " + op.getDish(dishes, dishes.size()-1) + "\n");
		System.out.println("ALL DISHES:\n" + op.getAllDishToString(dishes) );
		System.out.println("STARTERS:\n" + op.getAllDishToString(op.getDishesByType(dishes, "st")));
		System.out.println("MAIN COURSES:\n" + op.getAllDishToString(op.getDishesByType(dishes, "mc")));
		System.out.println("DESSERTS:\n" + op.getAllDishToString(op.getDishesByType(dishes, "ds")));
		System.out.println("GLUTEN-FREE DISHES:\n" + op.getAllDishToString(op.getDishesByFeature(dishes, "gfd")));
		System.out.println("VEGETARIAN DISHES:\n" + op.getAllDishToString(op.getDishesByFeature(dishes, "vgd")));
		System.out.println("HALAL-MEAT DISHES:\n" + op.getAllDishToString(op.getDishesByFeature(dishes, "hmd")));
		System.out.println("SEAFOOD-FREE DISHES:\n" + op.getAllDishToString(op.getDishesByFeature(dishes, "sfd")));
		System.out.println(op.getStatsByDishType(dishes, "st")  + "\n");
		System.out.println(op.getStatsByDishType(dishes, "mc")  + "\n");
		System.out.println(op.getStatsByDishType(dishes, "ds")  + "\n");
	}

}