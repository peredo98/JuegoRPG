import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public abstract class Map extends GameObject{
	private BufferedImage img = null;

	public Map(int x, int y, String url){
		super(x, y, url);
		setID(ID.Map);
	}


	public void tick(){

		
		x += velx;
		y += vely;

		//limitar el mapa

		if(limitMap()){
		x -= velx;
		y -= vely;
		}
		

	}

	public void render(Graphics g){
		try {
  			  img = ImageIO.read(new File(url));
		} 
		catch (IOException e) {
		}
		g.drawImage(img, x, y, 1280, 960, null);
	}

	public abstract boolean limitMap();

}