/**
 * 
 */
package culebrita.controller;

import java.util.ArrayList;
import java.util.List;

import culebrita.model.Jugador;

public class JugadorController {
    private Jugador jugador;
    private List<Jugador> jugadores = new ArrayList<>();

    public JugadorController(Jugador jugador) {
        this.jugador = jugador;
    }

    public void actualizarPuntaje(Jugador jugador2, int puntos) {
        jugador.actualizarPuntaje(puntos);
    }

    public Jugador getJugador() {
        return jugador;
    }

	/**
	 * @param jugador2
	 * @param puntos
	 */
	public void actualizarEstadisticas(Jugador jugador2, int puntos) {
		// TODO Auto-generated method stub
		
	}
	
    public JugadorController() {
        // Constructor sin argumentos
    }
    public Jugador buscarJugador(String alias) {
		return jugador;
        // Lógica para buscar un jugador por su alias
    }
    
    public void registrarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }
}
