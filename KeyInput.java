import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter{

	private Handler handler;

	public KeyInput(Handler handler){
		this.handler = handler;
	}

	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);

			if(tempObject.getID() == ID.Player){
				if(key == KeyEvent.VK_W){
					
					tempObject.setVely(-5);
					tempObject.setImgy(144);
				}
				if(key == KeyEvent.VK_S){
					tempObject.setVely(5);
					tempObject.setImgy(0);
				}
				if(key == KeyEvent.VK_D){
					
					tempObject.setVelx(5);
					tempObject.setImgy(96);
					
				}
				if(key == KeyEvent.VK_A){
					tempObject.setVelx(-5);
					tempObject.setImgy(48);
				}
			}
			
		}
	}

	public void keyReleased(KeyEvent e){
			int key = e.getKeyCode();
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);

			if(tempObject.getID() == ID.Player){
				if(key == KeyEvent.VK_W){
					tempObject.setVely(0);
					tempObject.setImgy(144);
				}
				if(key == KeyEvent.VK_S){
					tempObject.setVely(0);
					tempObject.setImgy(0);
				}
				if(key == KeyEvent.VK_D){
					tempObject.setVelx(0);
					tempObject.setImgy(96);
				}
				if(key == KeyEvent.VK_A){
					tempObject.setVelx(0);
					tempObject.setImgy(48);
				}
			}
			
		}
	}
}