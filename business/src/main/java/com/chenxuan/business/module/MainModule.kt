package com.chenxuan.business.module

import com.chenxuan.bean.business.ChaptersBean
import com.chenxuan.business.api.BusinessApiService
import com.chenxuan.common.base.BaseModule
import com.chenxuan.net.Api
import com.chenxuan.net.ApiServiceUtil
import io.reactivex.Observable

/**
 * @author cx
 */
class MainModule : BaseModule<BusinessApiService>() {
    override fun createApiService(): BusinessApiService {
        return ApiServiceUtil.getApiService()
    }

    fun getChapters(): Observable<List<ChaptersBean>> {
        return api.getChapters().map(Api.HandleFuc())
    }
}