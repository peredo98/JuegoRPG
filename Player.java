import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Player extends Character{

	private int hp, mana;
	private Item skill, weapon;

	public Player(int x, int y, int imgx, int imgy, Handler handler){
		super(x, y, imgx, imgy, handler);
		this.downImgy = imgy;
		this.leftImgy = imgy + 48;
		this.rightImgy = imgy +96;
		this.upImgy = imgy + 144;
		this.anim1 = imgx - 48;
		this.anim2 = imgx;
		this.anim3 = imgx + 48;
		setID(ID.Player);
		setUrl("Sprites/Actor1.png");
		setHp(100);
		setMana(100);
	}
	public void setWeapon(){
		this.weapon = handler.getInventory().getWeapon() ; 
	}

	public void setSkill(){
		this.skill= handler.getInventory().getSkill() ; 
	}

	public Item getWeapon(){
		return weapon;
	}
	public Item getSkill(){
		return skill;
	}
	public void setHp(int hp){
		this.hp = hp;
	}

	public int getHp(){
		return hp;
	}

	public void setMana(int mana){
		this.mana = mana;
	}

	public int getMana(){
		return mana;
	}

	public void tick(){
		setWeapon();
		setSkill();
	}

	public void render(Graphics g){
		try {
  			  img = ImageIO.read(new File(url));
		} 
		catch (IOException e) {
		}
		img = img.getSubimage(imgx, imgy, 48, 48);
		g.drawImage(img, x, y, 48, 48, null);
		g.drawString("HP: " + getHp(), 100, 500);
	}

}