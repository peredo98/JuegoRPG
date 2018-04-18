import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter{
	private int imgx = 0;
	private int delay = 0;
	private Handler handler;

	public KeyInput(Handler handler){
		this.handler = handler;
	}

	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		for(int i = 0; i < handler.object.size(); i++){

			GameObject tempObject = handler.object.get(i);

			//Animacion del jugador

			if(tempObject.getID() == ID.Player){
				delay ++;
				if(delay > 5){
					delay = 0;
				}
				if (delay == 5){
					imgx += 48;
					if(imgx > 96){
						imgx = 0;
					}
				tempObject.setImgx(imgx);
				}
				if(key == KeyEvent.VK_W){
					tempObject.setImgy(144);
				}
				if(key == KeyEvent.VK_S){
					tempObject.setImgy(0);
				}
				if(key == KeyEvent.VK_D){
					
					tempObject.setImgy(96);
					
				}
				if(key == KeyEvent.VK_A){
					tempObject.setImgy(48);
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

			
		}
	}

	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);

			//animación jugador

			if(tempObject.getID() == ID.Player){
				if(key == KeyEvent.VK_W){
					tempObject.setImgx(48);
					tempObject.setImgy(0);
				}
				if(key == KeyEvent.VK_S){
					tempObject.setImgx(48);
					tempObject.setImgy(0);
				}
				if(key == KeyEvent.VK_D){
					tempObject.setImgx(48);
					tempObject.setImgy(0);
				}
				if(key == KeyEvent.VK_A){
					tempObject.setImgx(48);
					tempObject.setImgy(0);
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