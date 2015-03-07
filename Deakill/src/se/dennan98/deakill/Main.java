package se.dennan98.deakill;

import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame(Game.TITLE);
		Game game = new Game();
		
		frame.setSize(Game.WIDTH, Game.HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.add(game);
		
		game.start();
	}
	
}
