import java.awt.Canvas;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import java.awt.Color;
public class Main extends Canvas implements Runnable{
	public static final int width = 800;
	public static final int height = 600;
	private Thread thread;
	private boolean running = false;

	public Handler handler;

	public Main(){
		handler = new Handler();

		this.addKeyListener(new KeyInput(handler));

		new GameWindow(width, height, "Don Chuy's Legendary Taco", this);

		Town town = new Town(-260, -160, handler);
		town.setDoors();
		handler.addObjectFirst(town);
		handler.addObject(new Character(width/2-48, height/2-48, 192, 192, ID.Player, "Sprites/Actor1.png"));
		handler.addObject(new Dialogue("Press enter to remove this Dialogue"));
		
	}
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void run(){
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000/ amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime)/ ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				delta --;
			}
			if (running){
				render();
			frames ++;
			}
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	private void tick(){
		handler.tick();
	}
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null){
			this.createBufferStrategy(2);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();

		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);

		handler.render(g);
		
		g.dispose();
		bs.show();
	}
	public static void main(String[]args){
		new Main();
	}
	
}