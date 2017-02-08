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
val st ="{\"failedShopsList\":[{\"hosp_id\":1008,\"Hosp_NM\":\"CHR_METZ-THIONVILLE___________\",\"Start_Dt\":\"20150101\",\"End_Dt\":\"20150101\",\"LO_Reponse\":\"\",\"Comments\":\"\",\"hospitalAlreadyImputed\":\"0\"},{\"hosp_id\":34009,\"Hosp_NM\":\"CLINIQUE_LES_AUBEPINES_DIEPPE_\",\"Start_Dt\":\"20150101\",\"End_Dt\":\"20150101\",\"LO_Reponse\":\"\",\"Comments\":\"\",\"hospitalAlreadyImputed\":\"0\"},{\"hosp_id\":57000,\"Hosp_NM\":\"CENTRE_HOSPITALIER_CARCASSONNE\",\"Start_Dt\":\"20150101\",\"End_Dt\":\"20150101\",\"LO_Reponse\":\"\",\"Comments\":\"\",\"hospitalAlreadyImputed\":\"0\"},{\"hosp_id\":109001,\"Hosp_NM\":\"S.A._109001____________________\",\"Start_Dt\":\"20150101\",\"End_Dt\":\"20150101\",\"LO_Reponse\":\"\",\"Comments\":\"\",\"hospitalAlreadyImputed\":\"0\"},{\"hosp_id\":123001,\"Hosp_NM\":\"CLI_123001____________________\",\"Start_Dt\":\"20150101\",\"End_Dt\":\"20150101\",\"LO_Reponse\":\"\",\"Comments\":\"\",\"hospitalAlreadyImputed\":\"0\"},{\"hosp_id\":153029,\"Hosp_NM\":\"CLINIQUE_D\\\\u0027OCCITANIE_VEDICI___\",\"Start_Dt\":\"20150101\",\"End_Dt\":\"20150101\",\"LO_Reponse\":\"\",\"Comments\":\"\",\"hospitalAlreadyImputed\":\"0\"},{\"hosp_id\":157029,\"Hosp_NM\":\"CLINIQUE_VILLENEV____VEDICI___\",\"Start_Dt\":\"20150101\",\"End_Dt\":\"20150101\",\"LO_Reponse\":\"\",\"Comments\":\"\",\"hospitalAlreadyImputed\":\"0\"},{\"hosp_id\":203001,\"Hosp_NM\":\"HOP_203001____________________\",\"Start_Dt\":\"20150101\",\"End_Dt\":\"20150101\",\"LO_Reponse\":\"\",\"Comments\":\"\",\"hospitalAlreadyImputed\":\"0\"},{\"hosp_id\":214001,\"Hosp_NM\":\"214001________________________\",\"Start_Dt\":\"20150101\",\"End_Dt\":\"20150101\",\"LO_Reponse\":\"\",\"Comments\":\"\",\"hospitalAlreadyImputed\":\"0\"},{\"hosp_id\":219001,\"Hosp_NM\":\"219001_________________________\",\"Start_Dt\":\"20150101\",\"End_Dt\":\"20150101\",\"LO_Reponse\":\"\",\"Comments\":\"\",\"hospitalAlreadyImputed\":\"0\"},{\"hosp_id\":222001,\"Hosp_NM\":\"psy_222001____________________\",\"Start_Dt\":\"20150101\",\"End_Dt\":\"20150101\",\"LO_Reponse\":\"\",\"Comments\":\"\",\"hospitalAlreadyImputed\":\"0\"},{\"hosp_id\":226001,\"Hosp_NM\":\"LE_226001_HOP_________________\",\"Start_Dt\":\"20150101\",\"End_Dt\":\"20150101\",\"LO_Reponse\":\"\",\"Comments\":\"\",\"hospitalAlreadyImputed\":\"0\"},{\"hosp_id\":300002,\"Hosp_NM\":\"CLI_300002____________________\",\"Start_Dt\":\"20150101\",\"End_Dt\":\"20150101\",\"LO_Reponse\":\"\",\"Comments\":\"\",\"hospitalAlreadyImputed\":\"0\"},{\"hosp_id\":301002,\"Hosp_NM\":\"CLI_301002____________________\",\"Start_Dt\":\"20150101\",\"End_Dt\":\"20150101\",\"LO_Reponse\":\"\",\"Comments\":\"\",\"hospitalAlreadyImputed\":\"0\"},{\"hosp_id\":307002,\"Hosp_NM\":\"PSY_307002____________________\",\"Start_Dt\":\"20150101\",\"End_Dt\":\"20150101\",\"LO_Reponse\":\"\",\"Comments\":\"\",\"hospitalAlreadyImputed\":\"0\"},{\"hosp_id\":556001,\"Hosp_NM\":\"HOPITAL_PRIVE_GERIAT_MAGNOLIAS\",\"Start_Dt\":\"20150101\",\"End_Dt\":\"20150101\",\"LO_Reponse\":\"\",\"Comments\":\"\",\"hospitalAlreadyImputed\":\"0\"},{\"hosp_id\":576009,\"Hosp_NM\":\"FONDATION_OEUVRE_CROIX_SAINT-S\",\"Start_Dt\":\"20150101\",\"End_Dt\":\"20150101\",\"LO_Reponse\":\"\",\"Comments\":\"\",\"hospitalAlreadyImputed\":\"0\"},{\"hosp_id\":613000,\"Hosp_NM\":\"CENTRE_HOSPITALIER_DE_PFASTATT\",\"Start_Dt\":\"20150101\",\"End_Dt\":\"20150101\",\"LO_Reponse\":\"\",\"Comments\":\"\",\"hospitalAlreadyImputed\":\"0\"},{\"hosp_id\":651000,\"Hosp_NM\":\"CH_BARENTIN___________________\",\"Start_Dt\":\"20150101\",\"End_Dt\":\"20150101\",\"LO_Reponse\":\"\",\"Comments\":\"\",\"hospitalAlreadyImputed\":\"0\"},{\"hosp_id\":684001,\"Hosp_NM\":\"SA_MAIS.DE_SANTE_LES_PERVENCHE\",\"Start_Dt\":\"20150101\",\"End_Dt\":\"20150101\",\"LO_Reponse\":\"\",\"Comments\":\"\",\"hospitalAlreadyImputed\":\"0\"},{\"hosp_id\":690008,\"Hosp_NM\":\"CHU_DE_TOULOUSE_______________\",\"Start_Dt\":\"20150101\",\"End_Dt\":\"20150101\",\"LO_Reponse\":\"\",\"Comments\":\"\",\"hospitalAlreadyImputed\":\"0\"},{\"hosp_id\":699009,\"Hosp_NM\":\"S._A._POLYCLINIQUE_FLEMING____\",\"Start_Dt\":\"20150101\",\"End_Dt\":\"20150101\",\"LO_Reponse\":\"\",\"Comments\":\"\",\"hospitalAlreadyImputed\":\"0\"},{\"hosp_id\":754002,\"Hosp_NM\":\"CENTRE_HOSPITALIER_DE_CERNAY__\",\"Start_Dt\":\"20150101\",\"End_Dt\":\"20150101\",\"LO_Reponse\":\"\",\"Comments\":\"\",\"hospitalAlreadyImputed\":\"0\"},{\"hosp_id\":765008,\"Hosp_NM\":\"POLYCLINIQUE_DES_TROIS_FRONTIE\",\"Start_Dt\":\"20150101\",\"End_Dt\":\"20150101\",\"LO_Reponse\":\"\",\"Comments\":\"\",\"hospitalAlreadyImputed\":\"0\"},{\"hosp_id\":807008,\"Hosp_NM\":\"CENTRE_HOSPITALIER_DE_THANN___\",\"Start_Dt\":\"20150101\",\"End_Dt\":\"20150101\",\"LO_Reponse\":\"\",\"Comments\":\"\",\"hospitalAlreadyImputed\":\"0\"},{\"hosp_id\":824003,\"Hosp_NM\":\"CENTRE_HOSPITALIER_-_ARGENTAN_\",\"Start_Dt\":\"20150101\",\"End_Dt\":\"20150101\",\"LO_Reponse\":\"\",\"Comments\":\"\",\"hospitalAlreadyImputed\":\"0\"},{\"hosp_id\":825000,\"Hosp_NM\":\"CH_JACQUES_MONOD_-_FLERS______\",\"Start_Dt\":\"20150101\",\"End_Dt\":\"20150101\",\"LO_Reponse\":\"\",\"Comments\":\"\",\"hospitalAlreadyImputed\":\"0\"},{\"hosp_id\":844001,\"Hosp_NM\":\"LE_PARC_HOPITAL_DE_TAVERNY____\",\"Start_Dt\":\"20150101\",\"End_Dt\":\"20150101\",\"LO_Reponse\":\"\",\"Comments\":\"\",\"hospitalAlreadyImputed\":\"0\"},{\"hosp_id\":988006,\"Hosp_NM\":\"SARL_POLYCLINIQUE_DU_VAL_DE_LO\",\"Start_Dt\":\"20150101\",\"End_Dt\":\"20150101\",\"LO_Reponse\":\"\",\"Comments\":\"\",\"hospitalAlreadyImputed\":\"0\"}],\"countryCode\":\"FR\",\"dataAsset\":\"HOSP\",\"action\":\"impute\",\"startDate\":\"20150101\",\"comments\":null,\"endDate\":\"20150101\",\"kfuId\":\"9999\",\"appPath\":null,\"dvURL\":\"jdbc: teiid: IMPUTATION_FRANCE@mm: //cdtssoa126d.rxcorp.com: 31000\",\"userName\":\"soamgr\",\"password\":\"SOAP@55w0rd\"}"
  println(kfRequest)
}