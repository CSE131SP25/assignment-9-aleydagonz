package assignment9;

import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	private Snake snake;
	private Food food;
	private int score;

	public Game() {
		//sets up window and objects
		StdDraw.enableDoubleBuffering();
		StdDraw.setCanvasSize(600, 600);
		snake = new Snake();
		food = new Food(); // calls food -> generates new food object
		score = 0;

		// FIXME - construct new Snake and Food objects
	}

	public void play() {
		//while the snake is in bounds
		//if not in bounds then proceed to game over screen
		
		while (snake.isInbounds()) { // TODO: Update this condition to check if snake is
																	// in bounds
			int dir = getKeypress(); //means key is pressed
			
			if (dir != -1) {//makes sure tat valid direction key is pressed
				snake.changeDirection(dir);
			}
			//snake moves
			snake.move();
			if (snake.eatFood(food)) { //if snake eats the food
				food = new Food(); //new food will genrate
				score++; //score will increase 
			}
			updateDrawing(); //will update drawing
		}
		//exit while loop
		//play() method exits and goes to gameover 
		showGameOverScreen();

	}
	// System.out.println("Keypress: " + dir);

	/*
	 * 1. Pass direction to your snake 2. Tell the snake to move 3. If the food has
	 * been eaten, make a new one 4. Update the drawing
	 */

	private int getKeypress() {
		if (StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}

	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		// FIXME
		StdDraw.clear();
		snake.draw(); //draw snake body
		food.draw(); //draw food on screen
		
		// Draw the score in the top-left corner
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.textLeft(0.02, 0.98, "Score: " + score);
		StdDraw.show();
		StdDraw.pause(50);
		/*
		 * 1. Clear screen 2. Draw snake and food 3. Pause (50 ms is good) 4. Show
		 */
	}

	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}


	//game over screen 
	private void showGameOverScreen() {
		StdDraw.clear();//clears screen
		//game over sets in screen
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 40));
		StdDraw.text(0.5, 0.6, "YOU LOST!");
		//returns last detected score
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 20));
		StdDraw.text(0.5, 0.5, "Final Score: " + score);

		StdDraw.show();

	}
}
