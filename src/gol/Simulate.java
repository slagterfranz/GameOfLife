package gol;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Simulate {
	
	Field field;
	static int turn;
	View view;
	ArrayList<Pair> killThese = new ArrayList<Pair>();	
	ArrayList<Pair> resurectThese = new ArrayList<Pair>();	

	
	public Simulate(int width, int length) {
		turn = 0;
		field = new Field(width, length);
		this.view = new View(field, this);
	}
	
	public void oneSimulation() {
		int width = field.getWidth();
		int height = field.getHeight();
		int counter = 0;
		System.out.print("\n");

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Cell curCell = field.getCell(i, j);
				
				for (int x = -1; x < 2; x++) {
					for (int y = -1; y < 2; y++) {
						if(i + x >= 0 && y + j >= 0 && i + x < field.getWidth() && j + y < field.getHeight()) {
					
							if (x != 0 || y != 0) {
								counter += field.getCell(i + x, j + y).getLife() ? 1 : 0;
							}
						}
					}
				}
				
				if ((counter == 2 || counter == 3) && curCell.getLife() == true) {
					resurectThese.add(new Pair(i, j));
				}
				
				else if (counter == 3 && curCell.getLife() == false) {
					resurectThese.add(new Pair(i, j));
				}
				
				else {
					killThese.add(new Pair(i, j));
				}
				
				counter = 0;
			}
		}
		turn++;
		updateEntries();
		view.updateView(field);
		//System.out.print(turn);
	}
	
	public void updateEntries() {
		for (Iterator<Pair> iterator = killThese.iterator(); iterator.hasNext();) {
			Pair pair = (Pair) iterator.next();
			field.getCell(pair.getX(), pair.getY()).setDead();
		}
		
		for (Iterator<Pair> iterator = resurectThese.iterator(); iterator.hasNext();) {
			Pair pair = (Pair) iterator.next();
			field.getCell(pair.getX(), pair.getY()).setAlive();
		}		
		
		killThese.clear();
		resurectThese.clear();
	}
		
	public void setCellAlive(int width, int height) {
		field.getCell(width, height).setAlive();
		view.updateView(field);
	}
		
	public void printAll() {
		for (int i = 0; i < field.getWidth(); i++) {
			for (int j = 0; j < field.getHeight(); j++) {
				System.out.print(field.getCell(i, j).getLife() ? 1 : 0);
			}
		}
	}
	
	public void randomize() {
		Random rand = new Random();
		int randNum;
		for (int i = 0; i < field.getWidth(); i++) {
			for (int j = 0; j < field.getHeight(); j++) {
				randNum = rand.nextInt(8);
				if (randNum == 1) {
					field.getCell(i, j).setAlive();
				}
			}
		}
		view.updateView(field);
	}
	
	public void resetSimulation() {
		for (int i = 0; i < field.getWidth(); i++) {
			for (int j = 0; j < field.getHeight(); j++) {
					field.getCell(i, j).setDead();
			}
		}
		view.updateView(field);
	}
}
