import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
public class Weapon extends Item{
	private BufferedImage img = null;
	private int delay = 0;
	public Weapon(int imgx, int imgy, int imgw, int imgh, String url, String name, int damage){
		super(imgx, imgy, imgw, imgh, url, name, damage);
		setID(ID.Weapon);
	}

	public void render(Graphics g){
		try {
  			  img = ImageIO.read(new File("Sprites/Hit2.png"));
  		}
		catch (IOException e) {
		}

		if (delay <= 5){
			img = img.getSubimage(0, 0, 192, 192);
		}
		if (delay <= 10 && delay > 5){
			img = img.getSubimage(192, 0, 192, 192);
		}
		if (delay == 15){
			img = img.getSubimage(384, 0, 192, 192);
			delay = 0;
			return;
		}

		g.drawImage(img, 200, 150, 400, 300, null);
		delay ++;
	}
}