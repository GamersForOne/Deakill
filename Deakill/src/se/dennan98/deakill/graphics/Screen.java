package se.dennan98.deakill.graphics;

import java.util.Arrays;

public class Screen {
	
	public int width, height;
	public int[] pixels;
	
	public Screen(int width, int height)
	{
		this.width = width;
		this.height = height;
		this.pixels = new int[this.width*this.height];
	}
	
	public void clear()
	{
		Arrays.fill(pixels, 0x000000);
	}
	
	public void DrawImage(Screen image, int x, int y, int w, int h)
	{
		DrawImage(image, x, y, ((float)w) / ((float)image.width), ((float)h) / ((float)image.height)); 
	}
	
	public void DrawImage(Screen image, int x, int y, float scale)
	{
		DrawImage(image, x, y, scale, scale);
	}
	
	public void DrawImage(Screen image, int x, int y, float xScale, float yScale)
	{
		float imW = (float)image.width * xScale;
		float imH = (float)image.height * yScale;
		
		int lastY, lastX, nowX, nowY, xPix, yPix;
		yPix = 0;
		for (float yo = y; yo < imH; yo+=yScale)
		{
			lastY = (int)yo;
			nowY = (int)(yo + yScale);
			xPix = 0;
			for (float xo = x; xo < imW; xo+=xScale)
			{
				lastX = (int)xo;
				nowX = (int)(xo + xScale);
				for (int yPos = lastY; yPos < nowY; yPos++)
				{
					for (int xPos = lastX; xPos < nowX; xPos++)
					{
						pixels[xPos + yPos * this.width] = image.pixels[xPix + yPix * image.width];
					}
				}
				xPix++;
			}
			yPix++;
		}
	}
}
