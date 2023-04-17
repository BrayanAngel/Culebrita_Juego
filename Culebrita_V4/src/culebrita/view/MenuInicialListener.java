package culebrita.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuInicialListener implements ActionListener {
    private Ventana ventana;

    public MenuInicialListener(Ventana ventana) {
        this.ventana = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        switch (comando) {
            case "nuevoJuego":
                ventana.iniciarJuego();
                break;
            case "registrarUsuario":
                ventana.registrarUsuario();
                break;
            case "verEstadisticas":
                ventana.verEstadisticas();
                break;
        }
    }
}
