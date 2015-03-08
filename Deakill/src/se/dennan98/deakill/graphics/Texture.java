package se.dennan98.deakill.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Texture {
	
	public static final Screen BLOCK_STONE = loadTexture("res/blocks/block_stone.png");
	public static final Screen BLOCK_DIRT = loadTexture("res/blocks/block_dirt.png");
	
	private static final Screen loadTexture(String path)
	{
		Screen screen = null;
		try {
			BufferedImage image = ImageIO.read(new FileInputStream(new File(path)));
			int width = image.getWidth();
			int height = image.getHeight();
			screen = new Screen(width, height);
			image.getRGB(0, 0, width, height, screen.pixels, 0, width);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screen;
	}
	
	private Texture()
	{ }
	
}
