package com.em.hcpractice2.view

import android.content.Context
import android.graphics.*
import android.view.View

/**
 * <pre>
 *      author  :   Acer
 *      e-mail  :   xx@xxx
 *      time    :   2018/2/8
 *      desc    :
 *      version :   1.0
 * </pre>
 */
class StrokeCapView(context: Context) : View(context) {
    private val path1: Path = Path()
    private val buttPaint: Paint = Paint()
    private val roundPaint: Paint = Paint()
    private val squarePaint: Paint = Paint()

    init {
        path1.run {
            moveTo(50f, 200f)
            lineTo(200f, 200f)
        }
        buttPaint.run {
            strokeWidth = 20f
            strokeCap = Paint.Cap.BUTT
        }
        roundPaint.run {
            strokeWidth = 20f
            strokeCap = Paint.Cap.ROUND
        }
        squarePaint.run {
            strokeWidth = 20f
            strokeCap = Paint.Cap.SQUARE
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.run {
            drawLine(50f, 50f, 300f, 50f, buttPaint)
            drawLine(50f, 100f, 300f, 100f, roundPaint)
            drawLine(50f, 150f, 300f, 150f, squarePaint)
        }
    }
}