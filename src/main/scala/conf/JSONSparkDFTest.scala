package conf

import com.typesafe.config.ConfigFactory

import scala.beans.BeanProperty

/**
 * Created by NKumar on 12/22/2016.
 * Parsing a JSON using PLAY JSOn API
 */
case class Document(@BeanProperty val id: Int, @BeanProperty val name: String, @BeanProperty val fileType: String)

/*case class FailedShops(@BeanProperty val hosp_id: Int,
                       @BeanProperty val Hosp_NM: String,
                       @BeanProperty val Start_Dt: String,
                       @BeanProperty val End_Dt: String,
                       @BeanProperty val LO_Response: Int,
                       @BeanProperty val reasonforsimulation: String,
                       @BeanProperty val UserValidationOption_ID: String,
                       @BeanProperty val comments: String,
                       @BeanProperty val hospitalAlreadyImputed: String,
                       @BeanProperty val uid: String)*/

case class FailedShops(@BeanProperty val hosp_id: Int,
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
                       @BeanProperty val HOSP_SHORT_NM: String) {
  override def toString: String = super.toString
}

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
                     @BeanProperty val password: String)

import play.api.libs.functional.syntax._
import play.api.libs.json._

object JSONSparkDFTest extends App {

  import play.api.libs.json.Json

