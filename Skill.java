import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Skill extends Item{
	private BufferedImage img = null;
	private int mana;
	private int delay = 0;
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
	public void render(Graphics g){
		try {
  			img = ImageIO.read(new File("Sprites/HitFire.png"));
  		}
		catch (IOException e) {
		}

		if (delay <= 2){
			img = img.getSubimage(0, 0, 192, 192);
		}
		if (delay <= 4 && delay > 2){
			img = img.getSubimage(192, 0, 192, 192);
		}
		if (delay <= 6 && delay > 4){
			img = img.getSubimage(384, 0, 192, 192);
		}
		if (delay <= 8 && delay > 6){
			img = img.getSubimage(576, 0, 192, 192);
		}
		if (delay <= 10 && delay > 8){
			img = img.getSubimage(768, 0, 192, 192);
		}
		if (delay <= 12 && delay > 10){
			img = img.getSubimage(0, 192, 192, 192);
		}
		if (delay <= 14 && delay > 12){
			img = img.getSubimage(192, 192, 192, 192);
		}
		if (delay == 16){
			img = img.getSubimage(384, 192, 192, 192);
			delay = 0;
			return;
		}

		g.drawImage(img, 200, 150, 400, 300, null);
		delay ++;
	}
}