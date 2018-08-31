package ar.edu.unq.ui.ejemploVentanaDialogo_UI;

import ar.edu.unq.ui.ejemploVentanaDialogo.BasicConverter;
import ar.edu.unq.ui.ejemploVentanaDialogo_UI.PruebaVentana;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

@SuppressWarnings("all")
public class PruebaAplicacion extends Application {
  protected Window<?> createMainWindow() {
    final BasicConverter modelo = new BasicConverter();
    return new PruebaVentana(this, modelo);
  }
  
  public static void main(final String[] args) {
    new PruebaAplicacion().start();
  }
}
