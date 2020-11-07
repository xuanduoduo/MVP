package com.chenxuan.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trello.rxlifecycle3.components.support.RxFragment

/**
 * @author cx
 */
abstract class BaseSimpleFragment : RxFragment() {
    private lateinit var contentView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        contentView = inflater.inflate(getLayoutResID(), container, false)
        initPresenter()
        return contentView
    }

    abstract fun getLayoutResID(): Int

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView(savedInstanceState)
        initData(savedInstanceState)
    }

    open fun initPresenter() {

    }

    abstract fun initData(savedInstanceState: Bundle?)

    abstract fun initView(savedInstanceState: Bundle?)
}