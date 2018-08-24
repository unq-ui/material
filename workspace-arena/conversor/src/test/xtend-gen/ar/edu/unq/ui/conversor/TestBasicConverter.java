package ar.edu.unq.ui.conversor;

import ar.edu.unq.ui.conversor.Conversor;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class TestConversor {
  @Test
  public void testMilesToKm() {
    final Conversor conversor = new Conversor();
    Assert.assertEquals(1.60934, conversor.milesToKm(1), 0);
    Assert.assertEquals(16.0934, conversor.milesToKm(10), 0);
  }
  
  @Test
  public void testKmToMiles() {
    final Conversor conversor = new Conversor();
    Assert.assertEquals(0.621371, conversor.kmToMiles(1), 0.001);
    Assert.assertEquals(6.21371, conversor.kmToMiles(10), 0.001);
  }
}
