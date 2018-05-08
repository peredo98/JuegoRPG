import java.awt.Graphics;
import java.util.LinkedList;

public class Handler{
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();

	private int counter = 0;

	public void tick(){
<<<<<<< HEAD
=======
		killEnemy();
		killPlayer();
>>>>>>> 6faf57595f161cf3173298fc77b50f54edde0d47
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
				counter++;
				events();
			}
		}
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
			addObject(new Dialogue("Use W,A,S,D to move (You can't move if there is a Dialogue)"));
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
<<<<<<< HEAD
=======

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
			if (tempObject.getID() == ID.Enemy){
				enemy = (Enemy) tempObject;
				if(enemy.getHp() < 0){
					removeObject(enemy);
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
>>>>>>> 6faf57595f161cf3173298fc77b50f54edde0d47
}