package com.learnprogramstudy.sampler.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.learnprogramstudy.sampler.sample.MultiplexerSampler

fun main(args: Array<String>) {
    val config = LwjglApplicationConfiguration()
    config.width = 800
    config.height = 480
    LwjglApplication(MultiplexerSampler(), config)
}