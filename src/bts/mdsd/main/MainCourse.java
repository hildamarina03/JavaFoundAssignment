package bts.mdsd.main;

public class MainCourse extends Dish  {
	
	private String mainIngredient;
	private String drink;

	
	public MainCourse(String dishName, boolean gfd, boolean vgd, boolean hmd, boolean sfd, String extra) {
		super(dishName, gfd, vgd, hmd, sfd);
		String[] extras = extra.split("-");
		this.mainIngredient= extras[0];
		this.drink= extras[1];
	}

	public String getMainIngredient() {
		return mainIngredient;
	}

	public void setMainIngredient(String mainIngredient) {
		this.mainIngredient = mainIngredient;
	}

	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public String getDishtype() {
		return "Main course";
	}
	
	public String getExtras() {
		return this.getMainIngredient() + " and " + this.getDrink() + " to drink";
	}

}