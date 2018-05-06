import java.awt.Graphics;
import java.util.LinkedList;

public class Handler{
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();

	private int counter = 0;

	public void tick(){
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
			if (tempObject.getID() == ID.Door || tempObject.getID() == ID.Npc){
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
}