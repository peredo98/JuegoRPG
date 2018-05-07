import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Taqueria extends Map{
	private BufferedImage img = null;
	private Handler handler;
	private Door toTown;
	private Npc npc1;
	private Npc npc2;
	private Npc npc3;
	private Npc npc4;
	private Npc npc5;
	private Npc npc6;

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
		npc1.setX(x + 128);
		npc1.setY(y + 330);
		npc2.setX(x + 328);
		npc2.setY(y + 380);
		npc3.setX(x + 458);
		npc3.setY(y + 380);
		npc4.setX(x + 710);
		npc4.setY(y + 300);
		npc5.setX(x + 10);
		npc5.setY(y + 110);
		npc6.setX(x + 135);
		npc6.setY(y + 110);
	}
	
	public void setDoorsAndNpc(){
		Town town = new Town(-680, -91, handler);
		toTown = new Door(x + 128, y + 640, town);
		npc1 = new Npc(x + 128, y + 330, 48, 192, "Sprites/People1.png");
		npc2 = new Npc(x + 328, y + 380, 336, 192, "Sprites/People1.png");
		npc3 = new Npc(x+ 700, y +385, 384, 0, "Sprites/People1.png");
		npc4 = new Npc(x+ 500, y +300, 240, 192, "Sprites/Actor2.png");
		npc5 = new Npc(x+ 10, y +110, 192, 96, "Sprites/People1.png");
		npc6 = new Npc(x+ 135, y +110, 528, 240, "Sprites/People1.png");
		npc2.setText("Si el taco legendario es lo que quieres dentro del bosque DON CHUY lo tiene");
		npc3.setText("DON CHUY es considerado el mejor Taquero del universo?");
		npc4.setText("..........................................");
		npc5.setText("Quiero 5 tacos de bistec");
		npc6.setText("Yo quiero 20 de chicharon");
		handler.addObject(toTown);
		handler.addObject(1, npc1);
		handler.addObject(1, npc2);
		handler.addObject(1, npc3);
		handler.addObject(1, npc4);
		handler.addObject(1, npc5);
		handler.addObject(1, npc6);

	}

}