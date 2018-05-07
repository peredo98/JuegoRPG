import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;

public class MouseInput extends MouseInputAdapter{
	private Handler handler;
	private Item selectedItem;
	private Item hoveredItem;
	public MouseInput(Handler handler){
		this.handler = handler;
	}

	public void mouseMoved(MouseEvent e){
		Inventory inv = handler.getInventory();
		if(inv.getIsDisplaying()){
			for(int i = 0; i < inv.items.length; i++){
				try{
					Item tempItem = inv.items[i];
					if(e.getX() >= tempItem.getCellx() && e.getX() <= tempItem.getCellx1() && e.getY() >= tempItem.getCelly() && e.getY() <= tempItem.getCelly1()){
						hoveredItem = tempItem;
						hoveredItem.setHover(true);
						break;	
					}
					else if(!(e.getX() >= tempItem.getCellx() && e.getX() <= tempItem.getCellx1() && e.getY() >= tempItem.getCelly() && e.getY() <= tempItem.getCelly1())){
						hoveredItem.setHover(false);
					}
				}
				catch(NullPointerException ex){
				}
			}
		}
	}
	public void mouseReleased(MouseEvent e){
		Inventory inv = handler.getInventory();
		inv.moveItem(selectedItem);
		selectedItem = null;
	}

	public void mouseDragged(MouseEvent e){
		Inventory inv = handler.getInventory();
		if(inv.getIsDisplaying()){
			for(int i = 0; i < inv.items.length; i++){
				try{
					Item tempItem = inv.items[i];
					if(selectedItem == null && e.getX() >= tempItem.getCellx() && e.getX() <= tempItem.getCellx1() && e.getY() >= tempItem.getCelly() && e.getY() <= tempItem.getCelly1()){
						selectedItem = tempItem;			
					}
				}
				catch(NullPointerException ex){
				}
			}
			if(selectedItem != null){
				selectedItem.setCellx(e.getX()-25);
				selectedItem.setCelly(e.getY()-25);
			}
		}
	}
}