public class Npc extends Character{

	private String text = "";
	private boolean isDisplayed = false;

	public Npc(int x, int y, int imgx, int imgy, String url){
		super(x, y, imgx, imgy, url);
		setID(ID.Npc);
	}

	public void setText(String text){
		this.text = text;
	}
	public String getText(){
		return text;
	}

	public boolean getIsDisplayed(){
		return isDisplayed;
	}

	public Dialogue getDialogue(){
		Dialogue dialogue = new Dialogue(text);
		isDisplayed = true;
		return dialogue;
	}
}