package unq.edu.uis.tvSeries_xtrest.runnable;

import java.util.ArrayList;
import org.uqbar.xtrest.api.XTRest;
import unq.edu.uis.tvSeries.domain.Serie;
import unq.edu.uis.tvSeries.domain.TvSeriesSystem;
import unq.edu.uis.tvSeries.dummyData.DummyData;
import unq.edu.uis.tvSeries_xtrest.server.RestfulServer;

@SuppressWarnings("all")
public class App {
  public static void main(final String[] args) {
    final ArrayList<Serie> series = new DummyData().seriesDummy();
    final TvSeriesSystem tvSeriesSystem = new TvSeriesSystem();
    tvSeriesSystem.setSeries(series);
    RestfulServer _restfulServer = new RestfulServer(tvSeriesSystem);
    XTRest.startInstance(9000, _restfulServer);
  }
}
