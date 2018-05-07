import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Cave extends Map{
	private BufferedImage img = null;
	private Handler handler;
	private Door toWoods;
	private Npc npc1;
	private Enemy en1;

	public Cave(int x, int y, Handler handler){
		super(x, y);
		this.handler = handler;
		setID(ID.Map);
		setUrl("MapImages/Map008.png");
	}

	public boolean limitMap(){
		if((x<-581 && x>-645 && y<-1620) ||(x>-599 && y>-1640 && y<-1487)||(x>-475 && x<-377 && y>-1507 && y<-1263) ||(x<-512 && x>-596 && y>-1370 && y<-1292) ||(x<-443 && x>-542 && y>-1304 && y<-785)||(x>-599 && x<-377 && y<-1040 && y>-1304) ||(x>-540 && x<-377 && y>-1040 && y<-986)||(x<-443 &&x>-602 && y>-986 && y<-860 ) ||(x<-506 && x>-605 && y>-986) ||(x<-590 && x>-650 && y>-668)||(x<-707 && x>-791 && y>-668) ||(x<-610 &&  x>-737 && y>-602) ||(y>-602 && y<-281 && x<-764 && x>-983) ||(x<-950 && x>-1030 && y>-533 && y<-281) ||(x<-1028 && x>-1154 && y>-467 && y<-340)||(x>-1100 && x<-908 && y>-341 && y<-281) ||(x<-1050 && x>-1300 && y>-284) ||(x<-1268 && x>-1562 && y>-410 && y<-254) ||(y<-401 && y>-611 && x<-1205 && x>-1367) ||(x<-1334 && x>-1559 && y>-536) ||(x<-1559 && x>-1685 && y>-410 && y<10) ||(x<-1680 && x>-1814 && y>-20)||(x<1814 && x>-1990 && y>31) ||(x<-1979 && y>-338 && y<100) ||(x<-698 && x>-1724 && y<-719 && y>-1721) ||(x<-632 && y> -1721 && y<-1424 ) || (x<-1715 && y<-590) ||(x<-1847 && y>-690 && y<-461)||(x<-1913 && y>-561 && y<-332) ||(x<-1976 && y>-332 && y<31)){
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
		g.drawImage(img, x, y, 2624, 1920, null);
		toWoods.setX(x +960);
		toWoods.setY(y + 1920);
		npc1.setX(x + 2253);
		npc1.setY(y + 2555);
		en1.setX(x + 3080);
		en1.setY(y + 2210);
	}
	public void setDoorsAndNpc(){
		Woods woods = new Woods(-2665, -1623, handler);
		toWoods = new Door(x +960, y +1920, woods);
		handler.addObject(toWoods);
		npc1 = new Npc(x + 2253, y + 2555, 0, 192, "Sprites/!Chest.png");
		handler.addObject(1, npc1);
		npc1.setText("Obtienes Ice explosion ability");
		en1 = new Enemy(x + 800, y + 2688, 48, 192, "Sprites/Evil.png");
		handler.addObject(1,en1);
	}



}