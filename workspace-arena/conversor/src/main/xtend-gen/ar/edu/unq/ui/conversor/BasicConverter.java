package ar.edu.unq.ui.conversor;

import org.uqbar.commons.model.annotations.Observable;

@Observable
@SuppressWarnings("all")
public class Conversor {
  private final double factor = 1.60934;
  
  public double milesToKm(final double miles) {
    return (this.factor * miles);
  }
  
  public double kmToMiles(final double km) {
    return (km / this.factor);
  }
}
