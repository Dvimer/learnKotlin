package com.learnprogramstudy.sampler.sample

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.Logger
import com.badlogic.gdx.utils.viewport.FillViewport
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport
import com.learnprogramstudy.sampler.common.SampleBase
import com.learnprogramstudy.sampler.utils.clearScreen
import com.learnprogramstudy.sampler.utils.logger
import com.learnprogramstudy.sampler.utils.toInternalFile
import com.learnprogramstudy.sampler.utils.use

class SpriteBatchSample : SampleBase() {
    companion object {
        @JvmStatic
        private val log = logger<SpriteBatchSample>()
    }

    private lateinit var camera: OrthographicCamera
    private lateinit var vievport: Viewport
    private lateinit var batch: SpriteBatch
    private lateinit var texture: Texture

    override fun create() {
        Gdx.app.logLevel = Logger.DEBUG
        log.debug("create()")
        camera = OrthographicCamera()
        vievport = FitViewport(10.80f, 7.20f, camera)
        batch = SpriteBatch()
        texture = Texture("raw/character.png".toInternalFile())
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
        val width = 1f
        val height = 1f

        batch.draw(texture,
                1f, 1f,
                width / 2f, height / 2f,
                width, height,
                1f, 1f,
                0f,
                texture.width / 2, texture.height / 2,
                texture.width, texture.height,
                false, false
        )

        batch.draw(texture,
                4f, 2f,
                width / 2f, height / 2f,
                width, height,
                2f, 2f,
                0f,
                0, 0,
                texture.width, texture.height,
                false, false
        )
        val oldColor = batch.color
        batch.color = Color.GREEN

        batch.draw(texture,
                8f, 1f,
                width / 2f, height / 2f,
                width, height,
                1f, 1f,
                0f,
                0, 0,
                texture.width, texture.height,
                false, true
        )

        batch.color = oldColor
    }

    override fun dispose() {
        batch.dispose()
        texture.dispose()
    }
}
