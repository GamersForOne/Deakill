package se.dennan98.deakill;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Arrays;

import se.dennan98.deakill.graphics.Screen;
import se.dennan98.deakill.graphics.Texture;

public class Game extends Canvas implements Runnable {
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final String TITLE = "Deakill";
	
	private boolean running;
	private Thread gameThread;
	
	private BufferedImage image;
	private int[] pixels;
	private Screen screen;
	
	public Game()
	{
	}
	
	private void init()
	{
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
		screen = new Screen(WIDTH,HEIGHT);
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
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null)
		{
			this.createBufferStrategy(3);
			this.requestFocus();
			return;
		}
		
		// Init Render
		
		Arrays.fill(pixels, 0x000000);
		screen.clear();
		
		// Draw Render
		
		screen.DrawImage(Texture.BLOCK_STONE, 100, 100, 64, 64);
		
		// Output Render
		
		for (int i = 0; i < WIDTH*HEIGHT; i++)
		{
			pixels[i] = screen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, WIDTH, HEIGHT, null);
		g.dispose();
		bs.show();
	}
	
}
