import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Town extends Map{

	public Town(int x, int y, String url){
		super(x, y, url);
		setID(ID.Map);
	}


	public boolean limitMap(){
		if((x < -881 || x > 286) || (y < -589 || y > 152) || (x < -818 && y < -274) || (x < -245 && y > -91) || (x > 97 && y < -79) || (x > 46 && y < -415) || (x > -158 && x < 76 && y > -91) || (x > -797 && x < -242 && y > -544 && y < -211)){
			return true;
		}
		else{
			return false;
		}
	}

}