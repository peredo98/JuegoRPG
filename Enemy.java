public class Enemy extends Character{

	private int hp;
	private int damage;
	
	public Enemy(int x, int y, int imgx, int imgy, String url){
		super(x, y, imgx, imgy, url);
		setID(ID.Enemy);
		hp = 100;
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

}