  val cmdArguments = ConfigFactory.parseString(args(0)).getString("action")
  println("$$$$" + cmdArguments)
  val cmdArguments1 = """{
    "failedShopsList": [
    {
      "hosp_id": 1008,
      "Hosp_NM": "CHR_METZ-THIONVILLE___________",
      "Start_Dt": "20150101",
      "End_Dt": "20150101",
      "LO_Reponse": "",
      "Comments": "",
      "hospitalAlreadyImputed": "0"
    },
    {
      "hosp_id": 34009,
      "Hosp_NM": "CLINIQUE_LES_AUBEPINES_DIEPPE_",
      "Start_Dt": "20150101",
      "End_Dt": "20150101",
      "LO_Reponse": "",
      "Comments": "",
      "hospitalAlreadyImputed": "0"
    },
    {
      "hosp_id": 57000,
      "Hosp_NM": "CENTRE_HOSPITALIER_CARCASSONNE",
      "Start_Dt": "20150101",
      "End_Dt": "20150101",
      "LO_Reponse": "",
      "Comments": "",
      "hospitalAlreadyImputed": "0"
    },
    {
      "hosp_id": 109001,
      "Hosp_NM": "S.A._109001____________________",
      "Start_Dt": "20150101",
      "End_Dt": "20150101",
      "LO_Reponse": "",
      "Comments": "",
      "hospitalAlreadyImputed": "0"
    },
    {
      "hosp_id": 123001,
      "Hosp_NM": "CLI_123001____________________",
      "Start_Dt": "20150101",
      "End_Dt": "20150101",
      "LO_Reponse": "",
      "Comments": "",
      "hospitalAlreadyImputed": "0"
    },
    {
      "hosp_id": 153029,
      "Hosp_NM": "CLINIQUE_D\u0027OCCITANIE_VEDICI___",
      "Start_Dt": "20150101",
      "End_Dt": "20150101",
      "LO_Reponse": "",
      "Comments": "",
      "hospitalAlreadyImputed": "0"
    },
    {
      "hosp_id": 157029,
      "Hosp_NM": "CLINIQUE_VILLENEV____VEDICI___",
      "Start_Dt": "20150101",
      "End_Dt": "20150101",
      "LO_Reponse": "",
      "Comments": "",
      "hospitalAlreadyImputed": "0"
    },
    {
      "hosp_id": 203001,
      "Hosp_NM": "HOP_203001____________________",
      "Start_Dt": "20150101",
      "End_Dt": "20150101",
      "LO_Reponse": "",
      "Comments": "",
      "hospitalAlreadyImputed": "0"
    },
    {
      "hosp_id": 214001,
      "Hosp_NM": "214001________________________",
      "Start_Dt": "20150101",
      "End_Dt": "20150101",
      "LO_Reponse": "",
      "Comments": "",
      "hospitalAlreadyImputed": "0"
    },
    {
      "hosp_id": 219001,
      "Hosp_NM": "219001_________________________",
      "Start_Dt": "20150101",
      "End_Dt": "20150101",
      "LO_Reponse": "",
      "Comments": "",
      "hospitalAlreadyImputed": "0"
    },
    {
      "hosp_id": 222001,
      "Hosp_NM": "psy_222001____________________",
      "Start_Dt": "20150101",
      "End_Dt": "20150101",
      "LO_Reponse": "",
      "Comments": "",
      "hospitalAlreadyImputed": "0"
    },
    {
      "hosp_id": 226001,
      "Hosp_NM": "LE_226001_HOP_________________",
      "Start_Dt": "20150101",
      "End_Dt": "20150101",
      "LO_Reponse": "",
      "Comments": "",
      "hospitalAlreadyImputed": "0"
    },
    {
      "hosp_id": 300002,
      "Hosp_NM": "CLI_300002____________________",
      "Start_Dt": "20150101",
      "End_Dt": "20150101",
      "LO_Reponse": "",
      "Comments": "",
      "hospitalAlreadyImputed": "0"
    },
    {
      "hosp_id": 301002,
      "Hosp_NM": "CLI_301002____________________",
      "Start_Dt": "20150101",
      "End_Dt": "20150101",
      "LO_Reponse": "",
      "Comments": "",
      "hospitalAlreadyImputed": "0"
    },
    {
      "hosp_id": 307002,
      "Hosp_NM": "PSY_307002____________________",
      "Start_Dt": "20150101",
      "End_Dt": "20150101",
      "LO_Reponse": "",
      "Comments": "",
      "hospitalAlreadyImputed": "0"
    },
    {
      "hosp_id": 556001,
      "Hosp_NM": "HOPITAL_PRIVE_GERIAT_MAGNOLIAS",
      "Start_Dt": "20150101",
      "End_Dt": "20150101",
      "LO_Reponse": "",
      "Comments": "",
      "hospitalAlreadyImputed": "0"
    },
    {
      "hosp_id": 576009,
      "Hosp_NM": "FONDATION_OEUVRE_CROIX_SAINT-S",
      "Start_Dt": "20150101",
      "End_Dt": "20150101",
      "LO_Reponse": "",
      "Comments": "",
      "hospitalAlreadyImputed": "0"
    },
    {
      "hosp_id": 613000,
      "Hosp_NM": "CENTRE_HOSPITALIER_DE_PFASTATT",
      "Start_Dt": "20150101",
      "End_Dt": "20150101",
      "LO_Reponse": "",
      "Comments": "",
      "hospitalAlreadyImputed": "0"
    },
    {
      "hosp_id": 651000,
      "Hosp_NM": "CH_BARENTIN___________________",
      "Start_Dt": "20150101",
      "End_Dt": "20150101",
      "LO_Reponse": "",
      "Comments": "",
      "hospitalAlreadyImputed": "0"
    },
    {
      "hosp_id": 684001,
      "Hosp_NM": "SA_MAIS.DE_SANTE_LES_PERVENCHE",
      "Start_Dt": "20150101",
      "End_Dt": "20150101",
      "LO_Reponse": "",
      "Comments": "",
      "hospitalAlreadyImputed": "0"
    },
    {
      "hosp_id": 690008,
      "Hosp_NM": "CHU_DE_TOULOUSE_______________",
      "Start_Dt": "20150101",
      "End_Dt": "20150101",
      "LO_Reponse": "",
      "Comments": "",
      "hospitalAlreadyImputed": "0"
    },
    {
      "hosp_id": 699009,
      "Hosp_NM": "S._A._POLYCLINIQUE_FLEMING____",
      "Start_Dt": "20150101",
      "End_Dt": "20150101",
      "LO_Reponse": "",
      "Comments": "",
      "hospitalAlreadyImputed": "0"
    },
    {
      "hosp_id": 754002,
      "Hosp_NM": "CENTRE_HOSPITALIER_DE_CERNAY__",
      "Start_Dt": "20150101",
      "End_Dt": "20150101",
      "LO_Reponse": "",
      "Comments": "",
      "hospitalAlreadyImputed": "0"
    },
    {
      "hosp_id": 765008,
      "Hosp_NM": "POLYCLINIQUE_DES_TROIS_FRONTIE",
      "Start_Dt": "20150101",
      "End_Dt": "20150101",
      "LO_Reponse": "",
      "Comments": "",
      "hospitalAlreadyImputed": "0"
    },
    {
      "hosp_id": 807008,
      "Hosp_NM": "CENTRE_HOSPITALIER_DE_THANN___",
      "Start_Dt": "20150101",
      "End_Dt": "20150101",
      "LO_Reponse": "",
      "Comments": "",
      "hospitalAlreadyImputed": "0"
    },
    {
      "hosp_id": 824003,
      "Hosp_NM": "CENTRE_HOSPITALIER_-_ARGENTAN_",
      "Start_Dt": "20150101",
      "End_Dt": "20150101",
      "LO_Reponse": "",
      "Comments": "",
      "hospitalAlreadyImputed": "0"
    },
    {
      "hosp_id": 825000,
      "Hosp_NM": "CH_JACQUES_MONOD_-_FLERS______",
      "Start_Dt": "20150101",
      "End_Dt": "20150101",
      "LO_Reponse": "",
      "Comments": "",
      "hospitalAlreadyImputed": "0"
    },
    {
      "hosp_id": 844001,
      "Hosp_NM": "LE_PARC_HOPITAL_DE_TAVERNY____",
      "Start_Dt": "20150101",
      "End_Dt": "20150101",
      "LO_Reponse": "",
      "Comments": "",
      "hospitalAlreadyImputed": "0"
    },
    {
      "hosp_id": 988006,
      "Hosp_NM": "SARL_POLYCLINIQUE_DU_VAL_DE_LO",
      "Start_Dt": "20150101",
      "End_Dt": "20150101",
      "LO_Reponse": "",
      "Comments": "",
      "hospitalAlreadyImputed": "0"
    }
    ],
    "countryCode": "FR",
    "dataAsset": "HOSP",
    "action": "impute",
    "startDate": "20150101",
    "comments": null,
    "endDate": "20150101",
    "kfuId": "9999",
    "appPath": null,
    "dvURL": "jdbc:teiid:IMPUTATION_FRANCE@mm://cdtssoa126d.rxcorp.com:31000",
    "userName": "soamgr",
    "password": "SOAP@55w0rd"
  }"""
  val jsonString = """{
                        "id": 1,

                        "file_type": "jpg"
                      }"""

