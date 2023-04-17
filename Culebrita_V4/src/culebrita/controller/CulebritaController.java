package culebrita.controller;

import java.awt.Point;

import culebrita.model.Culebrita;
import culebrita.model.Jugador;
import culebrita.model.Comida;

public class CulebritaController {

    private Culebrita culebrita;
    private Comida comida;
	private Jugador jugador;

    public CulebritaController() {
        culebrita = new Culebrita();
        comida = new Comida();
    }

    public void moverCulebrita() {
        culebrita.mover();
        if (culebrita.colisionaCon(comida.getPosicion())) {
            culebrita.comer(comida);
            comida.nuevaComida();
        }
    }

    public void cambiarDireccionCulebrita(int direccion) {
        culebrita.cambiarDireccion(direccion);
    }

    public Point getCabezaCulebrita() {
        return culebrita.getCabeza();
    }

    public Point getComida() {
        return comida.getPosicion();
    }

    public int getPuntaje() {
        return culebrita.getLongitud();
    }

	/**
	 * 
	 */
	public void finalizarJuego() {
		// TODO Auto-generated method stub
		
	}
	
	 public CulebritaController(Jugador jugador) {
	        this.setJugador(jugador);
	        this.culebrita = new Culebrita();
	        this.comida = new Comida();
	    }

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	
	public Culebrita getCulebrita() {
	    return culebrita;
	}
	public Comida getComida1() {
	    return comida;
	}

}