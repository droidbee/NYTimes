package com.nytimes.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import javax.inject.Inject

@Parcelize
data class MediaMetadata (
    val format: String,
    val height: Int,
    val url: String,
    val width: Int
):Parcelable