  val documentReader: Reads[Document] = (
    (__ \ "id").read[Int] ~
      (__ \ "name").read[String].orElse(Reads.pure("")) ~
      (__ \ "file_type").read[String]
    )(Document.apply _)


  //make sure your implicit documentReader is in scope here
  //Json.parse(jsonString).as[Document]

  //or provide the reader without making use of implicits
  //val buisness = Json.parse(jsonValue).validate[Business](bsnsRds)
  //val doc = Json.parse(jsonString).validate[Document](documentReader)
  val doc = Json.parse(jsonString).as[Document](documentReader)
  println("doc.name :: " + doc.name)

  import play.api.libs.functional.syntax._
  import play.api.libs.json.Reads._
  import play.api.libs.json._

  case class Retailer(firstName: String, lastName: String, email: String, mobileNo: String, password: String)

  case class Business(name: String, preferredUrl: String, businessPhone: String, retailer: Retailer)


  val jsonValue = """
  {
    "business":
    {
      "name":"Some Business Name",
      "preferredUrl":"someurl",
      "businessPhone":"somenumber",
      "retailer":
      {
        "firstName":"Some",
        "lastName":"One",
        "email":"someone@somewhere.com",
        "mobileNo":"someothernumber",
        "password":"$^^HFKH*"
      }
    }

  }"""

  def printJson = {

    implicit val rltRds = (
      (__ \ "firstName").read[String] ~
        (__ \ "lastName").read[String] ~
        (__ \ "email").read[String] ~
        (__ \ "mobileNo").read[String] ~
        (__ \ "password").read[String]
      )(Retailer)

    implicit val bsnsRds = (
      (__ \ "business" \ "name").read[String] ~
        (__ \ "business" \ "preferredUrl").read[String] ~
        (__ \ "business" \ "businessPhone").read[String] ~
        (__ \ "business" \ "retailer").read[Retailer](rltRds)
      )(Business)


    val buisness = Json.parse(jsonValue).validate[Business](bsnsRds)

    //val bus = new Business("Some Business", "somebusinessurl", "somenumber", new Retailer("Some", "One", "someone@somewhere.com", "someothernumber", "$^^HFKH*"))
    //val json = Json.toJson(bus)
    println(buisness)
  }

