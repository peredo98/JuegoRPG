import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public abstract class Map extends GameObject{

	public Map(int x, int y){
		super(x, y);
		setID(ID.Map);
	}

	public void tick(){

		x += velx;
		y += vely;

		//limitar el mapa

		if(limitMap()){
		x -= velx;
		y -= vely;
		}
		System.out.println(x+ " " +y);
		
	}

	public abstract void render(Graphics g);

	public abstract boolean limitMap();

	public abstract void setDoors();

}