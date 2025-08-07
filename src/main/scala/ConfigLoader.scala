
import java.util.Properties
import java.io.FileInputStream

object ConfigLoader {
  def getApiKey: String = {
    val props = new Properties()
    val input = new FileInputStream("apikey.properties") // Make sure this path is correct
    props.load(input)
    input.close()
    props.getProperty("weather.api.key")
  }
}
