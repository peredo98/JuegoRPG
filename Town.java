import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Town extends Map{
	private BufferedImage img = null;
	private Handler handler;
	private Door toHouse1;
	private Door toHouse2;
	private Door toTaqueria;
	private Door toWoods;

	public Town(int x, int y, Handler handler){
		super(x, y);
		this.handler = handler;
		setID(ID.Map);
		setUrl("MapImages/Map001.png");	
	}


	public boolean limitMap(){
		if((x < -881 || x > 286) || (y < -589 || y > 152) || (x < -818 && y < -274) || (x < -245 && y > -91) || (x > 97 && y < -79) || (x > 46 && y < -415) || (x > -158 && x < 76 && y > -91) || (x > -797 && x < -242 && y > -544 && y < -211)){
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
		g.drawImage(img, x, y, 1280, 960, null);
		toHouse1.setX(x + 384);
		toHouse1.setY(y + 320);
		toHouse2.setX(x + 704);
		toHouse2.setY(y + 320);
		toTaqueria.setX(x + 1024);
		toTaqueria.setY(y + 320);
		toWoods.setX(x + 1280);
		toWoods.setY(y + 387);
	}
	public void setDoors(){
		House1 house1 = new House1(153, -81, handler);
		House2 house2 = new House2(153, -81, handler);
		Taqueria taqueria = new Taqueria(213, -339, handler);
		Woods woods = new Woods(100, -1000, handler);
		toHouse1 = new Door(x + 384, y + 320, house1);
		toHouse2 = new Door(x + 704, y + 320, house2);
		toTaqueria = new Door(x + 1024, y + 320, taqueria);
		toWoods = new Door(x + 1280, y + 387, woods);
		handler.addObject(toHouse1);
		handler.addObject(toHouse2);
		handler.addObject(toTaqueria);
		handler.addObject(toWoods);
	}

}