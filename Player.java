import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Player extends GameObject{
	private BufferedImage img = null;
	
	public Player(int x, int y, ID id){
		super(x, y, id);
		setImgx(48);
		setImgy(0);
	}


	public void tick(){

	}

	public void render(Graphics g){
		try {
  			  img = ImageIO.read(new File("Sprites/Actor1.png"));
		} 
		catch (IOException e) {
		}
		img = img.getSubimage(imgx, imgy, 48, 48);
		g.drawImage(img, x, y, 48, 48, null);
	}
}