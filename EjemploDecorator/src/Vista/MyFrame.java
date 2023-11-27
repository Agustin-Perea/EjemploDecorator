package Vista;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	
	private MyPanel panel;
	
	MyFrame(){
		panel = new MyPanel();
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("Ejemplo Decorator");
		this.setVisible(true);
		
	}
	
	public MyPanel getPanel() {
		return this.panel;
	}

}
