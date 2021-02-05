package org.apache.spark.sql.catalyst.expressions
import org.apache.spark.sql.catalyst.expressions.codegen.{CodegenContext, ExprCode}
import org.apache.spark.sql.types.{DataType, LongType}

case class AddOneCustomNative(columnName: String, child: Expression) extends UnaryExpression with NullIntolerant {

  override def prettyName: String = "addOneSparkNative"
  override def dataType: DataType = LongType

  override protected def nullSafeEval(input: Any): Any = {
    input.asInstanceOf[Int].toLong + 1L
  }

  override protected def doGenCode(ctx: CodegenContext, ev: ExprCode): ExprCode =
    defineCodeGen(ctx, ev, c => s"$c + 1")

}
