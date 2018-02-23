package com.em.hcpractice2

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory

/**
 * <pre>
 *      author  :   Acer
 *      e-mail  :   xx@xxx
 *      time    :   2018/2/8
 *      desc    :
 *      version :   1.0
 * </pre>
 */
object BitmapUtil {
    fun getBitmap(resource: Resources, id: Int, sampleSize: Int = 2): Bitmap {
        val options = BitmapFactory.Options()
        options.inSampleSize = sampleSize
        return BitmapFactory.decodeResource(resource, id, options)
    }
}