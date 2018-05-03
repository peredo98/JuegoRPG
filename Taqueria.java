import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Taqueria extends Map{
	private BufferedImage img = null;
	private Handler handler;
	private Door toTown;

	public Taqueria(int x, int y, Handler handler){
		super(x, y);
		this.handler = handler;
		setID(ID.Map);
		setUrl("MapImages/Map003.png");
	}


	public boolean limitMap(){
		if((x < -567 || x > 360) || (y < -339 || y > 228) || (x < 201 && y < -210) || (x < -378 && y > 165) || (x > 228 && y < -210) || (x > -414 && y < 48 && y > -24) || (x > 102 && y < 48 && y > -156) || (x < -558 && y < 48 && y > -156) || (x < -375 && x > -414 && y < 48 && y > -156)){
			return true;
		}
		else{
			return false;
		}
	}

	public void render(Graphics g){
		
		try {
  			  img = ImageIO.read(new File(url));
		} 
		catch (IOException e) {
		}
		g.drawImage(img, x, y, 960, 640, null);
		toTown.setX(x + 128);
		toTown.setY(y + 640);
	}
	
	public void setDoors(){
		Town town = new Town(-680, -91, handler);
		toTown = new Door(x + 128, y + 640, town);
		handler.addObject(toTown);
	}

}