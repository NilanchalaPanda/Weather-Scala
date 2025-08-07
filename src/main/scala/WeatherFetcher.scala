import sttp.client4._
import io.circe._, io.circe.parser._
import sttp.client4.httpurlconnection.HttpURLConnectionBackend

object WeatherFetcher {
  def fetchWeather(cityName: String): Unit = {
    val apiKey = ConfigLoader.getApiKey

    val queryParams = Map(
      "q" -> cityName,
      "appid" -> apiKey,
      "units" -> "metric"
    )

    val request = quickRequest
      .get(uri"https://api.openweathermap.org/data/2.5/weather?$queryParams")
      .response(asString)

    val backend = HttpURLConnectionBackend()
    val response = request.send(backend)

//    response.body match {
//      case Right(body) =>
//        val parsedJson = parse(body).getOrElse(Json.Null)
//        val prettyJson = Printer.spaces2.print(parsedJson)
//        println(s"Weather data for $cityName:\n$prettyJson")
//
//      case Left(error) =>
//        println(s"Error fetching weather data: $error")
//    }


    response.body match {
      case Right(body) =>
        val parsedJson = parse(body).getOrElse(Json.Null)

        val cursor = parsedJson.hcursor

        val description = cursor
          .downField("weather")
          .downArray
          .get[String]("description")

        print(s"Description - $description")

        val prettyJson = Printer.spaces2.print(parsedJson)
        println(s"Weather data for $cityName:\n$prettyJson")

      case Left(error) =>
        println(s"Error fetching weather data: $error")
    }
  }
}
