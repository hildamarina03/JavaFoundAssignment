package bts.mdsd.main;

public class Dessert extends Dish  {
	
	private int calories;

	public Dessert(String dishName, boolean gfd, boolean vgd, boolean hmd, boolean sfd, int calories) {
		super(dishName, gfd, vgd, hmd, sfd);
		this.calories= calories;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public String getDishtype() {
		return "Dessert";
	}
	
	public String getExtras() {
		return String.valueOf(this.getCalories()) + " calories";
	}

}