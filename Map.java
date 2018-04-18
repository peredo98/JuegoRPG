import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Map extends GameObject{
	private BufferedImage img = null;

	public Map(int x, int y, ID id, String url){
		super(x, y, id, url);
		setImgx(48);
		setImgy(0);
	}


	public void tick(){

		
		x += velx;
		y += vely;

		//limitar el mapa

		if((x < -881 || x > 286) || (y < -589 || y > 152) || (x < -818 && y < -274) || (x < -245 && y > -91) || (x > 97 && y < -79) || (x > 46 && y < -415) || (x > -158 && x < 76 && y > -91) || (x > -797 && x < -242 && y > -544 && y < -211)){
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

	/*
	if((x >= -881 && x <= 94 && y >= -208 && y <= -106) || ()){
				x += velx;
				y += vely;
			
	 */

}