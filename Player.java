public class Player extends Character{

	public Player(int x, int y, int imgx, int imgy){
		super(x, y, imgx, imgy);
		this.downImgy = imgy;
		this.leftImgy = imgy + 48;
		this.rightImgy = imgy +96;
		this.upImgy = imgy + 144;
		this.anim1 = imgx - 48;
		this.anim2 = imgx;
		this.anim3 = imgx + 48;
		setID(ID.Player);
		setUrl("Sprites/Actor1.png");
	}

}