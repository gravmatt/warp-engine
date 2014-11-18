package actor

import akka.actor.ActorSelection
import akka.pattern.ask
import akka.util.Timeout
import play.api.libs.concurrent.Akka
import play.api.libs.json.{JsValue, Json}
import play.api.libs.concurrent.Execution.Implicits._
import scala.concurrent.duration._
import play.api.Play.current

object Push {

    implicit val timeout = Timeout(5 seconds)

    def send(channel: String, json: JsValue): Unit = {
        val actor: ActorSelection = Akka.system.actorSelection("user/*/"+channel)
        (actor ? json).mapTo[JsValue] recover {
            case e: Throwable =>
                Json.obj("error" -> "no user connected")
        }
    }

}
