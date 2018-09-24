package unq.edu.uis.tvSeries.domain;

import java.util.List;
import java.util.function.Predicate;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.annotations.Observable;
import unq.edu.uis.tvSeries.domain.Serie;

@Accessors
@Observable
@SuppressWarnings("all")
public class TvSeriesSystem {
  private List<Serie> series;
  
  public void agregarSerie(final Serie serie) {
    this.series.add(serie);
  }
  
  public void borrarSerie(final Serie serie) {
    this.series.remove(serie);
  }
  
  public Serie buscarSerie(final String nombre) {
    final Function1<Serie, Boolean> _function = new Function1<Serie, Boolean>() {
      public Boolean apply(final Serie it) {
        return Boolean.valueOf(it.getNombre().toLowerCase().contains(nombre.toLowerCase()));
      }
    };
    return IterableExtensions.<Serie>findFirst(this.series, _function);
  }
  
  public boolean eliminarSeriePorId(final Integer id) {
    final Predicate<Serie> _function = new Predicate<Serie>() {
      public boolean test(final Serie it) {
        int _id = it.getId();
        return (_id == (id).intValue());
      }
    };
    return this.series.removeIf(_function);
  }
  
  @Pure
  public List<Serie> getSeries() {
    return this.series;
  }
  
  public void setSeries(final List<Serie> series) {
    this.series = series;
  }
}
