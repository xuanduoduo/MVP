package com.chenxuan.common.base

/**
 * @author cx
 */
abstract class BaseModule<T : BaseService> : IModule {
    val api: T
        get() = createApiService()

    abstract fun createApiService(): T
}