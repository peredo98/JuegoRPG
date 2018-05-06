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
		if((x < -2894 || x > 355) || (y < -2807 || y > 251) ||(x> -347 && x<-662 && y <-2335) || (x> -662 && y > -2338) ||( x< -826 && x> -1303 && y< -1803 && y> -2361) ||(x < -829 && y> -1749 && x> -1402 && y< -1557) ||(x>-694 && y>-1280) ||(x<-796 && y>-1280) ||(x<-300 && y<-2583) ||( x>-349 && y< -2340 ) ||(x<-1075 && x>-1303 && y<-2350 && y> -2673 )|| (x< -1342 && y<-1629 && x>-1429 && y>- 2070) || (x<-1342 && y> -2070 && x> -1942 && y< -1938) || (x<- 1910 && y<-2079 && x>-2005 && y>-2460) || (x<-1333 && y>-2265 && x>-1876 && y< -2127) || (x<-1910 && x>-2005 && y<-1938 && y>-2460) ||(y<-2127 && y>-2460 && x<-1786 && x>-1876) ||(x<-1786 && x>-2005 && y> -2460 && y<-2325) ||(x<-1250 && x>-1753 && y<-2322 && y> -2454) || (x<-1200 && x>-2749 && y<-2511 && x>-2746) ||(x<-2746 && y> -2511) ||(y> -1680 && x<-826  && x>-1687 )){
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
		g.drawImage(img, x, y, 3200, 3200, null);
		toTown.setX(x + 640);
		toTown.setY(y + 2688);
	}
	
	public void setDoorsAndNpc(){
		Town town = new Town(-881, -190, handler);
		toTown = new Door(x + 640, y + 2688 , town);
		handler.addObject(toTown);
	}

}