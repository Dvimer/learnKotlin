package com.learnprogramstudy.sampler.common

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.InputProcessor

class SampleInfo(val clazz: Class<out SampleBase>) {
    val name: String = clazz.simpleName

}