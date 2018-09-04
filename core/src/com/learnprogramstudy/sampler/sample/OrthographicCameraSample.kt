package com.learnprogramstudy.sampler.sample

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.Logger
import com.badlogic.gdx.utils.viewport.FillViewport
import com.badlogic.gdx.utils.viewport.Viewport
import com.learnprogramstudy.sampler.common.SampleBase
import com.learnprogramstudy.sampler.utils.*

class OrthographicCameraSample : SampleBase() {
    companion object {
        @JvmStatic
        private val log = logger<OrthographicCameraSample>()

        private const val WORDL_WIDTH = 10.8f
        private const val WORDL_HEIGHT = 7.2f
        private const val CAMERA_SPEED = 2.0f
        private const val CAMERA_ZOOM_SPEED = 2.0f
    }

    private lateinit var camera: OrthographicCamera
    private lateinit var vievport: Viewport
    private lateinit var batch: SpriteBatch
    private lateinit var texture: Texture


    override fun create() {
        Gdx.app.logLevel = Logger.DEBUG
        log.debug("create()")
        camera = OrthographicCamera()
        camera.setToOrtho(true)
        vievport = FillViewport(WORDL_WIDTH, WORDL_HEIGHT, camera)
        batch = SpriteBatch()
        texture = Texture("raw/level-bg.png".toInternalFile())
    }

    override fun resize(width: Int, height: Int) {
        vievport.update(width, height, true)
    }


    override fun render() {
        clearScreen()
        queryImput()

        batch.projectionMatrix = camera.combined
        batch.use { draw() }
    }

    private fun queryImput() {
        val deltaTime = Gdx.graphics.deltaTime

        when {
            Input.Keys.LEFT.isKeyPressed() -> camera.position.x -= CAMERA_SPEED * deltaTime
            Input.Keys.RIGHT.isKeyPressed() -> camera.position.x += CAMERA_SPEED * deltaTime
            Input.Keys.UP.isKeyPressed() -> camera.position.y += CAMERA_SPEED * deltaTime
            Input.Keys.DOWN.isKeyPressed() -> camera.position.y -= CAMERA_SPEED * deltaTime
            Input.Keys.Z.isKeyPressed() -> camera.zoom += CAMERA_ZOOM_SPEED * deltaTime
            Input.Keys.X.isKeyPressed() -> camera.zoom -= CAMERA_ZOOM_SPEED * deltaTime
            Input.Keys.ENTER.isKeyPressed() -> log.debug("position x = ${camera.position.x}, position y = ${camera.position.y}")
//            else -> log.debug("no key pressed")
        }

        camera.update()
    }

    private fun draw() {
        batch.draw(texture, 0f, 0f, WORDL_WIDTH, WORDL_HEIGHT)

    }

    override fun dispose() {
        batch.dispose()
        texture.dispose()
    }
}
