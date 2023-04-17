package culebrita.view;

import javax.swing.*;

import culebrita.controller.CulebritaController;
import culebrita.controller.JugadorController;
import culebrita.model.Comida;
import culebrita.model.Culebrita;
import culebrita.model.Jugador;

import java.awt.*;

public class Ventana extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelCulebrita panelCulebrita;

    public Ventana() {
        super("Juego de la Culebrita");
        setLayout(new BorderLayout());
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Juego");
        JMenuItem nuevoJuego = new JMenuItem("Nuevo Juego");
        JMenuItem registrarUsuario = new JMenuItem("Registrar Usuario");
        JMenuItem verEstadisticas = new JMenuItem("Ver Estadísticas");
        
        nuevoJuego.addActionListener(new MenuInicialListener(this));
        registrarUsuario.addActionListener(new MenuInicialListener(this));
        verEstadisticas.addActionListener(new MenuInicialListener(this));

        menu.add(nuevoJuego);
        menu.add(registrarUsuario);
        menu.add(verEstadisticas);

        menuBar.add(menu);
        setJMenuBar(menuBar);

        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new BorderLayout());

        JLabel aliasLabel = new JLabel("Alias: ");
        JTextField aliasTextField = new JTextField(10);

        JLabel puntajeLabel = new JLabel("Puntaje: ");
        JLabel puntajeTextField = new JLabel("0");

        JButton iniciarButton = new JButton("Iniciar");
        iniciarButton.addActionListener(e -> {
            String alias = aliasTextField.getText();
            if (!alias.isEmpty()) {
                JugadorController jugadorController = new JugadorController();
                Jugador jugador = jugadorController.buscarJugador(alias);
                if (jugador == null) {
                    jugador = new Jugador(alias, 0);
                    jugadorController.registrarJugador(jugador);
                }

                CulebritaController culebritaController = new CulebritaController(jugador);
                Culebrita culebrita = culebritaController.getCulebrita();
                Comida comida = culebritaController.getComida1();
                panelCulebrita = new PanelCulebrita(culebrita, comida, jugador, culebritaController, jugadorController);
                panelSuperior.setVisible(false);
                getContentPane().add(panelCulebrita, BorderLayout.CENTER);
                panelCulebrita.iniciarJuego();
            }
        });

        JButton salirButton = new JButton("Salir");
        salirButton.addActionListener(e -> System.exit(0));

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 2));
        panelBotones.add(iniciarButton);
        panelBotones.add(salirButton);

        JPanel panelAlias = new JPanel();
        panelAlias.setLayout(new FlowLayout());
        panelAlias.add(aliasLabel);
        panelAlias.add(aliasTextField);

        JPanel panelPuntaje = new JPanel();
        panelPuntaje.setLayout(new FlowLayout());
        panelPuntaje.add(puntajeLabel);
        panelPuntaje.add(puntajeTextField);

        panelSuperior.add(panelAlias, BorderLayout.WEST);
        panelSuperior.add(panelPuntaje, BorderLayout.CENTER);
        panelSuperior.add(panelBotones, BorderLayout.EAST);

        getContentPane().add(panelSuperior, BorderLayout.NORTH);
        setVisible(true);
    }

    public void volverMenuInicial() {
        getContentPane().remove(panelCulebrita);
        panelCulebrita = null;
        getContentPane().getComponent(0).setVisible(true);
    }

	/**
	 * 
	 */
    /*
    public void iniciarJuego() {
        // Crear el controlador de la culebrita y la comida
        CulebritaController culebritaController = new CulebritaController();
        Comida comida = new Comida();

        // Crear el panel de la culebrita y agregarlo a la ventana
        PanelCulebrita panelCulebrita = new PanelCulebrita(culebritaController, comida);
        add(panelCulebrita);

        // Crear el controlador del jugador y el panel del menú inicial
        JugadorController jugadorController = new JugadorController(null);
        MenuInicialListener menuInicialListener = new MenuInicialListener(this);
        Component panelMenuInicial = new PanelMenuInicial();
        add(panelMenuInicial);

        // Actualizar la ventana y enfocar el panel de menú inicial
        pack();
        setLocationRelativeTo(null);
        panelMenuInicial.requestFocusInWindow();
    }
*/
	/**
	 * 
	 */
	public void registrarUsuario() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 */
	public void verEstadisticas() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 */
	public void iniciarJuego() {
		// TODO Auto-generated method stub
		
	}


}

