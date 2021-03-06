package messages

import play.api.libs.json.{Json, Format, JsValue}

case class Unsubscribe(token: String, channel: String, timestamp: Long, data: Option[JsValue] = None)

object Unsubscribe {
    implicit val unsubscribeFormat: Format[Unsubscribe] = Json.format[Unsubscribe]
}
