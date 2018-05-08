import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class KeyInput extends KeyAdapter{
	private Handler handler;
	private int delay = 0;
	private int changeRate = 5;
	private int vel = 3;
	private Player player;
	private int chestCounter = 0;

	public KeyInput(Handler handler){
		this.handler = handler;
	}

	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		player = handler.getPlayer();
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
					Skill playerSkill = null;
					try{
						playerSkill = (Skill) player.getSkill();
						if(player.getMana() >= playerSkill.getMana()){
							player.setUseSkill(true);
						}
					}catch(NullPointerException ex){
						System.out.println("You must equip an Skill in inventory, use 'I' to open inventory");
					}
					
				}
			}

			if(tempObject.getID() == ID.Enemy){
				Enemy tempEnemy = (Enemy) tempObject;
				if(tempEnemy.isNearby()){
					if(delay  < 5){
					player.setHp(player.getHp() - tempEnemy.getDamage());
					System.out.println("You have been hitted");
					}
					if(player.getUseWeapon()){
						tempEnemy.setHp(tempEnemy.getHp() - player.getWeapon().getDamage());
					}
					if(player.getUseSkill()){
						tempEnemy.setHp(tempEnemy.getHp() - player.getSkill().getDamage());
					}
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

			if(tempObject.getID() == ID.Npc){
				Npc tempNpc = (Npc) tempObject;
				if(key == KeyEvent.VK_ENTER && tempNpc.isNearby() && !handler.isDialogueDisplaying() && !tempNpc.getIsDisplayed()){
					handler.addObject(tempNpc.getDialogue());
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

					switch(chestCounter){
						case 0:
						(handler.getInventory()).addItem(new Weapon(352, 224, 32, 32, "Sprites/IconSet.png", "Iron Sword", 40));
						chestCounter += 1;
						break;
						case 1:
						(handler.getInventory()).addItem(new Skill(32, 128, 32, 32, "Sprites/IconSet.png", "Ice Storm", 50, 15));
						chestCounter += 1;
						break;
						case 2:
						(handler.getInventory()).addItem(new Skill(320, 0, 32, 32, "Sprites/IconSet.png", "ONE PUNCH", 10000, 1));
						chestCounter += 1;
						break;
						default:
						System.out.println("This chest is empty!");
					} //End of switch
					
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