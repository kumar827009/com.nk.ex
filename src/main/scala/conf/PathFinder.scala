package conf

import scala.xml.NodeSeq

/**
 * Created by NKumar on 12/20/2016.
 */
object PathFinder extends App {
  val in = Array
  val x = <persistance location="HIVE" tableName="RxOutput"/>

  val ret = if (!(x \ "@retainAfter").isEmpty) {
    Some(x \ "@retainAfter")
  } else {
    Some("false")
  }
  println(ret)
  val y = <persistance location="HIVE" tableName="RxOutput" retainAfter="true"/>

  val ret1 = Some(y \ "@retainAfter")
  PersistanceInfo(ret1.get)
  println("---" + ret1)
  println(PersistanceInfo(ret1.get).retainFlag)

  case class PersistanceInfo(node: NodeSeq) {
    val getStorageType: Option[String] = if (((node \ "@empty").toString() == "true")) None else Some((node \ "@location").text)
    val tabeName = if (((node \ "@empty").toString() == "true")) None else Some((node \ "@tableName").text)
    val retainFlag = if (((node \ "@empty").toString() == "true")) None //else Some((node \ "@retain").text)
    else {
      if (!(node \ "@retainAfter").text.isEmpty) Some((node \ "@retainAfter").text) else Some("false")
    }
  }
}
