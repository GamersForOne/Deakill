package se.dennan98.deakill;

import java.awt.Canvas;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Game extends Canvas implements Runnable {
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final String TITLE = "Deakill";
	
	private boolean running;
	private Thread gameThread;
	
	private BufferedImage image;
	private int[] pixels;
	
	public Game()
	{
	}
	
	private void init()
	{
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	}
	
	public void start()
	{
		gameThread = new Thread(this);
		running = true;
		gameThread.start();
	}
	
	public void stop()
	{
		running = false;
	}
	
	public void run()
	{
		
		init();
		
		while (running)
		{
			update();
			render();
		}
	}
	
	public void update()
	{
		
	}
	
	public void render()
	{
		
	}
	
}
