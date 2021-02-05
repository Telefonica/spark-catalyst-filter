package org.apache.spark.sql

import org.apache.spark.sql.catalyst.expressions._
import org.apache.spark.sql.functions._

object CustomFunctions {

  private def withExpr(expr: Expression): Column = Column(expr)

  def addOneCustomNative(columnName: String): Column =
    withExpr {
      AddOneCustomNative(columnName, col(columnName).expr)
    }
}
