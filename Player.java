import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Font;

public class Player extends Character{

	private int hp, mana, hpTimer, manaTimer;
	private Item skill, weapon;
	private boolean useWeapon = false;
	private boolean useSkill = false;

	private BufferedImage statBar = null;

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
		setHp(75);
		setMana(60);
		setHpTimer(0);
		setManaTimer(0);
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


	public void setHpTimer(int hpTimer){
		this.hpTimer = hpTimer;
	}

	public int getHpTimer(){
		return hpTimer;
	}

	public void setManaTimer(int manaTimer){
		this.manaTimer = manaTimer;
	}

	public int getManaTimer(){
		return manaTimer;
	}


	public void setUseWeapon(boolean useWeapon){
		this.useWeapon = useWeapon;
	}

	public void setUseSkill(boolean useSkill){
		this.useSkill = useSkill;
	}

	public boolean getUseWeapon(){
		return useWeapon;
	}

	public boolean getUseSkill(){
		return useSkill;
	}

	public void tick(){
		setWeapon();
		setSkill();

		hpTimer += 1;
		manaTimer += 1;

		//Recover life if below 100
		if(hp < 100 && hpTimer >= 100){
			hp = hp + 1;
			hpTimer = 0;
			
		}
		//Recover mana if below 100
		if(hp < 100 &&  manaTimer>= 220){
			mana = mana + 1;
			manaTimer = 0;
			
		}
	}

	public void scheduleWithFixedDelay(){

	}

	public void refillLife(){
		hp += 5;
	}

	public void render(Graphics g){
		try {
  			  img = ImageIO.read(new File(url));
  			  statBar = ImageIO.read(new File("Sprites/StatBar.png"));
  		}
		catch (IOException e) {
		}
		//Render player
		img = img.getSubimage(imgx, imgy, 48, 48);
		g.drawImage(img, x, y, 48, 48, null);
		//Render HP and Mana Box
		g.drawImage(statBar, 40, 40, 200, 40, null);

		g.setColor(new Color(95, 172, 91));
		g.setFont(new Font("Lato", Font.BOLD, 16)); 
		g.drawString("HP: " + getHp(), 60, 65);
		g.setColor(Color.BLUE);
		g.drawString("Mana: " + getMana(), 140, 65);

		try{
			if(useWeapon){
				getWeapon().render(g);
			}
		}
		catch(NullPointerException e){
			System.out.println("You must equip a Weapon in inventory, use 'I' to open inventory");
		}
		try{
			if(useSkill){
				getSkill().render(g);
			}
		}
		catch(NullPointerException e){
			System.out.println("You must equip an Skill in inventory, use 'I' to open inventory");
		}
	}

}