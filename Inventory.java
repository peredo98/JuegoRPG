
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Inventory extends GameObject{
	private boolean isDisplaying = false;
	private BufferedImage img = null;
	private int [][] bag = new int [5][6];

	public Inventory(){
		setID(ID.Inventory);
	}

	public void setIsDisplaying(boolean isDisplaying){
		this.isDisplaying = isDisplaying;
	}
	public boolean getIsDisplaying(){
		return isDisplaying;
	}

	public void render(Graphics g){
		if(isDisplaying){
			try {
	  			  img = ImageIO.read(new File("Sprites/Inventory.png"));
			} 
			catch (IOException e) {
			}
			g.drawImage(img, 85, 110, 630, 380, null);
			g.setColor(Color.lightGray);
			g.fillRect(110, 180, 50, 50);
			g.drawString("Weapon:", 110, 170);
			for(int i = 0; i<bag.length; i++){
				for(int j = 0; j<bag[i].length; j++){
					g.fillRect(435+(i*54), 160+(j*54), 50 , 50);
				}
			}
			
		}
	}
	public void tick(){

	}
}