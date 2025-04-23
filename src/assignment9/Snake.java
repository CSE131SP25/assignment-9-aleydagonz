package assignment9;

import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	private boolean justAte;


	public Snake() {
		// FIXME - set up the segments instance variable
		segments = new LinkedList<>();
		segments.add(new BodySegment(0.5, 0.5, SEGMENT_SIZE));
		deltaX = 0;
		deltaY = 0;
		justAte = false;
	}
	//handles directions 
	//up left down right due to keys 
	public void changeDirection(int direction) {
		if (direction == 1) { // up ( 1 is up)
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { // down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { // left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { // right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}

	/**
	 * Moves the snake by updating the position of each of the segments based on the
	 * current direction of travel
	 */
	
	//movement mechnaics: 
	//moves snakes by addtion new head 
	//and removing tail (unless it just ate)
	public void move() {
		BodySegment head = segments.getFirst();
		//gets postions as the new head is always added
		//in direction of movement
		double newX = head.getX() + deltaX;
		//new psoion = head + x/y
		double newY = head.getY() + deltaY;

		// Add a new head at new postion
		//makes new head @ body seggment position x,y, and the size of it
		BodySegment newHead = new BodySegment(newX, newY, SEGMENT_SIZE);
		//adds it to the snake
		segments.addFirst(newHead);
		
		//if it just ate; skip this
		//as it keeps new head & old tail = snake longer
		
		// Remove the tail (unless just ate food)
		//last segment is removed -> 
		//creates illusion of movement while keeping correct length
		if (!justAte) { //if it did not just ate
			segments.removeLast(); 
		} else {
			justAte = false;//resets it to false to resume normal movement
		}
	}

	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		// FIXME
		for (BodySegment segment : segments) {
			segment.draw();
		}
	}

	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * 
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	
	public boolean eatFood(Food f) {
		//when snakes head collides with food/overlaps
		
		BodySegment head = segments.getFirst();
		//gets positions of both x iand y of snake n food on screen
		double dx = head.getX() - f.getX();
		double dy = head.getY() - f.getY();
		//gets the distance between them
		double distance = Math.sqrt(dx * dx + dy * dy);
		
		//when it return true
		//if disatance btwn them is less than size of food
		if (distance < SEGMENT_SIZE) { //segment_size = food
			justAte = true;//just ate it
			return true; //is true -> calls on snake.move()
		}
		return false;
	}

	/**
	 * Returns true if the head of the snake is in bounds
	 * 
	 * @return whether or not the head is in the bounds of the window
	 */
	//checks if head is wihtin the bounds
	//know is out of bounds if boolean = false
	public boolean isInbounds() {
		//gets head of snake positions/coordinates in x and y
		//make sure they are betwnen 0 and 1
		BodySegment head = segments.get(0);
		return head.getX() >= 0 && head.getX() <= 1 && head.getY() >= 0 && head.getY() <= 1;
	}
}
	// return true;
