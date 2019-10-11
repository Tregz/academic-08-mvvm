package com.tregz.mvvm.data.user

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class UserModel(
    var allergic: Boolean = false,
    var birthDate: Date? = null,
    var email: String? = null,
    var firstName: String? = null,
    var gender: Int = 0,
    var lastName: String? = null,
    var phoneNumber: Long? = null
) : Parcelable {

    companion object {
        val TAG = UserModel::class.java.simpleName
    }
}