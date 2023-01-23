package com.mazenrashed.moshikotlinextensions

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlin.jvm.Throws

object MoshiExtensions {
    var moshi: Moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    fun init(moshi: Moshi) {
        this.moshi = moshi
    }
}

@Throws(JsonDataException::class)
inline fun <reified T> String.deserialize(moshi: Moshi? = null): T? {
    val jsonAdapter = (moshi ?: MoshiExtensions.moshi).adapter(T::class.java)
    return jsonAdapter.fromJson(this)
}

@Throws(JsonDataException::class)
inline fun <reified T> String.deserializeList(moshi: Moshi? = null): List<T>? {
    val type = Types.newParameterizedType(MutableList::class.java, T::class.java)
    val jsonAdapter: JsonAdapter<List<T>> = (moshi ?: MoshiExtensions.moshi).adapter(type)
    return jsonAdapter.fromJson(this)
}

@Suppress("CheckResult")
fun String.canConvertTo(type: Class<*>, moshi: Moshi? = null): Boolean {
    return try {
        val jsonAdapter = (moshi ?: MoshiExtensions.moshi).adapter(type)
        jsonAdapter.fromJson(this)
        true
    } catch (exception: Exception) {
        exception.printStackTrace()
        false
    }
}

inline fun <reified T> T.serialize(moshi: Moshi? = null): String {
    val jsonAdapter = (moshi ?: MoshiExtensions.moshi).adapter(T::class.java)
    return jsonAdapter.toJson(this)
}
