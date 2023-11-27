package Vista;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Controlador.Juego;
import Modelo.Guerrero;
import Modelo.Mago;

public class main {

	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		Juego juego = new Juego();
		juego.setVista(frame.getPanel());
		
		
		juego.comenzarJuego(new Guerrero(), new Mago());
		
		juego.startLoop();
		
		juego.SecuenciaEjemplo();
		 

		//secuencia
		
	}

}
