package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;

	/**
	 * Creates a new Food at a random location
	 */
	//new food object will be created : food = new food()
	//in game.play()
	public Food() {
	//generate random x and y postions from 0 to 1
		this.x = Math.random(); 
		this.y = Math.random();
	}
//getter methods
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	/**
	 * Draws the Food
	 */
	public void draw() {

		StdDraw.setPenColor(Color.RED);
		StdDraw.filledCircle(x, y, FOOD_SIZE);
	}
}
