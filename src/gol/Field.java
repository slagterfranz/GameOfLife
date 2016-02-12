package gol;


public class Field {
	int length;
	int width;
	Cell[][] field;
	public Field(int width, int length) {
		this.length = length;
		this.width = width;
		initializeField();
	}
	
	public void initializeField() {
		field = new Cell[width][];

		for (int i = 0; i < width; i++) {
			field[i] = new Cell[length];
			for (int j = 0; j < length; j++) {
				Cell cell = new Cell(new Location(width,length));
				field[i][j] = cell;
				//System.out.print(i + j);
			}
		}
	}

	public void updateField(Location location) {
		field[location.getWidth()][location.getLength()].updateCell();
	}
	
	public Cell getCell(int width, int length) {
		return(field[width][length]);
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return length;
	}
	
}
