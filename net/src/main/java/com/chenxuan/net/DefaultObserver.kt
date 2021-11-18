package com.chenxuan.net

import android.net.ParseException
import com.blankj.utilcode.util.ToastUtils
import com.google.gson.JsonParseException
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import org.json.JSONException
import retrofit2.HttpException
import java.io.InterruptedIOException
import java.net.ConnectException
import java.net.UnknownHostException

/**
 * @author cx
 */
abstract class DefaultObserver<T> : Observer<T> {
    override fun onSubscribe(d: Disposable) {}
    override fun onNext(t: T) {
        onSuccess(t)
        onFinish()
    }

    override fun onError(e: Throwable) {
        when (e) {
            is HttpException -> {
                onException(ExceptionReason.BAD_NETWORK)
            }
            is ConnectException, is UnknownHostException -> {
                onException(ExceptionReason.CONNECT_ERROR)
            }
            is InterruptedIOException -> {
                onException(ExceptionReason.CONNECT_TIMEOUT)
            }
            is JsonParseException, is JSONException, is ParseException -> {
                onException(ExceptionReason.PARSE_ERROR)
            }
            is ApiException -> {
                onFail(e.message)
            }
            else -> {
                onException(ExceptionReason.UNKNOWN_ERROR)
            }
        }
        onFinish()
    }

    override fun onComplete() {}

    protected abstract fun onSuccess(response: T)

    private fun onFail(message: String?) {
        ToastUtils.showShort(message)
    }

    private fun onFinish() {}

    private fun onException(reason: ExceptionReason) {
        when (reason) {
            ExceptionReason.CONNECT_ERROR -> ToastUtils.showShort("连接错误")
            ExceptionReason.CONNECT_TIMEOUT -> ToastUtils.showShort("连接超时")
            ExceptionReason.BAD_NETWORK -> ToastUtils.showShort("网络错误")
            ExceptionReason.PARSE_ERROR -> ToastUtils.showShort("解析错误")
            ExceptionReason.UNKNOWN_ERROR -> ToastUtils.showShort("未知错误")
        }
    }

    private enum class ExceptionReason {
        /**
         * 解析数据失败
         */
        PARSE_ERROR,

        /**
         * 网络问题
         */
        BAD_NETWORK,

        /**
         * 连接错误
         */
        CONNECT_ERROR,

        /**
         * 连接超时
         */
        CONNECT_TIMEOUT,

        /**
         * 未知错误
         */
        UNKNOWN_ERROR
    }
}