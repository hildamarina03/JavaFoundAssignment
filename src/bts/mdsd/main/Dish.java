package bts.mdsd.main;

public abstract class Dish 
{
	public Dish() { }
	
	private String dishName;
	private boolean gfd;
	private boolean vgd;
	private boolean hmd;
	private boolean sfd;
	
	public Dish(String dishName, boolean gfd, boolean vgd, boolean hmd, boolean sfd) {
		this.dishName = dishName;
		this.gfd = gfd;
		this.vgd = vgd;
		this.hmd = hmd;
		this.sfd = sfd;
	}

	public String getDishName() { 
		return dishName; 
	}
	
	public void setDishName(String dName) { 
		this.dishName = dName; 
	}

	public boolean isGfd() {
		return gfd;
	}

	public void setGfd(boolean gfd) {
		this.gfd = gfd;
	}

	public boolean isVgd() {
		return vgd;
	}

	public void setVgd(boolean vgd) {
		this.vgd = vgd;
	}

	public boolean isHmd() {
		return hmd;
	}

	public void setHmd(boolean hmd) {
		this.hmd = hmd;
	}

	public boolean isSfd() {
		return sfd;
	}

	public void setSfd(boolean sfd) {
		this.sfd = sfd;
	}
	
	private String getFoodGroup(){
		String foodGroup = "No food group";
		if(this.gfd){
			foodGroup = "Gluten-free";
		}else if(this.vgd){
			foodGroup = "Vegetarian";
		}else if(this.hmd){
			foodGroup = "Halal-meat";
		}else if(this.sfd){
			foodGroup = "Seafood-free";
		}
		return foodGroup;
	}
	
	public abstract String getDishtype();
	public abstract String getExtras();
	
	@Override
	public String toString() {
		return this.getDishtype() + ", " + this.getDishName()+ "("+ this.getFoodGroup() + ") with " +this.getExtras();
	}
	
}
