package com.learnprogramstudy.sampler.sample

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.Logger
import com.badlogic.gdx.utils.viewport.FillViewport
import com.badlogic.gdx.utils.viewport.Viewport
import com.learnprogramstudy.sampler.common.SampleBase
import com.learnprogramstudy.sampler.utils.clearScreen
import com.learnprogramstudy.sampler.utils.logger
import com.learnprogramstudy.sampler.utils.toInternalFile
import com.learnprogramstudy.sampler.utils.use

class InputPolingSample : SampleBase() {
    companion object {
        @JvmStatic
        private val log = logger<InputPolingSample>()
    }

    lateinit var camera: OrthographicCamera
    lateinit var vievport: Viewport
    lateinit var batch: SpriteBatch
    lateinit var font: BitmapFont

    override fun create() {
        Gdx.app.logLevel = Logger.DEBUG
        log.debug("create()")
        camera = OrthographicCamera()
        vievport = FillViewport(1080f, 720f, camera)
        batch = SpriteBatch()
        font = BitmapFont("fonts/oswald-32.fnt".toInternalFile())
    }

    override fun resize(width: Int, height: Int) {
        vievport.update(width, height, true)
    }


    override fun render() {
       clearScreen()

        batch.projectionMatrix = camera.combined
        batch.use { draw() }
    }

    private fun draw() {
        val mouseX = Gdx.input.x
        val mouseY = Gdx.input.y

        val leftPress = Gdx.input.isButtonPressed(Input.Buttons.LEFT)
        val rightPress = Gdx.input.isButtonPressed(Input.Buttons.RIGHT)


        font.draw(batch, "MouseX = $mouseX, MouseY = $mouseY", 20f, 720f - 20f)

        val leftPressedString = if (leftPress) "Left pressed" else "Left NOT pressed"
        val rightPressedString = if (rightPress) "Right pressed" else "Right NOT pressed"

        font.draw(batch, leftPressedString, 20f, 720f - 50f)
        font.draw(batch, rightPressedString, 20f, 720f - 80f)

        val wPressed = Gdx.input.isKeyPressed(Input.Keys.W)
        val sPressed = Gdx.input.isKeyPressed(Input.Keys.S)

        font.draw(batch,
                if (wPressed) "W pressed" else "W NOT pressed",
                20f,
                720f - 110f)

        font.draw(batch,
                if (sPressed) "S pressed" else "S NOT pressed",
                20f,
                720f - 140f)


    }

    override fun dispose() {
        batch.dispose()
        font.dispose()
    }
}
