package com.learnprogramstudy.sampler.sample

import com.badlogic.gdx.*
import com.learnprogramstudy.sampler.common.SampleBase
import com.learnprogramstudy.sampler.utils.logger

class MultiplexerSampler : SampleBase() {


    companion object {
        @JvmStatic
        private val log = logger<MultiplexerSampler>()
    }

    override fun create() {

        Gdx.app.logLevel = Application.LOG_DEBUG
        val firstProcessor = object : InputAdapter() {
            override fun keyDown(keycode: Int): Boolean {
                log.debug("first keyDown keycode = $keycode")
                return true
            }

            override fun keyUp(keycode: Int): Boolean {
                log.debug("first keyUp keycode = $keycode")
                return false
            }
        }

        val secondProcessor = object : InputAdapter() {
            override fun keyDown(keycode: Int): Boolean {
                log.debug("second keyDown keycode = $keycode")
                return true
            }

            override fun keyUp(keycode: Int): Boolean {
                log.debug("second keyUp keycode = $keycode")
                return false
            }
        }

        Gdx.input.inputProcessor = InputMultiplexer(secondProcessor, firstProcessor)
    }
}
