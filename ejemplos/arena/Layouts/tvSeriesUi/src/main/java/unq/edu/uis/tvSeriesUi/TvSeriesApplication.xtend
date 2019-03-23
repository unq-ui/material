package unq.edu.uis.tvSeriesUi

import org.uqbar.arena.Application

class TvSeriesApplication extends Application{
	
	override protected createMainWindow() {
		val model = new TvSeriesAppModel
		new TvSeriesWindow(this, model) 
	}
	def static void main(String[] args) {
		new TvSeriesApplication().start()
}
}