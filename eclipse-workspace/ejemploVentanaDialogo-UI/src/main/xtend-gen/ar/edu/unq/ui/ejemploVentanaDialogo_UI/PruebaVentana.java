package ar.edu.unq.ui.ejemploVentanaDialogo_UI;

import ar.edu.unq.ui.ejemploVentanaDialogo.BasicConverter;
import ar.edu.unq.ui.ejemploVentanaDialogo_UI.PruebaDialog;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;

@SuppressWarnings("all")
public class PruebaVentana extends SimpleWindow<BasicConverter> {
  public PruebaVentana(final WindowOwner parent, final BasicConverter model) {
    super(parent, model);
  }
  
  protected void addActions(final Panel actionsPanel) {
  }
  
  protected void createFormPanel(final Panel mainPanel) {
  }
  
  public void createMainTemplate(final Panel mainPanel) {
    this.setTitle("Componente SimpleWindow");
    VerticalLayout _verticalLayout = new VerticalLayout();
    mainPanel.setLayout(_verticalLayout);
    final Panel contentPanel = new Panel(mainPanel);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    contentPanel.setLayout(_columnLayout);
    Button _button = new Button(contentPanel);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Abrir Dialog");
        final Action _function = new Action() {
          public void execute() {
            BasicConverter _modelObject = PruebaVentana.this.getModelObject();
            new PruebaDialog(PruebaVentana.this, _modelObject).open();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
  }
}
