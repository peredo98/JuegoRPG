import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Door extends GameObject{
	private BufferedImage img = null;

	public Door(int x, int y, Map map){
		super(x, y, map);
		setID(ID.Door);
		setUrl("Sprites/!Door1.png");
	}


	public void tick(){
		
	}


	public void render(Graphics g){
		try {
  			  img = ImageIO.read(new File(url));
		} 
		catch (IOException e) {
		}
		img = img.getSubimage(0, 0, 48, 48);
		g.drawImage(img, x, y, 70, 64, null);
		//System.out.println(x+ " " + " " +y);
	}


}