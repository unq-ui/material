package unq.edu.uis.tvSeries.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.annotations.Observable;
import unq.edu.uis.tvSeries.domain.Serie;

@Accessors
@Observable
@SuppressWarnings("all")
public class Actor {
  private String nombre;
  
  private String personaje;
  
  @JsonBackReference
  private Serie serie;
  
  public void agregarSerie(final Serie serie) {
    this.serie = serie;
  }
  
  @Pure
  public String getNombre() {
    return this.nombre;
  }
  
  public void setNombre(final String nombre) {
    this.nombre = nombre;
  }
  
  @Pure
  public String getPersonaje() {
    return this.personaje;
  }
  
  public void setPersonaje(final String personaje) {
    this.personaje = personaje;
  }
  
  @Pure
  public Serie getSerie() {
    return this.serie;
  }
  
  public void setSerie(final Serie serie) {
    this.serie = serie;
  }
}
