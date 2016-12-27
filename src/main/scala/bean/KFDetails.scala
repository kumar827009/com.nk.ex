package bean

import scala.beans.BeanProperty

/**
 * Created by NKumar on 12/27/2016.
 */
case class KFDetails(@BeanProperty val failedShopsList: List[bean.FailedShops],
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
