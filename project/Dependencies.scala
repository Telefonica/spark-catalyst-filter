import sbt._

object Dependencies {

  lazy val sparkVersion = "2.4.6"
  lazy val sparkCore = "org.apache.spark" %% "spark-core" % sparkVersion
  lazy val sparkSql = "org.apache.spark" %% "spark-sql" % sparkVersion
  lazy val sparkAvro = "org.apache.spark" %% "spark-avro" % sparkVersion

  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.2.2"

  lazy val deps = Seq(
    sparkCore,
    sparkSql,
    sparkAvro,
    sparkCore % Test,
    sparkSql % Test,
    scalaTest % Test
  )

}
