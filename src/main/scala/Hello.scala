package com.go.dayone

import scala.collection.mutable
import scala.util.{Failure, Success, Try}

/**
 * Created by NKumar on 11/24/2016.
 */
class Hello(message: String, a: Int) {
  /*def this() = this("hello",1) {
    // println("hello " + this.message)
  }*/
  //require(message contains("Hi", "Message don;t have Hi !!!"), "Message don;t have Hi !!!")
  require(message.isEmpty, "Message don't have Hi !!!")


  def this(m: String, n: Int, l: Int) {
    this(m, 1)
  }

  def this(m: String, n: String) {
    this(m, 1)
  }

  val a1 = "{\"failedShopsList\":[{\"hosp_id\":139999999,\"Hosp_NM\":\"LEEDS\",\"Start_Dt\":\"31-02-2015\",\"End_Dt\":\"31-02-2015\",\"LO_Reponse\":\"\",\"Comments\":\"\",\"hospitalAlreadyImputed\":\"0\"},{\"hosp_id\":390000222,\"Hosp_NM\":\"LEEDS\",\"Start_Dt\":\"31-02-2015\",\"End_Dt\":\"31-02-2015\",\"LO_Reponse\":\"\",\"Comments\":\"\",\"hospitalAlreadyImputed\":\"0\"},{\"hosp_id\":13825,\"Hosp_NM\":\"LEEDS\",\"Start_Dt\":\"31-02-2015\",\"End_Dt\":\"31-02-2015\",\"LO_Reponse\":\"\",\"Comments\":\"\",\"hospitalAlreadyImputed\":\"0\"}],\"countryCode\":\"FR\",\"dataAsset\":\"HOSP\",\"action\":\"impute\",\"startDate\":\"20140701\",\"comments\":\"\",\"endDate\":\"20140701\",\"kfuId\":\"4068\",\"imputationRunId\":\"1234\",\"appPath\":null,\"dvURL\":\"jdbc:teiid:IMPUTATION_FRANCE@mm://cdtssoa126d.rxcorp.com:31000\",\"userName\":\"soamgr\",\"password\":\"SOAP@55w0rd\"}"
  val a2 = "{\"failedShopsList\":[{\"hosp_id\":\"10007987\",\"Hosp_NM\":\"CH PUBLIC HAUTEVILLE-LOMPNES  \",\"Start_Dt\":\"20160501\",\"End_Dt\":\"20160531\",\"LO_Reponse\":\"\",\"Comments\":\"\",\"hospitalAlreadyImputed\":\"0\"},{\"hosp_id\":\"10008407\",\"Hosp_NM\":\"CH INTERCOMMUNAL OYONNAX NANTU\",\"Start_Dt\":\"20160501\",\"End_Dt\":\"20160531\",\"LO_Reponse\":\"\",\"Comments\":\"\",\"hospitalAlreadyImputed\":\"0\"}],\"countryCode\":\"FR\",\"dataAsset\":\"HOSP\",\"action\":\"impute\",\"startDate\":\"20160501\",\"comments\":null,\"endDate\":\"20160531\",\"kfuId\":\"9999\",\"appPath\":null,\"dvURL\":\"jdbc:teiid:IMPUTATION_FRANCE@mm://cdtssoa126d.rxcorp.com:31000\",\"userName\":\"soamgr\",\"password\":\"SOAP@55w0rd\"}"
  Option
}

object Test {
  val mailJson: scala.collection.mutable.Map[String, String] = new mutable.HashMap[String,String]()
  def main(args: Array[String]) {

    Try {
      new Hello(null, 1)
      var a: scala.collection.immutable.List[Int] = List(1, 2, 3, 4)
      a = 55 :: a
      a = a :+ 66
      a = 77 +: a
      mailJson +=("aa"->"aa")
      m("hi")

    } match {
      case Success(message) =>
        mailJson +=("ee"->"ee")
        println("Success 22 " + mailJson)

      case Failure(exception) =>
        mailJson +=("ff"->"ff")
        println("Failure 22 " + mailJson + exception.getMessage)

        exception.printStackTrace()
      case _ =>
    }


  }

  def m(param: String): Try[String] = {

    val a = "Hello"
    Try {
      val a = 1
      val b = 0
      mailJson +=("bb"->"bb")
      a / b
    } match {
      case Success(message) =>
        println("Success 11  " + mailJson)
        mailJson +=("cc"->"cc")
        Success("my success message")
      case Failure(exception) =>
        mailJson +=("dd"->"dd")
        println("Failure 11 " + mailJson)
        throw exception
    }
  }
}