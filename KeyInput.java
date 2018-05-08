import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter{
	private Handler handler;
	private int delay = 0;
	private int changeRate = 5;
	private int vel = 3;

	public KeyInput(Handler handler){
		this.handler = handler;
	}

	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();

		for(int i = 0; i < handler.object.size(); i++){

			GameObject tempObject = handler.object.get(i);

			//Animacion del jugador
			int imgx = tempObject.getImgx();


			if(tempObject.getID() == ID.Player && !handler.isDialogueDisplaying()){
				delay ++;
				if (delay == changeRate){
					tempObject.setImgx(tempObject.getAnim1());
				}
				if (delay == (2 * changeRate)){
					tempObject.setImgx(tempObject.getAnim2());
				}
				if (delay == (3 * changeRate)){
					tempObject.setImgx(tempObject.getAnim3());
					delay = 0;
				}

				if(key == KeyEvent.VK_W){
					tempObject.setImgy(tempObject.getUpImgy());
				}
				if(key == KeyEvent.VK_S){
					tempObject.setImgy(tempObject.getDownImgy());
				}
				if(key == KeyEvent.VK_D){
					
					tempObject.setImgy(tempObject.getRightImgy());
					
				}
				if(key == KeyEvent.VK_A){
					tempObject.setImgy(tempObject.getLeftImgy());
				}
				if(key == KeyEvent.VK_Q){
					Player player = (Player)tempObject;
					player.setUseWeapon(true);
				}
				if(key == KeyEvent.VK_E){
					Player player = (Player)tempObject;
					player.setUseSkill(true);
				}
			}

			//Movimiento 
			if(tempObject.getID() == ID.Map && !handler.isDialogueDisplaying()){
				if(key == KeyEvent.VK_W){
					tempObject.setVely(vel);
				}
				if(key == KeyEvent.VK_S){
					tempObject.setVely(-vel);
				}
				if(key == KeyEvent.VK_D){
					tempObject.setVelx(-vel);
					
				}
				if(key == KeyEvent.VK_A){
					tempObject.setVelx(vel);
				}
				if(key == KeyEvent.VK_SHIFT){
					vel = 6;
				}
			}

			if(tempObject.getID() == ID.Door){
				if( (key == KeyEvent.VK_W && tempObject.isUp()) ||  (key == KeyEvent.VK_S && tempObject.isDown()) ||  (key == KeyEvent.VK_D && tempObject.isRight()) ||  (key == KeyEvent.VK_A && tempObject.isLeft())){
					handler.removeDoorsAndNpc();
					handler.removeObjectFirst();
					handler.addObjectFirst(tempObject.getMap());	
					tempObject.getMap().setDoorsAndNpc();
				}
			}

			if(tempObject.getID() == ID.Dialogue && handler.isDialogueDisplaying()){
				if(key == KeyEvent.VK_ENTER){
					handler.removeDialogue();
				}
			}

			if(tempObject.getID() == ID.Dialogue && handler.isDialogueDisplaying()){
				Chest tempChest = (Chest) tempObject;
				if(key == KeyEvent.VK_ENTER && tempChest.isNearby()){
					System.out.println("Add weapon");
					(handler.getInventory()).addItem(new Skill(0, 128, 32, 32, "Sprites/IconSet.png", "La Secreta", 1000, 25));
				}
			}

			// TO ADD TO INVENTORY:
			// addItem(new Weapon(0, 192, 32, 32, "Sprites/IconSet.png", "Normal sword", 30)); = inventory.addItem(Weapon/Skill)

			if(tempObject.getID() == ID.Inventory){
				Inventory inventory = (Inventory) tempObject;
				if(key == KeyEvent.VK_I && !inventory.getIsDisplaying() && !handler.isDialogueDisplaying()){
					inventory.setIsDisplaying(true);
				}
				else if(key == KeyEvent.VK_I && inventory.getIsDisplaying()&& !handler.isDialogueDisplaying()){
					inventory.setIsDisplaying(false);
				}
			}
			
		}
	}

	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);

			//animación jugador

			if(tempObject.getID() == ID.Player && !handler.isDialogueDisplaying()){
				if(key == KeyEvent.VK_W){
					tempObject.setImgx(tempObject.getAnim2());
					tempObject.setImgy(tempObject.getUpImgy());
				}
				if(key == KeyEvent.VK_S){
					tempObject.setImgx(tempObject.getAnim2());
					tempObject.setImgy(tempObject.getDownImgy());
				}
				if(key == KeyEvent.VK_D){
					tempObject.setImgx(tempObject.getAnim2());
					tempObject.setImgy(tempObject.getRightImgy());
				}
				if(key == KeyEvent.VK_A){
					tempObject.setImgx(tempObject.getAnim2());
					tempObject.setImgy(tempObject.getLeftImgy());
				}
				if(key == KeyEvent.VK_Q){
					Player player = (Player)tempObject;
					player.setUseWeapon(false);
				}
				if(key == KeyEvent.VK_E){
					Player player = (Player)tempObject;
					player.setUseSkill(false);
				}
			}


			//Movimiento 
			if(tempObject.getID() == ID.Map && !handler.isDialogueDisplaying()){
				if(key == KeyEvent.VK_W){
					tempObject.setVely(0);
				}
				if(key == KeyEvent.VK_S){
					tempObject.setVely(0);
				}
				if(key == KeyEvent.VK_D){
					
					tempObject.setVelx(0);
					
				}
				if(key == KeyEvent.VK_A){
					tempObject.setVelx(0);
				}
				if(key == KeyEvent.VK_SHIFT){
					vel = 3;
				}
			}

			if(tempObject.getID() == ID.Npc){
				Npc tempNpc = (Npc) tempObject;
				if(key == KeyEvent.VK_ENTER && tempNpc.isNearby() && !handler.isDialogueDisplaying() && !tempNpc.getIsDisplayed()){
					handler.addObject(tempNpc.getDialogue());
				}
			}

			if(tempObject.getID() == ID.Chest){
				Chest tempChest = (Chest) tempObject;
				if(key == KeyEvent.VK_ENTER && tempChest.isNearby() && !handler.isDialogueDisplaying() && !tempChest.getIsDisplayed()){
					handler.addObject(tempChest.getDialogue());
					System.out.println("Add weapon");
					(handler.getInventory()).addItem(new Skill(0, 128, 32, 32, "Sprites/IconSet.png", "La Secreta", 1000, 25));
				}
			}

			if(tempObject.getID() == ID.Enemy){
				Enemy tempEnemy = (Enemy) tempObject;
				if((key == KeyEvent.VK_Q || key == KeyEvent.VK_E) && tempEnemy.isNearby() && !handler.isDialogueDisplaying() && !tempEnemy.getIsDisplayed()){
					System.out.println("Attack near enemy.");
				}
			}
			
		}
	}

	
}