import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MouseInput extends MouseMotionAdapter{
	private Handler handler;
	public MouseInput(Handler handler){
		this.handler = handler;
	}

	public void mouseMoved(MouseEvent e){
		
	}

	public void mouseDragged(MouseEvent e){
		//System.out.println(e.getX() + " " + e.getY());
		Inventory inv = handler.getInventory();
		if(inv.getIsDisplaying()){
			for(int i = 0; i < inv.items.size(); i++){

				Item tempItem = inv.items.get(i);

				if(e.getX() >= tempItem.getCellx() && e.getX() <= tempItem.getCellx1() && e.getY() >= tempItem.getCelly() && e.getY() <= tempItem.getCelly1()){
					System.out.println(e.getX() + " " + e.getY());
					tempItem.setCellx(e.getX()-25);
					tempItem.setCelly(e.getY()-25);

				}
			}
		}
	}
}