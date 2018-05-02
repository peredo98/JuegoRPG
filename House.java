import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class House extends Map{
	private BufferedImage img = null;
	private Handler handler;
	private Door toTown;

	public House(int x, int y, Handler handler){
		super(x, y);
		this.handler = handler;
		setID(ID.Map);
		setUrl("MapImages/Map002.png");
	}


	public boolean limitMap(){
		if((x < 72 || x > 291) || (y < -81 || y > 159) || (x < 138 && y < 48) || (x > 165 && y < 48) || (x > 102 && y > 99)){
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
		g.drawImage(img, x, y, 384, 384, null);
		toTown.setX(x + 192);
		toTown.setY(y + 384);
	}
	
	public void setDoors(){
		Town town = new Town(-47, -91, handler);
		toTown = new Door(x + 192, y + 384, town);
		handler.addObject(toTown);

	}

}