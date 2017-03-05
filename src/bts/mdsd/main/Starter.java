package bts.mdsd.main;

public class Starter extends Dish  {
	
	private String cutlery;

	public Starter(String dishName, boolean gfd, boolean vgd, boolean hmd, boolean sfd, String cutlery) {
		super(dishName, gfd, vgd, hmd, sfd);
		this.cutlery= cutlery;
	}

	public String getCutlery() {
		return this.cutlery;
	}

	public void setCutlery(String cutlery) {
		this.cutlery = cutlery;
	}

	public String getDishtype() {
		return "Starter";
	}
	
	public String getExtras() {
		return getCutlery();
	}

}