package com.chenxuan.common.base

import com.trello.rxlifecycle3.LifecycleTransformer
import io.reactivex.ObservableTransformer

/**
 * @author cx
 */
interface IView {
    /**
     * toast
     */
    fun showToast(msg: String)

    /**
     * 关闭页面
     */
    fun finishPage()

    /**
     * 线程切换
     */
    fun <T> bindThread(): ObservableTransformer<T, T>

    /**
     * RxLifecycle
     */
    fun <T> bindLifeCycle(): LifecycleTransformer<T>

    /**
     * Loading
     */
    fun <T> bindLoading(): ObservableTransformer<T, T>
}