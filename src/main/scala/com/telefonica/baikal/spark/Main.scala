package com.telefonica.baikal.spark

import org.apache.spark.sql.CustomFunctions.addOneCustomNative
import org.apache.spark.sql.SparkSession

object Main {

  def main(args: Array[String]): Unit = {

    def buildSparkSession(): SparkSession = {
      SparkSession.builder()
        .appName("Catalyst Filter")
        .master("local[*]")
        .getOrCreate()
    }

    val spark = buildSparkSession()

    import spark.implicits._

    try {
      val df = spark.createDataset(0 to 100).toDF("id")
      df.withColumn("plus", addOneCustomNative("id")).show(false)
    } finally {
      spark.close()
    }
  }

}