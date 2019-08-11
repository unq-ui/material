package geo

import org.junit.Test
import junit.framework.TestCase.assertEquals

class GeoTest {
    @Test fun testDistanceBetweenUnqAnObelisco() {
        val unq = Geo(-34.706272, -58.278519)
        val obelisco = Geo(-34.603702, -58.381575)
        val distance = GeoCalculator.distance(unq, obelisco)
        assertEquals(14.79, distance, 0.0001)
    }

    @Test fun testDistanceBetweenUnqAnEsquel() {
        val unq = Geo(-34.706272, -58.278519)
        val esquel = Geo(-42.914301, -71.319680)
        val distance = GeoCalculator.distance(unq, esquel)
        assertEquals(1449.57, distance, 0.02)
    }
}
