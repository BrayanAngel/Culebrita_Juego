package culebrita.model;

import java.awt.Point;
import java.util.ArrayList;

public class Culebrita {
    public static final int ANCHO = 600;
    public static final int ALTO = 400;
    public static final int TAMANIO_CELDA = 10;
    public static final int IZQUIERDA = 0;
    public static final int ARRIBA = 1;
    public static final int DERECHA = 2;
    public static final int ABAJO = 3;

    private ArrayList<Point> cuerpo;
    private int direccion;

    public Culebrita() {
        cuerpo = new ArrayList<Point>();
        direccion = DERECHA;
        for (int i = 0; i < 3; 
                cuerpo.add(new Point(ANCHO / 2 - i * TAMANIO_CELDA, ALTO / 2)));
            }

        public void mover() {
            Point cabeza = cuerpo.get(0);
            Point nuevaCabeza = new Point(cabeza);
            switch (direccion) {
                case IZQUIERDA:
                    nuevaCabeza.x -= TAMANIO_CELDA;
                    break;
                case ARRIBA:
                    nuevaCabeza.y -= TAMANIO_CELDA;
                    break;
                case DERECHA:
                    nuevaCabeza.x += TAMANIO_CELDA;
                    break;
                case ABAJO:
                    nuevaCabeza.y += TAMANIO_CELDA;
                    break;
            }
            cuerpo.add(0, nuevaCabeza);
            cuerpo.remove(cuerpo.size() - 1);
        }

        public void girar(int direccion) {
            if (this.direccion != direccion) {
                if ((this.direccion == IZQUIERDA && direccion != DERECHA) ||
                        (this.direccion == ARRIBA && direccion != ABAJO) ||
                        (this.direccion == DERECHA && direccion != IZQUIERDA) ||
                        (this.direccion == ABAJO && direccion != ARRIBA)) {
                    this.direccion = direccion;
                }
            }
        }

        public boolean colisionaCon(Point punto) {
            return cuerpo.contains(punto);
        }

        public void comer(Comida comida) {
            cuerpo.add(comida.getPosicion());
        }

        public boolean colisionaConCulebrita() {
            Point cabeza = cuerpo.get(0);
            for (int i = 1; i < cuerpo.size(); i++) {
                Point parteCuerpo = cuerpo.get(i);
                if (cabeza.equals(parteCuerpo)) {
                    return true;
                }
            }
            return false;
        }

        public ArrayList<Point> getCuerpo() {
            return cuerpo;
        }

        public int getDireccion() {
            return direccion;
        }

		/**
		 * @param direccion2
		 */
		public void cambiarDireccion(int direccion2) {
			// TODO Auto-generated method stub
			
		}

		/**
		 * @return
		 */
		public Point getCabeza() {
			// TODO Auto-generated method stub
			return null;
		}

		/**
		 * @return
		 */
		public int getLongitud() {
			// TODO Auto-generated method stub
			return 0;
		}

		/**
		 * @return
		 */
		public int getPuntos() {
		    int puntos = 0;
			return puntos;
		}
}