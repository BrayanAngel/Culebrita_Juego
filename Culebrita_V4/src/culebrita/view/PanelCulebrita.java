package culebrita.view;

import culebrita.controller.CulebritaController;
import culebrita.controller.JugadorController;
import culebrita.model.Culebrita;
import culebrita.model.Comida;
import culebrita.model.Jugador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class PanelCulebrita extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int ANCHO_PANEL = 600;
    private static final int ALTO_PANEL = 600;
    private static final int TAMANIO_CELDA = 20;

    private Culebrita culebrita;
    private Comida comida;
    private Jugador jugador;
    private CulebritaController culebritaController;
    private JugadorController jugadorController;

    public PanelCulebrita(Culebrita culebrita, Comida comida, Jugador jugador,
                          CulebritaController culebritaController, JugadorController jugadorController) {
        this.culebrita = culebrita;
        this.comida = comida;
        this.jugador = jugador;
        this.culebritaController = culebritaController;
        this.jugadorController = jugadorController;

        setPreferredSize(new Dimension(ANCHO_PANEL, ALTO_PANEL));
        setBackground(Color.WHITE);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_LEFT:
                        culebrita.girar(Culebrita.IZQUIERDA);
                        break;
                    case KeyEvent.VK_UP:
                        culebrita.girar(Culebrita.ARRIBA);
                        break;
                    case KeyEvent.VK_RIGHT:
                        culebrita.girar(Culebrita.DERECHA);
                        break;
                    case KeyEvent.VK_DOWN:
                        culebrita.girar(Culebrita.ABAJO);
                        break;
                }
            }
        });
        setFocusable(true);
    }

    /**
	 * @param culebritaController2
	 * @param comida2
	 */
	public PanelCulebrita(CulebritaController culebritaController2, Comida comida2) {
		// TODO Auto-generated constructor stub
	}

	public void iniciarJuego() {
        Timer timer = new Timer(100, e -> {
            culebritaController.moverCulebrita();
            if (culebrita.colisionaConCulebrita()) {
                jugadorController.actualizarEstadisticas(jugador, culebrita.getPuntos());
                JOptionPane.showMessageDialog(this, "Has perdido!");
                culebritaController.finalizarJuego();
                return;
            }
            if (culebrita.colisionaCon(comida.getPosicion())) {
                culebrita.comer(comida);
                jugadorController.actualizarPuntaje(jugador, comida.getPuntos());
                comida.mover();
            }
            repaint();
        });
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Dibujar comida
        g2d.setColor(Color.RED);
        g2d.fillRect(comida.getPosicion().x, comida.getPosicion().y, TAMANIO_CELDA, TAMANIO_CELDA);

        // Dibujar culebrita
        ArrayList<Point> cuerpo = culebrita.getCuerpo();
        for (Point punto : cuerpo) {
            g2d.setColor(Color.GREEN);
            g2d.fillRect(punto.x, punto.y, TAMANIO_CELDA, TAMANIO_CELDA);
        }

        // Dibujar puntaje
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        g2d.drawString("Puntaje: "     + jugador.getPuntaje(), 10, 20);
    }
}


