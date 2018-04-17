import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Player extends GameObject{
	private BufferedImage img = null;
	
	public Player(int x, int y, ID id, int imgx, int imgy){
		super(x, y, id, imgx, imgy);
	}


	public void tick(){
		x += velx;
		y += vely;
	}

	public void render(Graphics g){
		try {
  			  img = ImageIO.read(new File("Sprites/Actor1.png"));
		} 
		catch (IOException e) {}
		img = img.getSubimage(imgx, imgy, 48, 48);
		g.drawImage(img, x, y, 50, 50, null);
	}
}