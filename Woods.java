import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Woods extends Map{
	private BufferedImage img = null;
	private Handler handler;
	private Door toTown;
	private Door toCave;
	private Enemy en1;
	private Npc npc1;
	private Npc npc2;

	public Woods(int x, int y, Handler handler){
		super(x, y);
		this.handler = handler;
		setID(ID.Map);
		setUrl("MapImages/Map004.png");
	}


	public boolean limitMap(){
		if((y>-1980 &&x<-2713 && x>-2760 )||(y<-2259 && y>-2322 && x<-1836 && x>-1919 )||(x < -2894 || x > 355) || (y < -2807 || y > 251) ||(x> -347 && x<-662 && y <-2335) || (x> -662 && y > -2338) ||( x< -826 && x> -1303 && y< -1803 && y> -2361) ||(x < -829 && y> -1749 && x> -1402 && y< -1557) ||(x>-694 && y>-1280) ||(x<-796 && y>-1280) ||(x<-300 && y<-2583) ||( x>-349 && y< -2340 ) ||(x<-1075 && x>-1303 && y<-2350 && y> -2673 )|| (x< -1342 && y<-1629 && x>-1429 && y>- 2070) || (x<-1342 && y> -2070 && x> -1942 && y< -1938) || (x<- 1910 && y<-2079 && x>-2005 && y>-2460) || (x<-1333 && y>-2265 && x>-1876 && y< -2127) || (x<-1910 && x>-2005 && y<-1938 && y>-2460) ||(y<-2127 && y>-2460 && x<-1786 && x>-1876) ||(x<-1786 && x>-2005 && y> -2460 && y<-2325) ||(x<-1250 && x>-1753 && y<-2322 && y> -2454) || (x<-1200 && x>-2780 && y<-2508) ||(x<-2746 && y> -2611) ||(y> -1680 && x<-826  && x>-1687) || (x<-1429 && x> -2587 && y<-1938 && y>-2070) ||(x<-1462 && y<-1743 && y>-1887) || (x<-1607 && y>-1380)|| (x<-1717 && x>-2077 && y>-1686 && y<-1428) ||(x<-1975 && x>-2077 &&y> -1760 && y<-1590) || (x<-2104 && x>-2203 && y<-1380 && y>-1692) ||(y>-1692 &&x<-2101 && x>-2623) ||(x<-2704 && y>-1689) ||(x<-2644 && x>-2704 && y>-1555)||(x<-2038 && x>-2332 && y>-2460 && y<-2322) ||(x<-2038 && x>-2137 && y>-2460 && y<-2130)|| (x<-2037 && x>-2329 && y>-2265 && y<-2130) || (x<-2170 && x>-2329 && y>-2259 &&y<-1938) ||(x<-2614 && x>-2713 && y<-1870 && y>-2271) ||(x<-2353 && x>-2713 &&y<-2127 && y>-2259) || (x<-2362 && x>-2527 && y<-2130 && y>-2463 ) || (x<-2527 && x>-2587 && y<-2322 && y>-2463) ||(x<-2620 && y<-2322 && y>-2463) ||(x>-2563 && x<-2362 && y<-2322 && y>-2463) ||(x<-2700 && x>-2746 && y>-1970)){
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
		toCave.setX(x + 3005);
		toCave.setY(y + 1785);
		en1.setX(x + 800);
		en1.setY(y + 2688);
		npc1.setX(x + 2253);
		npc1.setY(y + 2555);
		npc2.setX(x + 3080);
		npc2.setY(y + 2210);
	}
	
	public void setDoorsAndNpc(){
		Town town = new Town(-881, -190, handler);
		toTown = new Door(x + 640, y + 2688 , town);
		handler.addObject(toTown);
		Cave cave = new Cave(-614, -1541, handler);
		toCave = new Door(x +3005, y +1785, cave);
		handler.addObject(toCave);
		en1 = new Enemy(x + 800, y + 2688, 288, 0, "Sprites/Monster.png", handler);
		handler.addObject(1, en1);
		npc1 = new Npc(x + 2253, y + 2555, 0, 192, "Sprites/!Chest.png");
		handler.addObject(1, npc1);
		npc1.setText("Obtienes Iron Sword x1");
		npc2 = new Npc(x + 3080, y + 2210, 0, 192, "Sprites/!Chest.png");
		handler.addObject(1,npc2);
		npc2.setText("Obtienes Iron Punch x1");
	}

}