package com.learnprogramstudy.sampler.sample

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.Logger
import com.badlogic.gdx.utils.viewport.FillViewport
import com.badlogic.gdx.utils.viewport.Viewport
import com.learnprogramstudy.sampler.common.SampleBase
import com.learnprogramstudy.sampler.utils.GdxArray
import com.learnprogramstudy.sampler.utils.clearScreen
import com.learnprogramstudy.sampler.utils.logger
import com.learnprogramstudy.sampler.utils.toInternalFile


class InputListeningSample : SampleBase() {
    companion object {
        @JvmStatic
        private val log = logger<InputListeningSample>()
    }

    lateinit var camera: OrthographicCamera
    lateinit var vievport: Viewport
    lateinit var batch: SpriteBatch
    lateinit var font: BitmapFont

    private val maxMessageCount = 15
    private val messages = GdxArray<String>()

    override fun create() {
        Gdx.app.logLevel = Logger.DEBUG
        log.debug("create()")
        camera = OrthographicCamera()
        vievport = FillViewport(1080f, 720f, camera)
        batch = SpriteBatch()
        font = BitmapFont("fonts/oswald-32.fnt".toInternalFile())
        Gdx.input.inputProcessor = this
    }

    override fun resize(width: Int, height: Int) {
        vievport.update(width, height, true)
    }


    override fun render() {
        clearScreen()

        batch.projectionMatrix = camera.combined
        batch.begin()
        draw()
        batch.end()
    }

    private fun draw() {
        for (i in 0 until messages.size)
            font.draw(batch, messages[i], 20f, 720f - 40f * i)

    }

    override fun dispose() {
        println("dispose")
        batch.dispose()
        font.dispose()
    }


    private fun addMessage(message: String) {
        messages.add(message)

        if (messages.size > maxMessageCount) {
            messages.removeIndex(0)
        }
    }

    override fun touchUp(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        var message = "touchUp ScreenX = $screenX, ScreenY = $screenY"
        log.debug(message)
        addMessage(message)
        return true
    }

    override fun mouseMoved(screenX: Int, screenY: Int): Boolean {
        var message = "mouseMoved ScreenX = $screenX, ScreenY = $screenY"
        log.debug(message)
        addMessage(message)
        return true
    }

    override fun keyTyped(character: Char): Boolean {
        var message = "keyTyped = $character"
        log.debug(message)
        addMessage(message)
        return true
    }

    override fun scrolled(amount: Int): Boolean {
        var message = "scrolled = $amount"
        log.debug(message)
        addMessage(message)
        return true
    }

    override fun keyUp(keycode: Int): Boolean {
        var message = "keyUp, keycode = $keycode"
        log.debug(message)
        addMessage(message)
        return true
    }

    override fun touchDragged(screenX: Int, screenY: Int, pointer: Int): Boolean {
        var message = "touchDragged ScreenX = $screenX, ScreenY = $screenY"
        log.debug(message)
        addMessage(message)
        return true
    }

    override fun keyDown(keycode: Int): Boolean {
        var message = "keyDown  keyCode= $keycode"
        log.debug(message)
        addMessage(message)
        return true
    }

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        var message = "touchDown ScreenX = $screenX, ScreenY = $screenY"
        log.debug(message)
        addMessage(message)
        return true
    }
}
