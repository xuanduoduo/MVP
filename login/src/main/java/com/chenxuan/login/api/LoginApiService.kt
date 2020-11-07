package com.chenxuan.login.api

import com.chenxuan.bean.login.ChaptersBean
import com.chenxuan.common.base.BaseService
import com.chenxuan.net.BaseResponse
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * @author cx
 * login module api
 */
interface LoginApiService : BaseService {
    @GET("/wxarticle/chapters/json")
    fun getChapters(): Observable<BaseResponse<List<ChaptersBean>>>
}