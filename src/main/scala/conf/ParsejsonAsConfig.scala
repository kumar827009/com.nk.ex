package conf

import com.typesafe.config._

import scala.util.{Failure, Success, Try}


/**
 * Created by NKumar on 12/26/2016.
 * Parsing a JSON using TYPESafe Config
 */
/*case class FailedShops(@BeanProperty val hosp_id: Int,
                       @BeanProperty val Hosp_NM: String,
                       @BeanProperty val Start_Dt: String,
                       @BeanProperty val End_Dt: String,
                       @BeanProperty val LO_Response: Int,
                       @BeanProperty val reasonforsimulation: String,
                       @BeanProperty val UserValidationOption_ID: String,
                       @BeanProperty val comments: String,
                       @BeanProperty val hospitalAlreadyImputed: String,
                       @BeanProperty val uid: String,
                       @BeanProperty val TRANS_MTH_NBR: Int,
                       @BeanProperty val Supplier_NM: String,
                       @BeanProperty val HOSP_SHORT_NM: String)

case class KFDetails(@BeanProperty val failedShopsList: Seq[FailedShops],
                     @BeanProperty val countryCode: String,
                     @BeanProperty val dataAsset: String,
                     @BeanProperty val action: String,
                     @BeanProperty val startDate: String,
                     @BeanProperty val comments: String,
                     @BeanProperty val endDate: String,
                     @BeanProperty val kfuId: String,
                     @BeanProperty val imputationRunId: String,
                     @BeanProperty val appPath: String,
                     @BeanProperty val dvURL: String,
                     @BeanProperty val userName: String,
                     @BeanProperty val password: String)*/

object ParsejsonAsConfig extends App {
  val cmdArguments = args(0)

  def getConfigAsString(key: String)(implicit config: Config) = {
    Try {
      config.getString(key)
    } match {
      case Success(s) => s
      case Failure(e) => "NULL"
    }
  }

  def getConfigInt(key: String)(implicit config: Config): Any = {
    Try {
      config.getString(key)
    } match {
      case Success(s) => s
      case Failure(e) => 0

    }
  }

  def getConfigAsInt(key: String)(implicit config: Config): Any = {
    Try {
      config.getString(key)
    } match {
      case Success(s) => s
      case Failure(e) => 0

    }
  }

  val config = ConfigFactory.parseString(cmdArguments)


  val b = config.getList("failedShopsList").toArray.map(a => {
    implicit val fsl = a.asInstanceOf[ConfigValue].atKey("FSL").getObject("FSL").toConfig
    bean.FailedShops(
      getConfigAsString("hosp_id").toInt,
      getConfigAsInt("HOSP_PHARMY_ADT_CD").toString.toInt,
      getConfigAsString("Hosp_NM"),
      getConfigAsString("Start_Dt"),
      getConfigAsString("End_Dt"),
      getConfigAsInt("LO_Response").toString.toInt,
      getConfigAsString("reasonforsimulation"),
      getConfigAsString("ReasonforSIMULATION"),
      getConfigAsInt("UserValidationOption_ID").toString.toInt,
      getConfigAsString("Comments"),
      getConfigAsString("hospitalAlreadyImputed"),
      getConfigAsString("uid"),
      getConfigAsString("UID"),
      getConfigAsString("TotalMonthsSimulated"),
      getConfigAsInt("TRANS_MTH_NBR").toString.toInt,
      getConfigAsString("Supplier_NM"),
      getConfigAsString("HOSP_SHORT_NM")
    )
  }
  )

  println(b.foreach(a => println(a.hosp_id + "---- " + a.getHosp_NM + "-----" + a.getTRANS_MTH_NBR)))

  implicit val reqConfig = config
  val kfRequest = bean.KFDetails(b.toList,
    config.getString("countryCode"),
    config.getString("dataAsset"),
    config.getString("action"),
    config.getString("startDate"),
    getConfigAsString("comments"),
    config.getString("endDate"),
    config.getString("kfuId"),
    getConfigAsString("imputationRunId"),
    getConfigAsString("appPath"),
    config.getString("dvURL"),
    config.getString("userName"),
    config.getString("password")
  )

  def getConfig(callBack: (Config, String) => AnyRef, key: String) = callBack(config, key)

  println(kfRequest)
}