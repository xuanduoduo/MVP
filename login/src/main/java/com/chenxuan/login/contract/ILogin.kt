package com.chenxuan.login.contract

import com.chenxuan.bean.login.ChaptersBean
import com.chenxuan.common.base.IView

/**
 * @author cx
 */
interface ILogin {
    interface View : IView {
        fun onSuccess(list: List<ChaptersBean>)
    }
}