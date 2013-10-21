package net.tapcat

import org.scalatest.{ShouldMatchers, FlatSpec}
import dispatch._, Defaults._
import scala.concurrent._
import scala.concurrent.duration.Duration
import java.util.concurrent.{TimeoutException, ExecutionException, TimeUnit}

class HealthCheckTest extends FlatSpec with ShouldMatchers {

  "HealthCheck response" should "be 200 if everything is OK" in {
    val svc = url("http://api.tapcat.net/monitoring/health")
    try{
      def future = Http(svc OK as.String)
      Await.result(future, Duration.create(5, TimeUnit.SECONDS))
    } catch {
      case ex: ExecutionException => fail(s"Http failure with $ex")
      case _: TimeoutException => fail("Timeout")
    }
  }
}
