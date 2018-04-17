import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Player extends GameObject{

	public Player(int x, int y, ID id){
		super(x, y, id);
	}

	public void tick(){
		x += velx;
		y += vely;
	}

	public void render(Graphics g){
		BufferedImage img = null;
		try {
  			  img = ImageIO.read(new File("Sprites/Actor1.png"));
		} 
		catch (IOException e) {}
		g.drawImage(img, x, y, 50, 50, null);
	}
}