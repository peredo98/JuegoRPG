
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;


public class Inventory extends GameObject{
	private boolean isDisplaying = false;
	private BufferedImage img = null;
	private Item [][] bag = new Item [5][6]; 
	                                                                                                        

	public Item items [] = new Item [30];

	private Item selectedWeapon;
	private Item selectedSkill;

	public Inventory(){
		setID(ID.Inventory);
		addItem(new Weapon(0, 192, 32, 32, "Sprites/IconSet.png", "Normal sword", 30));
		addItem(new Weapon(416, 128, 32, 32, "Sprites/IconSet.png", "Punch", 10));
		addItem(new Skill(0, 128, 32, 32, "Sprites/IconSet.png", "Fire Attack", 50, 60));
	}

	public void setIsDisplaying(boolean isDisplaying){
		this.isDisplaying = isDisplaying;
	}
	public boolean getIsDisplaying(){
		return isDisplaying;
	}
	private Item getWeapon(){
		return selectedWeapon;
	}

	private Item getSkill(){
		return selectedSkill;
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
			if(selectedWeapon != null){
				g.drawImage(selectedWeapon.getImage(), 110, 180, 50, 50, null);
			}

			g.drawString("Skill:", 110, 250);
			g.fillRect(110, 260, 50, 50);
			if(selectedSkill != null){
				g.drawImage(selectedSkill.getImage(), 110, 260, 50, 50, null);
			}

			for(int i = 0; i<bag.length; i++){
				for(int j = 0; j<bag[i].length; j++){
					int cellx = 435+(i*54);
					int celly = 160+(j*54);
					g.fillRect(cellx, celly, 50 , 50);
				}
			}

			for(int i = bag.length -1; i >= 0; i--){
				for(int j = bag.length -1; j >= 0; j--){
					try{
						if(bag[i][j].getHover()){
							g.setColor(Color.DARK_GRAY);
							g.fillRect(bag[i][j].getCellx() + 50, bag[i][j].getCelly() - 60, 200 , 100);
							g.setColor(Color.lightGray);
							g.drawString(("Type: " + bag[i][j].getType()),bag[i][j].getCellx() + 70, bag[i][j].getCelly() - 40);
							g.drawString(("Name: " + bag[i][j].getName()),bag[i][j].getCellx() + 70, bag[i][j].getCelly() - 20);
							g.drawString(("Damage: " + bag[i][j].getDamage()),bag[i][j].getCellx() + 70, bag[i][j].getCelly());
							if(bag[i][j].getType() == "Skill"){
								Skill tempSkill = (Skill) bag[i][j];
								g.drawString(("Mana: " + tempSkill.getMana()),tempSkill.getCellx() + 70, tempSkill.getCelly()+20);
							}
						}
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
		int index = 0;
		for(int i = 0; i<items.length; i++){
			if(items[i] == null){
				items[i] = item;
				break;
			}
		}
		for(int i = 0; i<items.length; i++){
			if(items[i] == item){
				index = i;
				break;
			}
		}
		int i = index%5;
   		int j = index/5;
   		item.setBounds(435+(i*54), 435+(i*54)+50, 160+(j*54), 160+(j*54)+50);
   		bag[i][j] = item;
	}

	public void addItem(int index, Item item){
		for(int i = 0; i<items.length; i++){
			if(items[i] == null){
				items[i] = item;
				break;
			}
		}
		int i = index%5;
   		int j = index/5;
   		item.setBounds(435+(i*54), 435+(i*54)+50, 160+(j*54), 160+(j*54)+50);
   		bag[i][j] = item;
	}

	public void setItem(int index, Item item){
		int oldIndex = 0;
		for(int i = 0; i<items.length; i++){
			if(items[i] == item){
				oldIndex = i;
				break;
			}
		}
		int i = oldIndex%5;
   		int j = oldIndex/5;
		int x = index%5;
		int y = index/5;
		items[oldIndex] = null;
		items[index] = item;
		bag[i][j] = null;
		bag[x][y] = item;
 	}

	public void removeItem(Item item){
		int index = 0;
		for(int i = 0; i<items.length; i++){
			if(items[i] == item){
				index = i;
				break;
			}
		}
		int i = index%5;
   		int j = index/5;
   		bag[i][j] = null;
   		items[index] = null;
	}

	public void moveItem(Item item){
		int index = 0; 
		int lastIndex = 0;
		try{
			for(int i = 0; i<items.length; i++){
				if(items[i] == item){
					index = i;
					break;
				}
			}
			int x = index%5;
	   		int y = index/5;
			for(int i = 0; i<bag.length; i++){
				for(int j = 0; j<bag[i].length; j++){
					int cellx = 435+(i*54);
					int celly = 160+(j*54);
					if((item.getCellx() + 25 ) >= cellx && (item.getCellx() + 25 ) <= (cellx + 50) && (item.getCelly() + 25 ) >= celly && (item.getCelly() + 25 ) <= (celly + 50) ){
						lastIndex = (j*5+i);
						if(bag[i][j] != null){
							Item lastItem = items[lastIndex];
							items[index] = lastItem;
							lastItem.setBounds(435+(x*54), 435+(x*54)+50, 160+(y*54), 160+(y*54)+50);
							bag[x][y] = lastItem;
						}
						else if (bag[i][j] == null){
							items[index] = null;
							bag[x][y] = null;
						}
						bag[i][j] = item;
						items[lastIndex] = item;
						item.setBounds(435+(i*54), 435+(i*54)+50, 160+(j*54), 160+(j*54)+50);
						return;
					}
					if((item.getCellx() + 25 ) >= 110 && (item.getCellx() + 25 ) <= (110 + 50) && (item.getCelly() + 25 ) >= 180 && (item.getCelly() + 25 ) <= (180 + 50) ){
						if(item.getID() == ID.Weapon){
							selectedWeapon = item;
						}
					}
					if((item.getCellx() + 25 ) >= 110 && (item.getCellx() + 25 ) <= (110 + 50) && (item.getCelly() + 25 ) >= 260 && (item.getCelly() + 25 ) <= (260 + 50) ){
						if(item.getID() == ID.Skill){
							selectedSkill = item;
						}
					}
				}
			}
	   		item.setBounds(435+(x*54), 435+(x*54)+50, 160+(y*54), 160+(y*54)+50);
	   		bag[x][y] = item;
		}catch(NullPointerException e){}
	}

}