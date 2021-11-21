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
inline fun <reified T> String.deserialize(): T? {
    val jsonAdapter = MoshiExtensions.moshi.adapter(T::class.java)
    return jsonAdapter.fromJson(this)
}

@Throws(JsonDataException::class)
inline fun <reified T> String.deserializeList(): List<T>? {
    val type = Types.newParameterizedType(MutableList::class.java, T::class.java)
    val jsonAdapter: JsonAdapter<List<T>> = MoshiExtensions.moshi.adapter(type)
    return jsonAdapter.fromJson(this)
}

@Suppress("CheckResult")
fun String.canConvertTo(type: Class<*>): Boolean {
    return try {
        val jsonAdapter = MoshiExtensions.moshi.adapter(type)
        jsonAdapter.fromJson(this)
        true
    } catch (exception: Exception) {
        exception.printStackTrace()
        false
    }
}

inline fun <reified T> T.serialize(): String {
    val jsonAdapter = MoshiExtensions.moshi.adapter(T::class.java)
    return jsonAdapter.toJson(this)
}
