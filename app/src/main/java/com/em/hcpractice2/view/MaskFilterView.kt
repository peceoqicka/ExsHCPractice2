package com.em.hcpractice2.view

import android.content.Context
import android.graphics.*
import android.view.View

/**
 * <pre>
 *      author  :   Acer
 *      e-mail  :   xx@xxx
 *      time    :   2018/2/8
 *      desc    :   Hardware Accelerate not support yet
 *      version :   1.0
 * </pre>
 */
class MaskFilterView(context: Context) : View(context) {
    var bitmap: Bitmap? = null
        set(value) {
            field = value;onSetBitmap()
        }
    //Blur Mask Filter
    private val bmPaint: Paint = Paint()
    //Emboss Mask Filter
    private val ebPaint: Paint = Paint()

    init {
        bmPaint.run {
            maskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.NORMAL)
        }
        ebPaint.run {
            maskFilter = EmbossMaskFilter(floatArrayOf(0f, 1f, 1f), 0.2f, 8f, 10f)
        }
    }

    private fun onSetBitmap() {
        bitmap?.let {
            postInvalidate()
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        bitmap?.let { _bitmap ->
            canvas.drawBitmap(_bitmap, 50f, 50f, bmPaint)
            canvas.drawBitmap(_bitmap, 100f + _bitmap.width, 50f, ebPaint)
        }
    }
}