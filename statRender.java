import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class statRender extends GameObject{
	private boolean isDisplaying = false;
	private BufferedImage img = null;

	public statRender(){
		setID(ID.stats);

	}

	public void setIsDisplaying(boolean isDisplaying){
		this.isDisplaying = isDisplaying;
	}

	public boolean getIsDisplaying(){
		return isDisplaying;
	}

	public void render(Graphics g){
		if(isDisplaying){
			try{
				img = ImageIO.read(new File("Spirtes/statBar.png"));
			}
			catch(IOException e){}

			g.drawImage(img, 40, 40, 100, 20, null);
			g.setColor(Color.lightGray);
			g.drawString("HP: 100", 90, 40);


		}
	}

	public void tick(){

	}

}