
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
					int cellx = 435+(i*54);
					int celly = 160+(j*54);
					g.fillRect(cellx, celly, 50 , 50);
				}
			}

			for(int i = 0; i<bag.length; i++){
				for(int j = 0; j<bag[i].length; j++){
					try{
					g.drawImage(bag[i][j].getImage(), bag[i][j].getCellx(), bag[i][j].getCelly(), 50 , 50, null);
					}
					catch(NullPointerException e){}
				}
			}	
		}
	}

	public void tick(){

	}

	public void addItem(Item item){
		items.add(item);
		int i = (items.indexOf(item))%5;
   		int j = (items.indexOf(item))/5;
   		item.setBounds(435+(i*54), 435+(i*54)+50, 160+(j*54), 160+(j*54)+50);
   		bag[i][j] = item;
	}

	public void removeItem(Item item){
		int i = (items.indexOf(item))%5;
   		int j = (items.indexOf(item))/5;
   		bag[i][j] = null;
   		items.remove(item);
	}

	public void moveItem(Item item){
		try{
			int index = items.indexOf(item);
			int x = index%5;
	   		int y = index/5;
			for(int i = 0; i<bag.length; i++){
				for(int j = 0; j<bag[i].length; j++){
					int cellx = 435+(i*54);
					int celly = 160+(j*54);
					if((item.getCellx() + 25 ) >= cellx && (item.getCellx() + 25 ) <= (cellx + 50) && (item.getCelly() + 25 ) >= celly && (item.getCelly() + 25 ) <= (celly + 50) ){
						if(bag[i][j] != null){
							Item lastItem = items.get(j*5+i);
							items.set(index, lastItem);
							lastItem.setBounds(435+(x*54), 435+(x*54)+50, 160+(y*54), 160+(y*54)+50);
							bag[x][y] = lastItem;
						}
						bag[i][j] = item;
						items.set((j*5+i), item);
						item.setBounds(435+(i*54), 435+(i*54)+50, 160+(j*54), 160+(j*54)+50);
						return;
					}
				}
			}
	   		item.setBounds(435+(x*54), 435+(x*54)+50, 160+(y*54), 160+(y*54)+50);
	   		bag[x][y] = item;
		}catch(NullPointerException e){}
	}

}