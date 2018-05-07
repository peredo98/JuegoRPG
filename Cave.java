import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Cave extends Map{
	private BufferedImage img = null;
	private Handler handler;
	private Door toWoods;

	public Cave(int x, int y, Handler handler){
		super(x, y);
		this.handler = handler;
		setID(ID.Map);
		setUrl("MapImages/Map008.png");
	}

	public boolean limitMap(){
		if((x<-581 && x>-645 && y<-1616) ||(x>-599 && y>-1640 && y<-1487)||(x>-475 && x<-377 && y>-1507 && y<-1263) ||(x<-512 && x>-596 && y>-1370 && y<-1292) ||(x<-443 && x>-542 && y>-1304 && y<-785)||(x>-599 && x<-377 && y<-1040 && y>-1304) ||(x>-540 && x<-377 && y>-1040 && y<-986)||(x<-443 &&x>-602 && y>-986 && y<-860 ) ||(x<-506 && x>-605 && y>-986) ||(x<-590 && x>-650 && y>-668)||(x<-707 && x>-791 && y>-668) ||(x<-610 &&  x>-737 && y>-602) ||(y>-602 && y<-281 && x<-764 && x>-983) ||(x<-950 && x>-1030 && y>-533 && y<-281) ||(x<-1028 && x>-1154 && y>-467 && y<-340)||(x>-1100 && x<-908 && y>-341 && y<-281)){
			return true;
		}
		else{
			return false;
		}
		
	}

    public void render(Graphics g){
		try {
  			  img = ImageIO.read(new File(url));
		} 
		catch (IOException e) {
		}
		g.drawImage(img, x, y, 2624, 1920, null);
	}
	public void setDoorsAndNpc(){

	}



}