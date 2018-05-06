import java.awt.Graphics;
public abstract class GameObject{
	protected int x, y, velx, vely, imgx, imgy;
	protected ID id;
	protected String url;
	protected int upImgy, downImgy, leftImgy, rightImgy, anim1, anim2, anim3;
	protected Map map;
	
	public GameObject(int x, int y, int imgx, int imgy, String url){
		this.x = x;
		this.y = y;
		this.imgx = imgx;
		this.imgy = imgy;
		this.url = url;
		this.downImgy = imgy;
		this.leftImgy = imgy + 48;
		this.rightImgy = imgy +96;
		this.upImgy = imgy + 144;
		this.anim1 = imgx - 48;
		this.anim2 = imgx;
		this.anim3 = imgx + 48;
	}

	public GameObject(int x, int y, int imgx, int imgy){
		this.x = x;
		this.y = y;
		this.imgx = imgx;
		this.imgy = imgy;
		this.downImgy = imgy;
		this.leftImgy = imgy + 48;
		this.rightImgy = imgy +96;
		this.upImgy = imgy + 144;
		this.anim1 = imgx - 48;
		this.anim2 = imgx;
		this.anim3 = imgx + 48;
	}

	public GameObject(int x, int y, String url){
		this.x = x;
		this.y = y;
		this.url = url;	
	}
	public GameObject(int x, int y){
		this.x = x;
		this.y = y;

	}
	public GameObject(){

	}

	public GameObject(int x, int y, Map map){
		this.x = x;
		this.y = y;
		this.map = map;
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
	public void setUrl(String url){
		this.url = url;
	}
	public String getUrl(){
		return url;
	}
	public int getUpImgy(){
		return upImgy;
	}
	public int getDownImgy(){
		return downImgy;
	}
	public int getLeftImgy(){
		return leftImgy;
	}
	public int getRightImgy(){
		return rightImgy;
	}
	public int getAnim1(){
		return anim1;
	}
	public int getAnim2(){
		return anim2;
	}
	public int getAnim3(){
		return anim3;
	}
	public void setMap(Map map){
		this.map = map;
	}
	public Map getMap(){
		return map;
	}

	public boolean isUp(){
		if(x >= 325 && x <= 358 && y == 229){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean isDown(){
		if(x >= 325 && x <= 358 && y <= 303 && y >= 300){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean isRight(){
		if(x >= 390 && x <= 399 && y <= 303 && y >= 229){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean isLeft(){
		if(x >= 288 && x <= 291 && y <= 303 && y >= 229){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean isNearby(){
		if(x >= 316 && x <= 385 && y <= 202 && y >= 298){
			return true;
		}
		else{
			return false;
		}
	}
}