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
			
		}
	}
}