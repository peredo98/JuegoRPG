public class Enemy extends Character{

	private int hp, damage;
	private boolean isDisplayed = false;

	
	public Enemy(int x, int y, int imgx, int imgy, String url,int damage, Handler handler){
		super(x, y, imgx, imgy, url);
		this.damage = damage;
		setID(ID.Enemy);
		setHp(100);
	}

	public void setHp(int hp){
		this.hp = hp;
	}

	public int getHp(){
		return hp;
	}

	public void setDamage(int damage){
		this.damage = damage;
	}

	public int getDamage(){
		return damage;
	}

	public boolean getIsDisplayed(){
		return isDisplayed;
	}

}