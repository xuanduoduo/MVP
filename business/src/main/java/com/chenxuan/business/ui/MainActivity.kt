package com.chenxuan.business.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.chenxuan.bean.business.ChaptersBean
import com.chenxuan.business.contract.IMain
import com.chenxuan.business.databinding.BusinessActivityMainBinding
import com.chenxuan.business.presenter.MainPresenter
import com.chenxuan.common.base.BaseActivity
import com.chenxuan.common.utils.ktx.setSingleClick
import com.chenxuan.common.utils.router.RouterPath
import com.google.gson.Gson

/**
 * @author cx
 */
@Route(path = RouterPath.BUSINESS_MAIN)
class MainActivity :
    BaseActivity<IMain.View, MainPresenter, BusinessActivityMainBinding>(),
    IMain.View {
    override fun createViewBinding() = BusinessActivityMainBinding.inflate(layoutInflater)

    override fun initData(savedInstanceState: Bundle?) {
    }

    override fun initView(savedInstanceState: Bundle?) {
        binding.tvBusiness.setSingleClick {
            presenter.getChapters()
        }
    }

    override fun createPresenter(): MainPresenter {
        return MainPresenter(this)
    }

    override fun onSuccess(list: List<ChaptersBean>) {
        binding.tvBusiness.text = Gson().toJson(list)
    }
}
