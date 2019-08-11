package geo

fun main() {
    val unq = Geo(-34.706272, -58.278519)
    val bernal = Geo(-34.709390, -58.280507, "Bernal")
    val obelisco = Geo(-34.603595, -58.381717, "Obelisco")
    val montevideo = Geo(-34.906450, -56.199442, "Montevideo")
    val roma = Geo(41.902952, 12.495681, "Roma")
    val mit = Geo(42.360088, -71.094058, "MIT")
    val esquel = Geo(-42.914301, -71.319680, "Esquel")
    val mendoza = Geo(-32.889588, -68.844830, "Mendoza")

    val places = listOf(bernal, obelisco, montevideo, roma, mit, mendoza, esquel)

    var distance: Double
    places.forEach {
        distance = GeoCalculator.distance(unq, it)
        println("Distancia de UNQ a ${it.name}: $distance KMs")
    }

    val sortedPlaces = places.sortedByDescending { GeoCalculator.distance(it, unq) }

    val names = sortedPlaces.map { it.name }
    println(names)

    val closest = places.minBy { GeoCalculator.distance(unq, it) }
    println(closest)
}
