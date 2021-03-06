package com.em.hcpractice2.view

import android.content.Context
import android.graphics.*
import android.view.View

/**
 * <pre>
 *      author  :   Acer
 *      e-mail  :   xx@xxx
 *      time    :   2018/2/6
 *      desc    :
 *      version :   1.0
 * </pre>
 */
class RadialGradientView(context: Context) : View(context) {
    companion object {
        const val CX = 300f
        const val CY = 300f
        const val RADIUS = 200f
    }

    private val paint: Paint = Paint()
    private val pointPaint: Paint = Paint()
    private val linePaint: Paint = Paint()

    init {
        paint.run {
            shader = RadialGradient(CX, CY, RADIUS, Color.parseColor("#8fec16"),
                    Color.parseColor("#16cbec"), Shader.TileMode.CLAMP)
            /*shader = LinearGradient(GRA_X1, GRA_Y1, GRA_X2, GRA_Y2,
                    Color.parseColor("#8fec16"),
                    Color.parseColor("#16cbec"), Shader.TileMode.CLAMP)*/
        }
        pointPaint.run {
            color = Color.BLACK
            strokeWidth = 18f
            strokeCap = Paint.Cap.ROUND
        }
        linePaint.run {
            color = Color.BLACK
            strokeWidth = 6f
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.run {
            drawCircle(CX, CY, RADIUS, paint)
            drawPoint(CX, CY, pointPaint)
            drawLine(CX, CY, CX + RADIUS * 3, CY, linePaint)
        }
    }
}