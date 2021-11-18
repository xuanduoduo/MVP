package com.chenxuan.business.api

import com.chenxuan.bean.business.ChaptersBean
import com.chenxuan.common.base.BaseService
import com.chenxuan.net.BaseResponse
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * @author cx
 * business module api
 */
interface BusinessApiService : BaseService {
    @GET("/wxarticle/chapters/json")
    fun getChapters(): Observable<BaseResponse<List<ChaptersBean>>>
}