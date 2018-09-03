package com.learnprogramstudy.sampler.utils

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.sun.prism.paint.Color

fun clearScreen(color: Color = Color.BLACK) = clearScreen(color.red, color.green, color.blue, color.alpha)


fun clearScreen(red: Float, green: Float, blue: Float, alfa: Float) {
    Gdx.gl.glClearColor(red, green, blue, alfa)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
}