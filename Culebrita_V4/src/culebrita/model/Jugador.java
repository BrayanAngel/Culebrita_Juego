package culebrita.model;

public class Jugador {
    private String alias;
    private int puntaje;


    public Jugador(String alias, int puntos) {
        this.alias = alias;
        puntaje = 0;
    }
    
    public String getAlias() {
        return alias;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void actualizarPuntaje(int puntos) {
        puntaje += puntos;
    }
}