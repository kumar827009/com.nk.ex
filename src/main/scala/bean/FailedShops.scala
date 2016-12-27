package bean

import scala.beans.BeanProperty

/**
 * Created by NKumar on 12/27/2016.
 */
case class FailedShops(@BeanProperty val hosp_id: Int,
                       @BeanProperty val HOSP_PHARMY_ADT_CD: Int,
                       @BeanProperty val Hosp_NM: String,
                       @BeanProperty val Start_Dt: String,
                       @BeanProperty val End_Dt: String,
                       @BeanProperty val LO_Response: Int,
                       @BeanProperty val reasonforsimulation: String,
                       @BeanProperty val ReasonforSIMULATION: String,
                       @BeanProperty val UserValidationOption_ID: Int,
                       @BeanProperty val Comments: String,
                       @BeanProperty val hospitalAlreadyImputed: String,
                       @BeanProperty val uid: String,
                       @BeanProperty val UID: String,
                       @BeanProperty val TotalMonthsSimulated: String,
                       @BeanProperty val TRANS_MTH_NBR: Int,
                       @BeanProperty val Supplier_NM: String,
                       @BeanProperty val HOSP_SHORT_NM: String)