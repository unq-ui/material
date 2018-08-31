package ar.edu.unq.ui.ejemploVentanaDialogo_UI

import ar.edu.unq.ui.ejemploVentanaDialogo.BasicConverter
import org.uqbar.arena.Application

class PruebaAplicacion extends Application {
	/**
	 * 
	 */
	override protected createMainWindow() {
		val modelo = new BasicConverter
		
		return new PruebaVentana(this, modelo)
	}
	

	def static void main(String[] args) {
		new PruebaAplicacion().start()
	}
}
