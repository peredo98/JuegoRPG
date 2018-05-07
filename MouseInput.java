import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;

public class MouseInput extends MouseInputAdapter{
	private Handler handler;
	private Item selectedItem;
	public MouseInput(Handler handler){
		this.handler = handler;
	}

	public void mouseReleased(MouseEvent e){
		Inventory inv = handler.getInventory();
		inv.moveItem(selectedItem);
		selectedItem = null;
	}

	public void mouseDragged(MouseEvent e){
		//System.out.println(e.getX() + " " + e.getY());
		Inventory inv = handler.getInventory();
		if(inv.getIsDisplaying()){
			for(int i = 0; i < inv.items.size(); i++){

				Item tempItem = inv.items.get(i);


				if(selectedItem == null && e.getX() >= tempItem.getCellx() && e.getX() <= tempItem.getCellx1() && e.getY() >= tempItem.getCelly() && e.getY() <= tempItem.getCelly1()){
					selectedItem = tempItem;			
				}
				if(selectedItem != null && e.getX() >= selectedItem.getCellx() && e.getX() <= selectedItem.getCellx1() && e.getY() >= selectedItem.getCelly() && e.getY() <= selectedItem.getCelly1()){
					System.out.println(e.getX() + " " + e.getY());
					selectedItem.setCellx(e.getX()-25);
					selectedItem.setCelly(e.getY()-25);
				}
			}
		}
	}
}