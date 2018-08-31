package ar.edu.unq.ui.ejemploVentanaDialogo_UI;

import ar.edu.unq.ui.ejemploVentanaDialogo.BasicConverter;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;

@SuppressWarnings("all")
public class PruebaDialog extends Dialog<BasicConverter> {
  public PruebaDialog(final WindowOwner owner, final BasicConverter model) {
    super(owner, new BasicConverter());
  }
  
  protected void createFormPanel(final Panel owner) {
    this.setTitle("Componente Dialog");
    Panel mainPanel = new Panel(owner);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    mainPanel.setLayout(_columnLayout);
    Label _label = new Label(mainPanel);
    _label.setText(
      "Dialogo");
    Button _button = new Button(mainPanel);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Cerrar Dialogo");
        final Action _function = new Action() {
          public void execute() {
            PruebaDialog.this.close();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
  }
}
