package bean

import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Created by NKumar on 1/23/2017.
 */
case class User(id: Int, name: String)

object SparkTest extends App {

  val scf = new SparkConf
  scf.setAppName("demo")
  scf.set("spark.io.compression.codec", "lzf")
  scf.set("spark.speculation", "true")
  scf.setMaster("local[4]")
  val sc = new SparkContext(scf)
  val hc:org.apache.spark.sql.SQLContext = new HiveContext(sc)
  import hc.implicits._
  val df:org.apache.spark.sql.DataFrame = sc.textFile("/src/main/resources/testdata.csv").filter(line => !line.contains("id")).map(line => line.split(",")).map(words => User(words(0).toInt, words(1))).toDF()

  df.show()


}
