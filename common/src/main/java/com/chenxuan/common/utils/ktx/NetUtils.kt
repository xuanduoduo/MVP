package com.chenxuan.common.utils.ktx

import com.chenxuan.common.base.IView
import io.reactivex.Observable

/**
 * @author cx
 */
fun <T> Observable<T>.async(view: IView): Observable<T> =
    this.compose(view.bindLoading())
        .compose(view.bindThread())
        .compose(view.bindLifeCycle())

fun <T> Observable<T>.asyncWithoutLoading(view: IView): Observable<T> =
    this.compose(view.bindThread())
        .compose(view.bindLifeCycle())