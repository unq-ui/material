package unq.edu.uis.tvSeries.dummyData;

import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import unq.edu.uis.tvSeries.domain.Actor;
import unq.edu.uis.tvSeries.domain.Serie;

@SuppressWarnings("all")
public class DummyData {
  public ArrayList<Serie> seriesDummy() {
    ArrayList<Serie> _newArrayList = CollectionLiterals.<Serie>newArrayList();
    final Procedure1<ArrayList<Serie>> _function = new Procedure1<ArrayList<Serie>>() {
      public void apply(final ArrayList<Serie> it) {
        it.add(DummyData.this.breakingBad());
        it.add(DummyData.this.gameOfThrones());
        it.add(DummyData.this.vikings());
      }
    };
    return ObjectExtensions.<ArrayList<Serie>>operator_doubleArrow(_newArrayList, _function);
  }
  
  public Serie breakingBad() {
    Serie _serie = new Serie();
    final Procedure1<Serie> _function = new Procedure1<Serie>() {
      public void apply(final Serie it) {
        it.setId(1);
        it.setNombre("Breaking Bad");
        it.setTemporadas(5);
      }
    };
    final Serie serie = ObjectExtensions.<Serie>operator_doubleArrow(_serie, _function);
    serie.setActores(this.actoresBreakingBad(serie));
    return serie;
  }
  
  public Serie gameOfThrones() {
    Serie _serie = new Serie();
    final Procedure1<Serie> _function = new Procedure1<Serie>() {
      public void apply(final Serie it) {
        it.setId(2);
        it.setNombre("Game of Thrones");
        it.setTemporadas(7);
        it.setActores(DummyData.this.actoresGameOfThrones());
      }
    };
    return ObjectExtensions.<Serie>operator_doubleArrow(_serie, _function);
  }
  
  public Serie vikings() {
    Serie _serie = new Serie();
    final Procedure1<Serie> _function = new Procedure1<Serie>() {
      public void apply(final Serie it) {
        it.setId(3);
        it.setNombre("Vikings");
        it.setTemporadas(5);
        it.setActores(DummyData.this.actoresVikings());
      }
    };
    return ObjectExtensions.<Serie>operator_doubleArrow(_serie, _function);
  }
  
  public ArrayList<Actor> actoresBreakingBad(final Serie serie) {
    final Actor actor1 = this.crearActor("Bryan Cranston", "Walter White");
    actor1.agregarSerie(serie);
    final Actor actor2 = this.crearActor("Aaron Paul", "Jesse Pinkman");
    actor2.agregarSerie(serie);
    final Actor actor3 = this.crearActor("Bob Odenkirk", "Saul Goodman");
    actor3.agregarSerie(serie);
    ArrayList<Actor> _newArrayList = CollectionLiterals.<Actor>newArrayList();
    final Procedure1<ArrayList<Actor>> _function = new Procedure1<ArrayList<Actor>>() {
      public void apply(final ArrayList<Actor> it) {
        it.add(actor1);
        it.add(actor2);
        it.add(actor3);
      }
    };
    return ObjectExtensions.<ArrayList<Actor>>operator_doubleArrow(_newArrayList, _function);
  }
  
  public ArrayList<Actor> actoresGameOfThrones() {
    ArrayList<Actor> _newArrayList = CollectionLiterals.<Actor>newArrayList();
    final Procedure1<ArrayList<Actor>> _function = new Procedure1<ArrayList<Actor>>() {
      public void apply(final ArrayList<Actor> it) {
        it.add(DummyData.this.crearActor("Kit Harington", "Jon Snow"));
        it.add(DummyData.this.crearActor("Emilia Clarke", "Daenerys Targaryen"));
        it.add(DummyData.this.crearActor("Lena Headey", "Cersei Lannister"));
      }
    };
    return ObjectExtensions.<ArrayList<Actor>>operator_doubleArrow(_newArrayList, _function);
  }
  
  public ArrayList<Actor> actoresVikings() {
    ArrayList<Actor> _newArrayList = CollectionLiterals.<Actor>newArrayList();
    final Procedure1<ArrayList<Actor>> _function = new Procedure1<ArrayList<Actor>>() {
      public void apply(final ArrayList<Actor> it) {
        it.add(DummyData.this.crearActor("Travis Fimmel", "Ragnar Lothbrok"));
        it.add(DummyData.this.crearActor("Katheryn Winnick", "Lagertha"));
        it.add(DummyData.this.crearActor("Alexander Ludwig", "Björn Lothbrok"));
      }
    };
    return ObjectExtensions.<ArrayList<Actor>>operator_doubleArrow(_newArrayList, _function);
  }
  
  public Actor crearActor(final String nombre, final String personaje) {
    Actor _actor = new Actor();
    final Procedure1<Actor> _function = new Procedure1<Actor>() {
      public void apply(final Actor it) {
        it.setNombre(nombre);
        it.setPersonaje(personaje);
      }
    };
    return ObjectExtensions.<Actor>operator_doubleArrow(_actor, _function);
  }
}
