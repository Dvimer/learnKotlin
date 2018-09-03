package com.learnprogramstudy.sampler.sample

import com.badlogic.gdx.Application
import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.Gdx
import com.learnprogramstudy.sampler.common.SampleBase
import com.learnprogramstudy.sampler.utils.logger

class ApplicationListenerSample : SampleBase() {

    companion object {
        @JvmStatic
        private val log = logger<ApplicationListenerSample>()
    }

    private var renderInterrupted = false

    override fun create() {
        Gdx.app.logLevel = Application.LOG_DEBUG
        log.debug("create()")
    }

    override fun resize(width: Int, height: Int) {
        log.debug("resize()")
    }

    override fun render() {
        if (renderInterrupted) {
            renderInterrupted = false
            log.debug("render()")
        }
    }

    override fun pause() {
        log.debug("pause")
        renderInterrupted = true
    }

    override fun resume() {
        log.debug("resume()")
        renderInterrupted = true
    }

    override fun dispose() {
        log.debug("dispose()")
    }

}
