package com.learnprogramstudy.sampler.desktop

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.learnprogramstudy.sampler.sample.ModulInfoSample

fun main(args: Array<String>) {
    println("App= ${Gdx.app}")
    println("audio= ${Gdx.audio}")
    LwjglApplication(ModulInfoSample(), LwjglApplicationConfiguration())
    println("App= ${Gdx.app}")
    println("audio= ${Gdx.audio}")
}