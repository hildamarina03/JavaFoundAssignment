package bts.mdsd.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadOrders {
	
	public static List<CustomerOrder> fileToOrders(String fileName) {
		List<CustomerOrder> orders = new ArrayList<>();
		Path filePath = Paths.get(fileName);
		try (BufferedReader buffer = Files.newBufferedReader(filePath, StandardCharsets.US_ASCII)) {
			buffer.readLine(); //Skip header
			String line = buffer.readLine();
			while (line != null) {
		   		 String[] lineArray = line.split(",");	
		   		 CustomerOrder order = arrayToCustomerOrder(lineArray);
				 orders.add(order);
				 line = buffer.readLine();
				 
			}
		} catch (IOException ioe) {
            ioe.printStackTrace();
        }
			
		return orders;
	}
	
	private static CustomerOrder arrayToCustomerOrder(String[] attributes)  {
		String customerName = attributes[0];
		String dishName = attributes[1];
		String type = attributes[2];
		Boolean gfd = Boolean.valueOf(attributes[3]);
		Boolean vgd = Boolean.valueOf(attributes[4]);
		Boolean hmd = Boolean.valueOf(attributes[5]);
		Boolean sfd = Boolean.valueOf(attributes[6]);
		String extra =  attributes[7];
		
		Dish dishOrder;
		
		switch(type){
			case "st":
				 dishOrder = new Starter(dishName, gfd, vgd, hmd, sfd, extra); 
				 break;
			case "mc":
				 dishOrder = new MainCourse(dishName, gfd, vgd, hmd, sfd, extra); 
				 break;
			 case "ds":
				 dishOrder = new Dessert(dishName, gfd, vgd, hmd, sfd, Integer.parseInt(extra)); 
				 break;
			 default:
				 dishOrder = new Starter(dishName, gfd, vgd, hmd, sfd, extra);
				 break;
		 }
		
		return (CustomerOrder) new CustomerOrder(customerName, dishOrder);
	}
	
	public static List<Dish> ordersToDishes(List<CustomerOrder> orderList) {
		List<Dish> dishes = new ArrayList<>();
		for(int i = 0; i < orderList.size(); i++){
			CustomerOrder order = orderList.get(i);
			dishes.add(order.getOrderDish());
		}
		
		return dishes;
	}
	
}