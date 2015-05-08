package example

object Main {
  def main(args: Array[String]): Unit = {
    val webroot = new java.net.URL(getClass.getResource("/www/index.html"), ".")

    unfiltered.netty.Server
      .http(8080)
      .resources(webroot)
      .plan(new ExamplePlan)
      .run
  }
}

import unfiltered.netty._
import unfiltered.request._
import unfiltered.response._
import io.netty.handler.codec.http.HttpResponse

@io.netty.channel.ChannelHandler.Sharable
class ExamplePlan extends cycle.Plan with cycle.SynchronousExecution with ServerErrorResponse {
  val intent: PartialFunction[Any, ResponseFunction[HttpResponse]] = {
    case GET(Path("/")) =>
      Redirect("index.html")

    case GET(Path("/status")) => Ok
  }
}
