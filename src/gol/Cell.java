package gol;

public class Cell {
	private Location location;
	private boolean isAlive;
	
	public Cell(Location location) {
		isAlive = false;
		this.location = location;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void updateCell() {
		isAlive = !isAlive;
	}
	
	public void setAlive() {
		isAlive = true;
	}
	
	public void setDead() {
		isAlive = false;
	}
	
	public boolean getLife() {
		return(isAlive);
	}
}
