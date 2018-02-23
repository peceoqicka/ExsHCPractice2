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
class ColorFilterView(context: Context) : View(context) {
    var bitmap: Bitmap? = null
        set(value) {
            field = value;onSetBitmap()
        }
    private val normalPaint: Paint = Paint()
    //Lighting Color Filter
    private val lcfPaint: Paint = Paint()
    //Porter Duff Color Filter
    private val pcfPaint: Paint = Paint()
    //Color Matrix Color Filter
    private val ccfPaint: Paint = Paint()

    init {
        lcfPaint.run {
            colorFilter = LightingColorFilter(0x56abe3,
                    0x000000)
        }
        pcfPaint.run {
            colorFilter = PorterDuffColorFilter(Color.parseColor("#6656abe3"),
                    PorterDuff.Mode.LIGHTEN)
        }
        ccfPaint.run {
            colorFilter = ColorMatrixColorFilter(
                    floatArrayOf(
                            1f, 0f, 0f, 0f, 0f,
                            0f, 0.5f, 0f, 0f, 0f,
                            0f, 0f, 1f, 1f, 0f,
                            0f, 0f, 0.5f, 1.5f, 0f))
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
            canvas.drawBitmap(_bitmap, 50f, 50f, normalPaint)
            canvas.drawBitmap(_bitmap, 100f + _bitmap.width, 50f, lcfPaint)
            canvas.drawBitmap(_bitmap, 150f + _bitmap.width * 2, 50f, pcfPaint)
            canvas.drawBitmap(_bitmap, 50f, 100f + _bitmap.width, ccfPaint)
        }
    }
}