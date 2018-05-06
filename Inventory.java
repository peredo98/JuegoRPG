
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.LinkedList;

public class Inventory extends GameObject{
	private boolean isDisplaying = false;
	private BufferedImage img = null;
	private Item [][] bag = new Item [5][6];

	LinkedList<Item> items = new LinkedList<Item>();

	public Inventory(){
		setID(ID.Inventory);
		addItem(new Weapon(0, 192, 32, 32, "Sprites/IconSet.png"));
		addItem(new Skill(0, 128, 32, 32, "Sprites/IconSet.png"));
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

			g.drawString("Weapon:", 110, 170);
			g.fillRect(110, 180, 50, 50);

			g.drawString("Skill:", 110, 250);
			g.fillRect(110, 260, 50, 50);



			for(int i = 0; i<bag.length; i++){
				for(int j = 0; j<bag[i].length; j++){
					g.fillRect(435+(i*54), 160+(j*54), 50 , 50);
					try{
					g.drawImage(bag[i][j].getImage(), 435+(i*54), 160+(j*54), 50 , 50, null);
					}
					catch(NullPointerException e){}
				}
			}	
			//g.drawImage(bag[0][0].getImage(), 435+(0*54), 160+(0*54), 50 , 50, null);	
		}
	}
	public void tick(){

	}

	public void addItem(Item item){
		items.add(item);
		int i = (items.indexOf(item))%5;
   		int j = (items.indexOf(item))/5;
   		bag[i][j] = item;
	}

	public void removeItem(Item item){
		int i = (items.indexOf(item))%5;
   		int j = (items.indexOf(item))/5;
   		bag[i][j] = null;
   		items.remove(item);
	}

}