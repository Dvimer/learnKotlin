package com.learnprogramstudy.sampler.common

import com.learnprogramstudy.sampler.sample.*

object SampleInfos {

    val allSamples = arrayListOf(
            SampleInfo(ApplicationListenerSample::class.java),
            SampleInfo(GdxGeneratedSample::class.java),
            SampleInfo(InputListeningSample::class.java),
            SampleInfo(InputPolingSample::class.java),
            SampleInfo(ModulInfoSample::class.java),
            SampleInfo(MultiplexerSampler::class.java),
            SampleInfo(ReflectionSample::class.java),
            SampleInfo(OrthographicCameraSample::class.java),
            SampleInfo(ViewportSample::class.java),
            SampleInfo(SpriteBatchSample::class.java)
    )

    fun getSampleNames() = allSamples.associateBy { it.name }.keys.toList().sorted().toTypedArray()

    fun find(name: String) = allSamples.find { it.name == name }
}
