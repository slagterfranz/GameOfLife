package gol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ViewBottonPanel extends JPanel {
	
	public ViewBottonPanel(Field f, Simulate sim) {
		JButton oneSim = new JButton("One Simulation");
		JButton random = new JButton("Randomize Simulation");
		JButton reset = new JButton("Reset");
		
		oneSim.addActionListener(new ActionListener()	{
			@Override
			public void actionPerformed(ActionEvent e) {
				sim.oneSimulation();
			}
		});
		
		random.addActionListener(new ActionListener()	{
			@Override
			public void actionPerformed(ActionEvent e) {
				sim.resetSimulation();
				sim.randomize();
			}
		});
		
		reset.addActionListener(new ActionListener()	{
			@Override
			public void actionPerformed(ActionEvent e) {
				sim.resetSimulation();
			}
		});
				
		this.add(oneSim);
		this.add(random);
		this.add(reset);
	}
}
