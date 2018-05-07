public class Skill extends Item{
	private int mana;
	public Skill(int imgx, int imgy, int imgw, int imgh, String url, String name, int damage, int mana){
		super(imgx, imgy, imgw, imgh, url, name, damage);
		this.mana = mana;
		setID(ID.Skill);
	}
	public void setMana(int mana){
		this.mana = mana;
	}
	public int getMana(){
		return mana;
	}
}