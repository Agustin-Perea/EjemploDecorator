package Controlador;

import Modelo.Decorator.IAlterable;
import Vista.MyPanel;

public class Juego implements Runnable{
	

	private MyPanel vista;
	
	private GameObject jugador;//decorados
	private GameObject enemigo;

	private Thread loopThread;
	private static int UPS_SET = 120;
	public static int FPS_SET = 60;
	
	public Juego() {
		
	}
	
	public void setVista(MyPanel vista) {
		this.vista = vista;
		vista.setJuego(this);
	}
	
	public void comenzarJuego(IAlterable jugador,IAlterable enemigo) {
		
		//se entiende que no esta alterado
		jugador.desplazarse(256);
		enemigo.desplazarse(1024);
		
		this.jugador = new GameObject(jugador);
		
		this.enemigo = new GameObject(enemigo);

		
	}
	public void startLoop() {
		loopThread = new Thread(this);
		loopThread.start();
	}

	@Override
	public void run() {//loop
		double timePerFrame = 1000000000.0/FPS_SET;
		double timePerUpdate = 1000000000.0/UPS_SET;
		
		long previousTime = System.nanoTime();
		
		long lastCheck = System.currentTimeMillis();
		
		double deltaU = 0;
		double deltaF = 0;
		while(true) {
			long currentTime = System.nanoTime();
			
			deltaU += (currentTime - previousTime)/timePerUpdate; 
			deltaF += (currentTime - previousTime)/timePerFrame; 
			
			previousTime = currentTime;
			if(deltaU >=1) {//updates per second

				//update();
				this.jugador.updateAnimationTick();
				this.enemigo.updateAnimationTick();

				deltaU--;
			}
			if(deltaF >=1) {//render update per second
				vista.RenderUpdate();
				deltaF--;
			}

			if(System.currentTimeMillis() -lastCheck >=1000) {//fps
				lastCheck = System.currentTimeMillis();
			}
			
		}
	}

	public GameObject getJugador() {
		return jugador;
	}

	public GameObject getEnemigo() {
		return enemigo;
	}
	
	
	
	public void SecuenciaEjemplo() {
		
		//sec
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//truno 1
			enemigo.atacar(jugador);

			jugador.desplazarse(jugador.getVelocidad());
			
			System.out.println("Fin de Truno: ");
			System.out.println(jugador.toString());
			System.out.println(enemigo.toString());
			
			//turno 2
			enemigo.usarHabilidad(enemigo, "QUEMAR");
			jugador.alterarse("QUEMAR");
			
			jugador.desplazarse(jugador.getVelocidad());
			
			System.out.println("Fin de Truno: ");
			System.out.println(jugador.toString());
			System.out.println(enemigo.toString());
			//turno 3
			//debilidad
			enemigo.usarHabilidad(enemigo, "DEBILIDAD");
			jugador.alterarse("DEBILIDAD");
			jugador.desplazarse(jugador.getVelocidad());
			
			System.out.println("Fin de Truno: ");
			System.out.println(jugador.toString());
			System.out.println(enemigo.toString());
			//turno 4
			enemigo.atacar(jugador);
			//invulnerabildad
			jugador.usarHabilidad(jugador, "INVULNERABILIDAD");
			jugador.alterarse("INVULNERABILIDAD");
			jugador.desplazarse(jugador.getVelocidad());
			
			System.out.println("Fin de Truno: ");
			System.out.println(jugador.toString());
			System.out.println(enemigo.toString());
			//turno 5
			enemigo.atacar(jugador);
			
			jugador.desplazarse(jugador.getVelocidad());
			jugador.atacar(enemigo);
			enemigo.alterarse("DEBILIDAD");
			
			System.out.println("Fin de Truno: ");
			System.out.println(jugador.toString());
			System.out.println(enemigo.toString());
			//turno 6
			enemigo.desplazarse(enemigo.getVelocidad());
			enemigo.atacar(jugador);
			
			jugador.desplazarse(jugador.getVelocidad());
			jugador.atacar(enemigo);
			System.out.println("Fin de Truno: ");
			System.out.println(jugador.toString());
			System.out.println(enemigo.toString());
			
		
	}
	
	

	
}
