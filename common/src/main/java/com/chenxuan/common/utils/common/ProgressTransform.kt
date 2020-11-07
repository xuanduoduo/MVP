package com.chenxuan.common.utils.common

import android.app.Activity
import io.reactivex.ObservableTransformer
import java.lang.ref.WeakReference

/**
 * @author cx
 */
object ProgressTransform {
    fun <T> applyProgressBar(activity: Activity, msg: String): ObservableTransformer<T, T> {
        val activityWeakReference = WeakReference(activity)
        activityWeakReference.get()?.let {
            ProgressDialog.showProgress(it, msg)
        }
        return ObservableTransformer { upstream ->
            upstream.doOnSubscribe { }
                .doOnTerminate {
                    ProgressDialog.dismissProgress()
                }
                .doOnSubscribe { }
        }
    }
}