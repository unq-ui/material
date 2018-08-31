package ar.edu.unq.ui.ejemploVentanaDialogo;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.annotations.Observable;

@Accessors
@Observable
@SuppressWarnings("all")
public class BasicConverter {
  private final double FACTOR = 1.60934;
  
  private double miles;
  
  private double kilometers;
  
  public double convert() {
    return this.kilometers = (this.miles * this.FACTOR);
  }
  
  @Pure
  public double getFACTOR() {
    return this.FACTOR;
  }
  
  @Pure
  public double getMiles() {
    return this.miles;
  }
  
  public void setMiles(final double miles) {
    this.miles = miles;
  }
  
  @Pure
  public double getKilometers() {
    return this.kilometers;
  }
  
  public void setKilometers(final double kilometers) {
    this.kilometers = kilometers;
  }
}
