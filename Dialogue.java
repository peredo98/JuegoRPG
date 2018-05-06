
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Dialogue extends GameObject{
	private BufferedImage img = null;

	private String text;

	public Dialogue(String text){
		this.text = text;
		setID(ID.Dialogue);
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	public void tick(){

	}

	public void render(Graphics g){
		try {
  			  img = ImageIO.read(new File("Sprites/Dialogue.png"));
		} 
		catch (IOException e) {
		}
		g.drawImage(img, 100, 450, 500, 100, null);
		g.setColor(Color.blue);
		g.drawString(text, 150, 490);
	}
}