package com.zyz;


import io.gatling.core.Predef.{exec, _}
import io.gatling.http.Predef._

import scala.concurrent.duration._

/**
 * Hello world!
 *
 */
class ApiGatlingSimulationTest extends Simulation
{
    val scn = scenario("AddAndFindPersons").repeat(1000,"n" ){
      exec(
        http("check-valid")
          .get("http://192.168.178.131:2001/mkt-command/activity/check-valid?activityId=53831")
          .check(status.is(200))
      )
    }
  setUp(scn.inject(atOnceUsers(30))).maxDuration(FiniteDuration.apply(10,"minutes"))
}
