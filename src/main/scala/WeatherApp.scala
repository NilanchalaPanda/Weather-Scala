object WeatherApp {
  def main(args: Array[String]): Unit = {
    var continue = true

    while (continue) {
      print("\n\nType '1' to continue for next city or 'exit' to end: ")
      val input = scala.io.StdIn.readLine().trim.toLowerCase

      input match {
        case "exit" =>
          continue = false
          println("Exiting the weather app. Goodbye!")

        case "1" =>
          print("\n----------------------\n")
          print("Enter the city name please: ")
          val cityName = scala.io.StdIn.readLine().trim
          println(s"You chose the city - $cityName")
          WeatherFetcher.fetchWeather(cityName)

        case _ =>
          println("Invalid input. Please type '1' to continue or 'exit' to quit.")
      }
    }
  }
}
