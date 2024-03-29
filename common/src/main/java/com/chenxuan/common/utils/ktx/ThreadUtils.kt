package com.chenxuan.common.utils.ktx

import android.os.Handler
import android.os.Looper
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * @author cx
 */
private val handler = Handler(Looper.getMainLooper())
private val coreSize = Runtime.getRuntime().availableProcessors() + 1

private val fix: ExecutorService = Executors.newFixedThreadPool(coreSize)
private val cache: ExecutorService = Executors.newCachedThreadPool()
private val single: ExecutorService = Executors.newSingleThreadExecutor()
private val scheduled: ExecutorService = Executors.newScheduledThreadPool(coreSize)

fun <T> T.runOnUi(block: T.() -> Unit) {
    handler.post {
        block()
    }
}

fun <T> T.runOnUiDelay(delayMillis: Long, block: T.() -> Unit) {
    handler.postDelayed({
        block()
    }, delayMillis)
}

fun <T> T.runOnSinglePool(block: T.() -> Unit) {
    single.execute {
        block()
    }
}

fun <T> T.runOnFixPool(block: T.() -> Unit) {
    fix.execute {
        block()
    }
}

fun <T> T.runOnCachePool(block: T.() -> Unit) {
    cache.execute {
        block()
    }
}