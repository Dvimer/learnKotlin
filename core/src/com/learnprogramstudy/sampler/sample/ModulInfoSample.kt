package com.learnprogramstudy.sampler.sample

import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx
import com.learnprogramstudy.sampler.common.SampleBase
import com.learnprogramstudy.sampler.utils.logger

class ModulInfoSample : SampleBase() {


    companion object {
        @JvmStatic
        private val log = logger<ModulInfoSample>()
    }

    override fun create() {
        Gdx.app.logLevel = Application.LOG_DEBUG

        log.debug("App= ${Gdx.app}")
        log.debug("audio= ${Gdx.audio}")
        log.debug("input= ${Gdx.input}")
        log.debug("files= ${Gdx.files}")
        log.debug("net= ${Gdx.net}")
        log.debug("graphics= ${Gdx.graphics}")
    }
}
