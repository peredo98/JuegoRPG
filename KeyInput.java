import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter{
	private Handler handler;
	private int delay = 0;
	private int changeRate = 5;

	public KeyInput(Handler handler){
		this.handler = handler;
	}

	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();

		for(int i = 0; i < handler.object.size(); i++){

			GameObject tempObject = handler.object.get(i);

			//Animacion del jugador
			int imgx = tempObject.getImgx();


			if(tempObject.getID() == ID.Player){
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
			if(tempObject.getID() == ID.Map){
				if(key == KeyEvent.VK_W){
					tempObject.setVely(3);
				}
				if(key == KeyEvent.VK_S){
					tempObject.setVely(-3);
				}
				if(key == KeyEvent.VK_D){
					tempObject.setVelx(-3);
					
				}
				if(key == KeyEvent.VK_A){
					tempObject.setVelx(3);
				}
			}

			if(tempObject.getID() == ID.Door){
				if(key == KeyEvent.VK_W && tempObject.isUp()){
					handler.removeObjectFirst();
					handler.removeDoors();
					handler.addObjectFirst(tempObject.getMap());
				}
			}
		}
	}

	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);

			//animación jugador

			if(tempObject.getID() == ID.Player){
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
			if(tempObject.getID() == ID.Map){
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
			}
			
		}
	}
}