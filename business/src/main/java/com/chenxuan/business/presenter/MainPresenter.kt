package com.chenxuan.business.presenter

import com.chenxuan.bean.business.ChaptersBean
import com.chenxuan.business.contract.IMain
import com.chenxuan.business.module.MainModule
import com.chenxuan.common.base.BasePresenter
import com.chenxuan.common.base.IView
import com.chenxuan.common.utils.ktx.async
import com.chenxuan.net.DefaultObserver

/**
 * @author cx
 */
class MainPresenter(view: IView) : BasePresenter<IMain.View>(view) {
    private val mainModule by lazy {
        MainModule()
    }

    fun getChapters() {
        mViewRef?.get()?.let {
            mainModule.getChapters()
                .async(it)
                .subscribe(object : DefaultObserver<List<ChaptersBean>>() {
                    override fun onSuccess(response: List<ChaptersBean>) {
                        it.onSuccess(response)
                    }
                })
        }
    }
}