package com.chenxuan.business.contract

import com.chenxuan.bean.business.ChaptersBean
import com.chenxuan.common.base.IView

/**
 * @author cx
 */
interface IMain {
    interface View : IView {
        fun onSuccess(list: List<ChaptersBean>)
    }
}