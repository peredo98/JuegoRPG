import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Color;
public class Door extends GameObject{

	public Door(int x, int y, Map map){
		super(x, y, map);
		setID(ID.Door);
	}


	public void tick(){
		
	}


	public void render(Graphics g){
		g.setColor(Color.white);
		g.drawRect(x, y, 64, 64);
		//System.out.println(x+ " " + " " +y);
	}


}