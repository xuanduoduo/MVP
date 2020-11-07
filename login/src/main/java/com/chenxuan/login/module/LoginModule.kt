package com.chenxuan.login.module

import com.chenxuan.bean.login.ChaptersBean
import com.chenxuan.common.base.BaseModule
import com.chenxuan.login.api.LoginApiService
import com.chenxuan.net.Api
import com.chenxuan.net.ApiServiceUtil
import io.reactivex.Observable

/**
 * @author cx
 */
class LoginModule : BaseModule<LoginApiService>() {
    override fun createApiService(): LoginApiService {
        return ApiServiceUtil.getApiService()
    }

    fun getChapters(): Observable<List<ChaptersBean>> {
        return api.getChapters().map(Api.HandleFuc())
    }
}