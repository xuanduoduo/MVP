package com.chenxuan.login.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.chenxuan.bean.login.ChaptersBean
import com.chenxuan.common.base.BaseActivity
import com.chenxuan.common.utils.ktx.setSingleClick
import com.chenxuan.common.utils.router.RouterPath
import com.chenxuan.login.R
import com.chenxuan.login.contract.ILogin
import com.chenxuan.login.presenter.LoginPresenter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.login_activity_login.*

/**
 * @author cx
 */
@Route(path = RouterPath.LOGIN_MAIN)
class LoginActivity : BaseActivity<ILogin.View, LoginPresenter>(), ILogin.View {
    override fun initData(savedInstanceState: Bundle?) {
    }

    override fun initView(savedInstanceState: Bundle?) {
        tvLogin.setSingleClick {
            presenter.getChapters()
        }
    }

    override fun createPresenter(): LoginPresenter {
        return LoginPresenter(this)
    }

    override fun getContentView(): Int {
        return R.layout.login_activity_login
    }

    override fun onSuccess(list: List<ChaptersBean>) {
        tvLogin.text = Gson().toJson(list)
    }
}
