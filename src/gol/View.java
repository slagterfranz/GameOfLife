package gol;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.xml.internal.ws.api.Component;


public class View {
	JFrame frame = new JFrame("Game of life");
	BorderLayout frameBorderLayout = new BorderLayout();
	JPanel jButtonsView;

	
	public View(Field f, Simulate sim) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		createFieldView(f, sim);
		frame.setVisible(true);
	}
	

	public void createFieldView(Field f, Simulate sim) {
		jButtonsView = new JPanel();
		int width = f.getWidth();
		int height = f.getHeight();
		GridLayout jButtonsGrid = new GridLayout(width, height);
		jButtonsView.setLayout(jButtonsGrid);
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				JButton cellBut = new CellButton(f, i, j);
				jButtonsView.add(cellBut);
			}
		}
		frame.add(jButtonsView, BorderLayout.CENTER);
		frame.add(new ViewBottonPanel(f, sim), BorderLayout.SOUTH);

	}
	
	public void updateView(Field f) {
		java.awt.Component[] components = jButtonsView.getComponents();

		java.awt.Component com = null;
		for (int i = 0; i < components.length; i++) {
			com = components[i];
			if (com instanceof CellButton) {
				((CellButton) com).setColor(f);
			}
		}
	}
		
		
		

	
	public Color setColor(Field f, int width, int height) {
		if (f.getCell(f.getWidth(), f.getHeight()).getLife()) {
			return Color.white;
		}
			return Color.black;
	}
		
	
		public class CellButton extends JButton implements ActionListener{
			int width;
			int height;
			int color;
	
			public CellButton(Field f, int width, int height) {
				this.width = width;
				this.height = height;
				setColor(f);
			}
			
			public void setColor(Field f) {
				if (f.getCell(this.width, this.height).getLife()) {
					this.color = 0;
				}
				
				else {
					this.color = 1;
				}
				
			}
			
			public void updateCell() {
				this.setBackground(Color.cyan);
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				if(1 && this.setColor) {
			}	
		}
}