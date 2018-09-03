package com.learnprogramstudy.sampler.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.learnprogramstudy.sampler.sample.OrthographicCameraSample

fun main(args: Array<String>) {
    var config = LwjglApplicationConfiguration()
    config.width = 1080
    config.height = 720

    LwjglApplication(OrthographicCameraSample(), config)
}