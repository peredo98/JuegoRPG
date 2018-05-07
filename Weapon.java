public class Weapon extends Item{
	private int Damage;
	private String name;
	public Weapon(int imgx, int imgy, int imgw, int imgh, String url, String name, int damage){
		super(imgx, imgy, imgw, imgh, url, name, damage);
		setID(ID.Weapon);
	}

	
}