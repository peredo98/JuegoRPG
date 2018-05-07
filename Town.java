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
	private Door toWoods2;
	private Door toWoods3;
	private Npc npc1;
	private Npc npc2;
	private Npc npc3;


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
		toWoods2.setX(x + 1280);
		toWoods2.setY(y + 451);
		toWoods3.setX(x + 1280);
		toWoods3.setY(y + 515);
		npc1.setX(x + 980);
		npc1.setY(y + 350);
		npc2.setX(x + 305);
		npc2.setY(y + 705);
		npc3.setX(x + 458);
		npc3.setY(y + 380);
	}
	public void setDoorsAndNpc(){
		House1 house1 = new House1(153, -81, handler);
		House2 house2 = new House2(153, -81, handler);
		Taqueria taqueria = new Taqueria(213, -339, handler);
		Woods woods = new Woods(-358, -2457, handler);
		toHouse1 = new Door(x + 384, y + 320, house1);
		toHouse2 = new Door(x + 704, y + 320, house2);
		toTaqueria = new Door(x + 1024, y + 320, taqueria);
		toWoods = new Door(x + 1280, y + 387, woods);
		toWoods2 = new Door(x + 1280, y + 451, woods);
		toWoods3 = new Door(x + 1280, y + 515, woods);
		handler.addObject(toHouse1);
		handler.addObject(toHouse2);
		handler.addObject(toTaqueria);
		handler.addObject(toWoods);
		handler.addObject(toWoods2);
		handler.addObject(toWoods3);
		npc1 = new Npc(x + 980, y + 350, 48, 0, "Sprites/People1.png");
		npc2 = new Npc(x + 305, y + 705, 336, 240, "Sprites/People1.png");
		npc3 = new Npc(x+ 458, y +380, 384, 0, "Sprites/People1.png");
		handler.addObject(1, npc1);
		handler.addObject(1, npc2);
		handler.addObject(1, npc3);
		npc1.setText(" TACOS TACOS TACOS 2X1 VENGAN POR SUS TACOS !!!");
		npc2.setText(" Creo que hoy me comere unos taquitos aprovechando el 2x1");
		npc3.setText(" Buenos dias Juan vas por tacos ?");
	}

}