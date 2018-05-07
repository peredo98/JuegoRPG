public class Enemy extends Character{

<<<<<<< HEAD
	private int hp, damage;
=======
	private int hp;
	private int damage;
>>>>>>> 20567382f2a81ecb2fbc2adf27ba4a980aa027e3
	
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