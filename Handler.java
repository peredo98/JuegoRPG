import java.awt.Graphics;
import java.util.LinkedList;

public class Handler{
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();

	private int counter = 0;

	public void tick(){
		killEnemy();
		killPlayer();
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			tempObject.tick();
		}
	}

	public void render(Graphics g){
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			tempObject.render(g);
		}
	}

	public void addObject(GameObject object){
		this.object.add(object);
	}
	public void addObject(int index, GameObject object){
		this.object.add(index, object);
	}

	public void addObjectFirst(GameObject object){
		this.object.addFirst(object);
	}

	public void removeObject(GameObject object){
		this.object.remove(object);
	}

	public void removeObjectFirst(){
		this.object.removeFirst();
	}

	public void removeDoorsAndNpc(){
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			if (tempObject.getID() == ID.Door || tempObject.getID() == ID.Npc || tempObject.getID() == ID.Enemy){
				removeObject(tempObject);
				i = 0;
			}
		}
	}
	public void removeDialogue(){
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			if (tempObject.getID() == ID.Dialogue){
				removeObject(tempObject);
			}
		}
		counter++;
		events();
	}
	public boolean isDialogueDisplaying(){
		boolean isDislpaying = false;
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			if (tempObject.getID() == ID.Dialogue){
				isDislpaying =  true;
			}
		}
		return isDislpaying;
	}

	public void events(){
		if(counter == 1){
			addObject(new Dialogue("You can't move if there is a Dialogue"));
		}
		if(counter == 2){
			addObject(new Dialogue("You can't move if there is a Dialogue"));
		}
		if(counter == 3){
			addObject(new Dialogue("Press Enter to talk with people and open chests"));
		}
		if(counter == 4){
			addObject(new Dialogue("Use W,A,S,D to move"));
		}
		if(counter == 5){
			addObject(new Dialogue("Press \"I\" to open Inventory and set Items by dragging"));
		}
		if(counter == 6){
			addObject(new Dialogue("Press Q to use Weapon"));
		}
		if(counter == 7){
			addObject(new Dialogue("Press E to use Skill"));
		}
		
		if(counter == 8){
			addObject(new Dialogue("If you loose the Game closes, BE AWARE!"));
		}
	}

	public Inventory getInventory(){
		Inventory inv = null;
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			if (tempObject.getID() == ID.Inventory){
				inv = (Inventory) tempObject;
			}
		}
		return inv;
	}

	public Player getPlayer(){
		Player player = null;
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			if (tempObject.getID() == ID.Player){
				player = (Player) tempObject;
			}
		}
		return player;
	}
	public void killEnemy(){
		Enemy enemy = null;
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			if (tempObject.getID() == ID.Enemy || tempObject.getID() == ID.Boss){
				enemy = (Enemy) tempObject;
				if(enemy.getHp() < 0 && tempObject.getID() == ID.Enemy){
					removeObject(enemy);
				}
				if(enemy.getHp() < 0 && tempObject.getID() == ID.Boss){
					removeObject(enemy);
					System.out.println("Cogratulations you have founded the legendary taco, You have won the game");
					System.exit(1);
				}
			}
		}
	}
	public void killPlayer(){
		Player player = getPlayer();
		if(player.getHp() < 0){
			System.out.println("GG, U DED NIGGA! U HAVE DISSAPPOINTED DON CHUY!!!! MADAFAKA!!!!!");
			System.exit(1);
		}
	}
}