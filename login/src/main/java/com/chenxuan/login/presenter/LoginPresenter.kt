package com.chenxuan.login.presenter

import com.chenxuan.bean.login.ChaptersBean
import com.chenxuan.common.base.BasePresenter
import com.chenxuan.common.base.IView
import com.chenxuan.common.utils.ktx.async
import com.chenxuan.login.contract.ILogin
import com.chenxuan.login.module.LoginModule
import com.chenxuan.net.DefaultObserver

/**
 * @author cx
 */
class LoginPresenter(view: IView) : BasePresenter<ILogin.View>(view) {
    private val loginModule by lazy {
        LoginModule()
    }

    fun getChapters() {
        mViewRef?.get()?.let {
            loginModule.getChapters()
                .async(it)
                .subscribe(object : DefaultObserver<List<ChaptersBean>>() {
                    override fun onSuccess(response: List<ChaptersBean>) {
                        it.onSuccess(response)
                    }
                })
        }
    }
}