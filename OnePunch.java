import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class OnePunch extends Item{
	private BufferedImage img = null;
	private int mana;
	private int delay = 0;
	public OnePunch(int imgx, int imgy, int imgw, int imgh, String url, String name, int damage, int mana){
		super(imgx, imgy, imgw, imgh, url, name, mana);
		this.mana = mana;
		setID(ID.Skill);
	}

	public void render(Graphics g){
		try {
  			img = ImageIO.read(new File("Sprites/Wind5.png"));
  		}
		catch (IOException e) {
		}

		if (delay == 1){
			img = img.getSubimage(0, 0, 192, 192);
		}
		if (delay == 2){
			img = img.getSubimage(192, 0, 192, 192);
		}
		if (delay == 3){
			img = img.getSubimage(384, 0, 192, 192);
		}
		if (delay == 4){
			img = img.getSubimage(576, 0, 192, 192);
		}
		if (delay == 5){
			img = img.getSubimage(768, 0, 192, 192);
		}
		if (delay == 6){
			img = img.getSubimage(0, 192, 192, 192);
		}
		if (delay == 7){
			img = img.getSubimage(192, 192, 192, 192);
		}
		if (delay == 8){
			img = img.getSubimage(384, 192, 192, 192);
		}
		if (delay == 9){
			img = img.getSubimage(576, 192, 192, 192);
		}
		if (delay == 10){
			img = img.getSubimage(768, 192, 192, 192);
		}
		if (delay == 11){
			img = img.getSubimage(0, 384, 192, 192);
		}
		if (delay == 12){
			img = img.getSubimage(192, 384, 192, 192);
		}
		if (delay == 13){
			img = img.getSubimage(384, 384, 192, 192);
		}
		if (delay == 14){
			img = img.getSubimage(576, 384, 192, 192);
		}
		if (delay == 15){
			img = img.getSubimage(768, 384, 192, 192);
		}
		if (delay == 16){
			img = img.getSubimage(0, 576, 192, 192);
		}
		if (delay == 17){
			img = img.getSubimage(192, 576, 192, 192);
		}
		if (delay == 18){
			img = img.getSubimage(384, 576, 192, 192);
		}
		if (delay == 19){
			img = img.getSubimage(576, 576, 192, 192);
		}
		if (delay == 20){
			img = img.getSubimage(768, 576, 192, 192);
		}
		if (delay == 21){
			img = img.getSubimage(0, 768, 192, 192);
		}
		if (delay == 22){
			img = img.getSubimage(192, 768, 192, 192);
		}
		if (delay == 23){
			img = img.getSubimage(384, 768, 192, 192);
		}
		if (delay == 24){
			img = img.getSubimage(576, 768, 192, 192);
		}
		if (delay == 25){
			img = img.getSubimage(768, 768, 192, 192);
		}
		if (delay == 26){
			img = img.getSubimage(0, 960, 192, 192);
		}
		if (delay == 27){
			img = img.getSubimage(192, 960, 192, 192);
		}
		if (delay == 28){
			img = img.getSubimage(384, 960, 192, 192);
			delay = 0;
			return;
		}

		g.drawImage(img, 0, 0, 800, 600, null);
		delay ++;
	}
}