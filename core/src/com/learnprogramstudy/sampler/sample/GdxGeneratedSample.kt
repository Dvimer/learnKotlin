package com.learnprogramstudy.sampler.sample

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.learnprogramstudy.sampler.common.SampleBase
import com.learnprogramstudy.sampler.utils.clearScreen
import com.learnprogramstudy.sampler.utils.use

class GdxGeneratedSample : SampleBase() {
    lateinit var batch: SpriteBatch
    lateinit var img: Texture

    override fun create() {
        batch = SpriteBatch()
        img = Texture("badlogic.jpg")
    }

    override fun render() {
        clearScreen()

        batch.use { batch.draw(img, 0f, 0f) }
    }

    override fun dispose() {
        batch.dispose()
        img.dispose()
    }
}
