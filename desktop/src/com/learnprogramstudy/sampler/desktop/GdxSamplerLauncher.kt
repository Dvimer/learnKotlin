package com.learnprogramstudy.sampler.desktop

import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.backends.lwjgl.LwjglAWTCanvas
import com.badlogic.gdx.utils.reflect.ClassReflection
import com.learnprogramstudy.sampler.common.SampleFactory
import com.learnprogramstudy.sampler.common.SampleInfos
import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import javax.swing.*

class GdxSamplerLauncher : JFrame() {
    private val windowsWidth = 1280
    private val windowsHeight = 720
    private val windowSize = Dimension(windowsWidth, windowsHeight)
    private val cellWith = 200
    private val canvasWidth = windowsWidth - cellWith

    private var lwjglAWTCanvas: LwjglAWTCanvas? = null
    private lateinit var sampleList: JList<String>

    init {
        title = GdxSamplerLauncher::class.java.simpleName
        minimumSize = windowSize
        size = windowSize
//        isResizable = false
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE

        createControlePanel()

        addWindowListener(object : WindowAdapter() {
            override fun windowClosing(e: WindowEvent?) {
                println("windows closing")
                lwjglAWTCanvas?.stop()
            }
        })

        pack()
        isVisible = true
    }

    private fun createControlePanel() {
        val controlPanel = JPanel(GridBagLayout())
        val c = GridBagConstraints()
        c.apply {
            gridx = 0
            gridy = 0
            fill = GridBagConstraints.VERTICAL
            weighty = 1.0
        }

        sampleList = JList(SampleInfos.getSampleNames())
        sampleList.fixedCellWidth = cellWith
        sampleList.selectionMode = ListSelectionModel.SINGLE_SELECTION

        sampleList.addMouseListener(object : MouseAdapter() {
            override fun mouseClicked(mouseEvent: MouseEvent?) {
                if (mouseEvent?.clickCount == 2) {
                    launchSelectedSample()
                }
            }


        })
        val scrolePane = JScrollPane(sampleList)
        controlPanel.add(scrolePane, c)

        c.apply {
            gridx = 0
            gridy = 1
            fill = GridBagConstraints.HORIZONTAL
            weighty = 0.0
        }

        val launchButton = JButton("Launch Sample")
        launchButton.addActionListener { launchSelectedSample() }

        controlPanel.add(launchButton, c)

        contentPane.add(controlPanel, BorderLayout.WEST)

    }

    private fun launchSelectedSample() {
        val sampleName: String? = sampleList.selectedValue

        if (sampleName.isNullOrBlank()) {
            println("sample name is null or blank cant launch")
            return
        }

        launchSample(sampleName)
    }

    private fun launchSample(name: String?) {
        println("lauching name=$name")

        lwjglAWTCanvas?.stop()

        if (lwjglAWTCanvas != null) {
            contentPane.remove(lwjglAWTCanvas?.canvas)
        }

        if (!name.isNullOrEmpty()) {
            val sample = SampleFactory.newSample(name!!)

            lwjglAWTCanvas = LwjglAWTCanvas(sample)
            lwjglAWTCanvas?.canvas?.size = Dimension(canvasWidth, windowsHeight)
            contentPane.add(lwjglAWTCanvas?.canvas, BorderLayout.CENTER)
            pack()
        }
    }
}


fun main(args: Array<String>) {
    SwingUtilities.invokeLater { GdxSamplerLauncher() }
}