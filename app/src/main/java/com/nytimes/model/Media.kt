package com.nytimes.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.nytimes.model.MediaMetadata
import kotlinx.android.parcel.Parcelize
import javax.inject.Inject

@Parcelize
data class Media(
    val approved_for_syndication: Int,
    val caption: String,
    val copyright: String,

    @SerializedName("media-metadata")
    val mediaMetadata: List<MediaMetadata>,
    val subtype: String,
    val type: String
):Parcelable