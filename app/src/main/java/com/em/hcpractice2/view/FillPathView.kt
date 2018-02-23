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
class FillPathView(context: Context) : View(context) {
    companion object {
        const val TEXT = "Hello Kotlin"
    }

    private val paint: Paint = Paint()
    private val outlinePaint: Paint = Paint()
    private val outlinePath: Path = Path()

    init {
        paint.run {
            color = Color.parseColor("#FFFFFF")
            style = Paint.Style.FILL_AND_STROKE
            strokeWidth = 5f
            textSize = 75f
        }
        outlinePaint.run {
            color = Color.parseColor("#333333")
            style = Paint.Style.STROKE
            strokeWidth = 5f
        }
        paint.getTextPath(TEXT, 0, TEXT.length, 100f, 200f, outlinePath)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.run {
            drawText(TEXT, 100f, 200f, paint)
            drawPath(outlinePath, outlinePaint)
        }
    }
}