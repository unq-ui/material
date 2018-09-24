package unq.edu.uis.tvSeries.domain;

import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.annotations.Observable;
import unq.edu.uis.tvSeries.domain.Actor;

@Accessors
@Observable
@SuppressWarnings("all")
public class Serie {
  private int id;
  
  private String nombre;
  
  private int temporadas;
  
  private List<Actor> actores;
  
  public Serie() {
    this.actores = CollectionLiterals.<Actor>newArrayList();
  }
  
  public void agregarActor(final Actor actor) {
    this.actores.add(actor);
  }
  
  public void borrarActor(final Actor actor) {
    this.actores.remove(actor);
  }
  
  @Pure
  public int getId() {
    return this.id;
  }
  
  public void setId(final int id) {
    this.id = id;
  }
  
  @Pure
  public String getNombre() {
    return this.nombre;
  }
  
  public void setNombre(final String nombre) {
    this.nombre = nombre;
  }
  
  @Pure
  public int getTemporadas() {
    return this.temporadas;
  }
  
  public void setTemporadas(final int temporadas) {
    this.temporadas = temporadas;
  }
  
  @Pure
  public List<Actor> getActores() {
    return this.actores;
  }
  
  public void setActores(final List<Actor> actores) {
    this.actores = actores;
  }
}
