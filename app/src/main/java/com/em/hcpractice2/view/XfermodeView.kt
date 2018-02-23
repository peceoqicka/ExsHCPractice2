package com.em.hcpractice2.view

import android.content.Context
import android.graphics.*
import android.view.View
import org.jetbrains.anko.sp

/**
 * <pre>
 *      author  :   Acer
 *      e-mail  :   xx@xxx
 *      time    :   2018/2/8
 *      desc    :
 *      version :   1.0
 * </pre>
 */
class XfermodeView(context: Context) : View(context) {
    private lateinit var spider: Bitmap
    private lateinit var logo: Bitmap
    private val paint: Paint = Paint()
    private val modeDstIn = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
    private val modeDst = PorterDuffXfermode(PorterDuff.Mode.DST)
    private val modeSrcIn = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
    private val modeSrc = PorterDuffXfermode(PorterDuff.Mode.SRC)
    private val modeMultiply = PorterDuffXfermode(PorterDuff.Mode.MULTIPLY)
    private val modeClear = PorterDuffXfermode(PorterDuff.Mode.CLEAR)

    fun setBitmap(spider: Bitmap, logo: Bitmap) {
        this.spider = spider
        this.logo = logo
        postInvalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.run {
            draw2Bitmaps(spider, logo, 50f, 50f, paint, modeDstIn)
            draw2Bitmaps(spider, logo, 100f + spider.width, 50f, paint, modeDst)
            draw2Bitmaps(spider, logo, 150f + spider.width * 2, 50f, paint, modeSrcIn)
            draw2Bitmaps(spider, logo, 50f, 100f + spider.width, paint, modeSrc)
            draw2Bitmaps(spider, logo, 100f + spider.width, 100f + spider.width, paint, modeMultiply)
            draw2Bitmaps(spider, logo, 150f + spider.width * 2, 100f + spider.width, paint, modeClear)
        }
    }

    private fun Canvas.draw2Bitmaps(bitmap1: Bitmap, bitmap2: Bitmap, left: Float, top: Float, paint: Paint, xfermode: Xfermode) {
        this.run {
            val saved = saveLayer(null, paint)
            drawBitmap(bitmap1, left, top, paint)
            paint.xfermode = xfermode
            drawBitmap(bitmap2, left, top, paint)
            paint.xfermode = null
            restoreToCount(saved)
        }
    }
}