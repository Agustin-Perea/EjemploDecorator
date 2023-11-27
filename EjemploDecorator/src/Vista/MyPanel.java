package Vista;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import Controlador.Juego;

public class MyPanel extends JPanel{
	private Juego juego;	

	final int PANEL_WIDTH = 1280;
	final int PANEL_HEIGHT = 720;
	 

	Image backgroundImage;



	
	MyPanel(){
		this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
		this.setBackground(Color.lightGray);


		}
	
	public void setJuego(Juego juego) {
		this.juego = juego;
	}

	public void RenderUpdate() {
		repaint();
	}
	
	public void paint(Graphics g) {
		super.paint(g);//paint background
		
		Graphics2D g2d = (Graphics2D) g;
		if(juego.getJugador() != null)
			g2d.drawImage(juego.getJugador().getActualImage(),(int) juego.getJugador().getxDelta(), PANEL_HEIGHT/2, PANEL_WIDTH/10, PANEL_WIDTH/10,null );

		if(juego.getEnemigo() != null)
			g2d.drawImage(juego.getEnemigo().getActualImage(),(int) juego.getEnemigo().getxDelta(), PANEL_HEIGHT/2, -PANEL_WIDTH/10, PANEL_WIDTH/10,null );
		
	}
	

	

}
