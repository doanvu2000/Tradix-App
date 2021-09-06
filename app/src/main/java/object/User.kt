package `object`

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var userName: String, var timeRegister: String, var currentMoney: String,
    var currentPercent: String
) : Parcelable {
}