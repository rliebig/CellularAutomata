import javafx.application.Application
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.scene.layout.StackPane
import javafx.stage.Stage
import javafx.scene.Group
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.control.*
import javafx.scene.input.KeyEvent
import javafx.scene.layout.BorderPane
import javafx.scene.layout.HBox
import javafx.scene.paint.Color
import java.io.ObjectInputFilter
import java.lang.RuntimeException

class View : Application() {
    private var primaryStage : Stage? = null
    private var canvas : Canvas? = null
    private var lbl : Label? = null
    private var progressBar : ProgressBar? = null


    fun main(args : Array<String>) {
        launch()
    }



    override fun start(primaryStage: Stage?) {
        primaryStage?.title = "Cellular Automata Tests"

        val root = Group()
        canvas = Canvas(Configuration.canvasWidth,Configuration.canvasHeight)
        val input = TextField()
        val btn = Button()
        val lbl = Label()
        this.lbl = lbl
        btn.isDefaultButton = true
        btn.text = "Load new Control number"
        btn.onAction = EventHandler {
            val controller = Controller()
            controller.initializeModel()
            controller.controlNumber = input.text.toInt()
            controller.calculateControlNumber()
            for(i in 0 until Configuration.generations ) {
                controller.updateModel()
                show()
            }
        }

        val horizontalBox = HBox()
        horizontalBox.children.add(input)
        horizontalBox.children.add(btn)
        horizontalBox.children.add(lbl)

        val progressBar = ProgressBar()
        this.progressBar = progressBar

        val borderPane =  BorderPane()
        borderPane.top = horizontalBox
        borderPane.center = canvas
        borderPane.bottom = progressBar

        root.children.add(borderPane)

        this.primaryStage = primaryStage
        primaryStage?.scene = Scene(root)
        primaryStage?.show()

        val controller = Controller()

        controller.initializeModel()
        for(i in 0 until Configuration.generations) {
            controller.updateModel()
            show()
        }
    }

    private fun show() {
        progressBar?.progress = Model.calculationProgress.toDouble()
        lbl?.text = Model.binaryString

        val graphicsContext = canvas?.graphicsContext2D
        if(graphicsContext != null) {
            for(generation in 0 until Configuration.generations) {
                for(coordinate in 0 until Configuration.gridLength) {
                    when(Model.getField(generation,coordinate)) {
                        0 -> {
                            graphicsContext.fill = Color.WHITE
                            graphicsContext.stroke = Color.WHITE
                        }
                        1 -> {
                            graphicsContext.fill = Color.BLACK
                            graphicsContext.fill = Color.BLACK
                        }
                    }
                    //TODO let this scale properly
                    val topY : Double = generation.toDouble() * Configuration.resolution
                    val topX : Double = coordinate.toDouble() * Configuration.resolution

                    graphicsContext.fillRect(topX,topY,Configuration.resolution,Configuration.resolution)
                }
            }
        } else {
            throw RuntimeException("GraphicContext is null!")
        }
    }
}