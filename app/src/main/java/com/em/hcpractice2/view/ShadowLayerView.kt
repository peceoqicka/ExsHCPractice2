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
class ShadowLayerView(context: Context) : View(context) {
    private val paint: Paint = Paint()

    init {
        paint.run {
            textSize = 85f
            setShadowLayer(10f, 0f, 0f, Color.parseColor("#777777"))
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.run {
            drawText("Hello Kotlin", 50f, 100f, paint)
        }
    }
}