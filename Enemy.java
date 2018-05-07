public class Enemy extends Character{

	private int hp, damage;
	
	public Enemy(int x, int y, int imgx, int imgy, String url){
		super(x, y, imgx, imgy, url);
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

}