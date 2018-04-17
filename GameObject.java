import java.awt.Graphics;
public abstract class GameObject{
	protected int x, y, velx, vely, imgx, imgy;
	protected ID id;
	
	public GameObject(int x, int y, ID id){
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public void setX(int x){
		this.x = x;
	}
	public int getX(){
		return x;
	}
	public void setY(int y){
		this.y = y;
	}
	public int getY(){
		return y;
	}
	public void setID(ID id){
		this.id = id;
	}
	public ID getID(){
		return id;
	}

	public void setVelx(int velx){
		this.velx = velx;
	}
	public int getVelx(){
		return velx;
	}
	public void setVely(int vely){
		this.vely = vely;
	}
	public int getVely(){
		return vely;
	}

	public void setImgx(int imgx){
		this.imgx = imgx;
	}
	public int getImgx(){
		return imgx;
	}
	public void setImgy(int imgy){
		this.imgy = imgy;
	}
	public int getImgy(){
		return imgy;
	}
}