  printJson
  val documentReader1: Reads[Document] = (
    (__ \ "id").read[Int] ~
      (__ \ "name").read[String].orElse(Reads.pure("")) ~
      (__ \ "file_type").read[String]
    )(Document.apply _)


  //make sure your implicit documentReader is in scope here
  //Json.parse(jsonString).as[Document]

  //or provide the reader without making use of implicits
  //val buisness = Json.parse(jsonValue).validate[Business](bsnsRds)
  val doc1 = Json.parse(jsonString).validate[Document](documentReader1)
  val doc2 = Json.parse(jsonString).as[Document](documentReader1)
  println("=======================================")

  implicit val failedShops: Reads[FailedShops] = (
    (__ \ "hosp_id").read[Int].orElse(Reads.pure(9999)) ~
      (__ \ "Hosp_NM").read[String].orElse(Reads.pure("")) ~
      (__ \ "Start_Dt").read[String].orElse(Reads.pure("")) ~
      (__ \ "End_Dt").read[String].orElse(Reads.pure("")) ~
      (__ \ "LO_Reponse").read[Int].orElse(Reads.pure(9999)) ~
      (__ \ "reasonforsimulation").read[String].orElse(Reads.pure("")) ~
      (__ \ "UserValidationOption_ID").read[String].orElse(Reads.pure("")) ~
      (__ \ "Comments").read[String].orElse(Reads.pure("")) ~
      (__ \ "hospitalAlreadyImputed").read[String].orElse(Reads.pure("")) ~
      (__ \ "uid").read[String].orElse(Reads.pure("")) ~
      (__ \ "TRANS_MTH_NBR").read[Int].orElse(Reads.pure(9999)) ~
      (__ \ "Supplier_NM").read[String].orElse(Reads.pure("")) ~
      (__ \ "HOSP_SHORT_NM").read[String].orElse(Reads.pure(""))
    )(FailedShops.apply _)

  val imputationRequest: Reads[KFDetails] = (
    (__ \ "failedShopsList").read[Seq[FailedShops]] ~
      (__ \ "countryCode").read[String].orElse(Reads.pure("")) ~
      (__ \ "dataAsset").read[String].orElse(Reads.pure("")) ~
      (__ \ "action").read[String].orElse(Reads.pure("")) ~
      (__ \ "startDate").read[String].orElse(Reads.pure("")) ~
      (__ \ "comments").read[String].orElse(Reads.pure("")) ~
      (__ \ "endDate").read[String].orElse(Reads.pure("")) ~
      (__ \ "kfuId").read[String].orElse(Reads.pure("")) ~
      (__ \ "imputationRunId").read[String].orElse(Reads.pure("")) ~
      (__ \ "appPath").read[String].orElse(Reads.pure("")) ~
      (__ \ "dvURL").read[String].orElse(Reads.pure("")) ~
      (__ \ "userName").read[String].orElse(Reads.pure("")) ~
      (__ \ "password").read[String].orElse(Reads.pure(""))
    )(KFDetails.apply _)

  val impReq = Json.parse(cmdArguments).as[KFDetails](imputationRequest)
  println("@@@@@@@ :" + impReq.getCountryCode)
  println("$$$$$$ :" + impReq.getFailedShopsList)

  val fsl = Json.parse(cmdArguments).as[FailedShops](failedShops)
  println("@@@@@@@ :" + fsl.hosp_id)
  println("@@@@@@@ :" + fsl.getHosp_NM)
  println("@@@@@@@ :" + fsl.getHOSP_SHORT_NM)
  println("@@@@@@@1 :" + fsl.TRANS_MTH_NBR)
  println("@@@@@@@2 :" + fsl.Supplier_NM)
  println("@@@@@@@3 :" + fsl.HOSP_SHORT_NM)

  println("----------------------------------------------------")
  println(impReq)

}
