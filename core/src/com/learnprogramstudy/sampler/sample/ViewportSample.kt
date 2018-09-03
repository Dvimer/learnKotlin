package com.learnprogramstudy.sampler.sample

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.ArrayMap
import com.badlogic.gdx.utils.Logger
import com.badlogic.gdx.utils.viewport.*
import com.learnprogramstudy.sampler.common.SampleBase
import com.learnprogramstudy.sampler.utils.clearScreen
import com.learnprogramstudy.sampler.utils.isKeyPressed
import com.learnprogramstudy.sampler.utils.logger
import com.learnprogramstudy.sampler.utils.toInternalFile

class ViewportSample : SampleBase() {
    companion object {
        @JvmStatic
        private val log = logger<ViewportSample>()

        private const val WORDL_WIDTH = 1080f
        private const val WORDL_HEIGHT = 720f
    }

    private lateinit var camera: OrthographicCamera
    private lateinit var currentViewport: Viewport
    private lateinit var batch: SpriteBatch
    private lateinit var texture: Texture
    private lateinit var font: BitmapFont

    private val viewports = ArrayMap<String, Viewport>()
    private var currentViewportIndex = -1
    private var currentViewportName = ""

    override fun create() {
        Gdx.app.logLevel = Logger.DEBUG
        log.debug("create()")
        camera = OrthographicCamera()


        batch = SpriteBatch()
        texture = Texture("raw/level-bg.png".toInternalFile())
        font = BitmapFont("fonts/oswald-32.fnt".toInternalFile())

        createViewports()
        selectNextViewport()

        Gdx.input.inputProcessor = this
    }


    private fun createViewports() {
        viewports.put(StretchViewport::class.java.simpleName, StretchViewport(WORDL_WIDTH, WORDL_HEIGHT, camera))
        viewports.put(FitViewport::class.java.simpleName, FitViewport(WORDL_WIDTH, WORDL_HEIGHT, camera))
        viewports.put(FillViewport::class.java.simpleName, FillViewport(WORDL_WIDTH, WORDL_HEIGHT, camera))
        viewports.put(ScreenViewport::class.java.simpleName, ScreenViewport(camera))
        viewports.put(ExtendViewport::class.java.simpleName, ExtendViewport(WORDL_WIDTH, WORDL_HEIGHT, camera))
    }


    private fun selectNextViewport() {
        currentViewportIndex = (currentViewportIndex + 1) % viewports.size

        currentViewport = viewports.getValueAt(currentViewportIndex)
        resize(Gdx.graphics.width, Gdx.graphics.height)
        currentViewportName = viewports.getKeyAt(currentViewportIndex)

        log.debug("selected viewport = $currentViewportName")
    }

    override fun resize(width: Int, height: Int) {
        currentViewport.update(width, height, true)
    }


    override fun render() {
        clearScreen()

        batch.projectionMatrix = camera.combined
        batch.begin()
        draw()
        batch.end()
    }


    private fun draw() {
        batch.draw(texture, 0f, 0f, WORDL_WIDTH, WORDL_HEIGHT)
        font.draw(batch, currentViewportName, 50f, 100f)

    }

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        selectNextViewport()
        return false
    }

    override fun dispose() {
        batch.dispose()
        texture.dispose()
    }
}
