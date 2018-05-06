import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Woods extends Map{
	private BufferedImage img = null;
	private Handler handler;
	private Door toTown;

	public Woods(int x, int y, Handler handler){
		super(x, y);
		this.handler = handler;
		setID(ID.Map);
		setUrl("MapImages/Map004.png");
	}


	public boolean limitMap(){
		if((x < -2894 || x > 355) || (y < -2807 || y > 251) ||(x> -347 && x<-662 && y <-2335) || (x> -662 && y > -2338) ||( x< -826 && x> -1303 && y< -1803 && y> -2361) ||(x < -829 && y> -1737) ||(x>-694 && y>-1280) ||(x<-796 && y>-1280) ||(x<-300 && y<-2583) ||( x>-349 && y< -2340 ) ||(x<-1075 && x>-1303 && y<-2350 && y> -2573 )){
			return true;
		}
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
		g.drawImage(img, x, y, 3200, 3200, null);
		toTown.setX(x + 128);
		toTown.setY(y + 640);
	}
	
	public void setDoorsAndNpc(){
		Town town = new Town(-680, -91, handler);
		toTown = new Door(x + 128, y + 640, town);
		handler.addObject(toTown);
	}

}