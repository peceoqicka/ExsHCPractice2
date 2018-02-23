package com.em.hcpractice2

import android.graphics.Bitmap
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import com.em.hcpractice2.view.*
import org.jetbrains.anko.find

class MainActivity : AppCompatActivity() {
    private val viewList = ArrayList<View>()
    private lateinit var spidermanBitmap: Bitmap
    private lateinit var logoBitmap: Bitmap
    private lateinit var colorFilterView: ColorFilterView
    private lateinit var xfermodeView: XfermodeView
    private lateinit var maskFilterView: MaskFilterView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    override fun onDestroy() {
        spidermanBitmap.recycle()
        logoBitmap.recycle()
        super.onDestroy()
    }

    private fun initView() {
        val tabsTitle = resources.getStringArray(R.array.tabs_pra)

        val tabLayout = find<TabLayout>(R.id.tab_layout).also { tab ->
            tab.tabMode = TabLayout.MODE_SCROLLABLE
        }

        val viewpager = find<ViewPager>(R.id.viewpager)

        viewList.run {
            add(LinearGradientView(this@MainActivity))
            add(RadialGradientView(this@MainActivity))
            add(SweepGradientView(this@MainActivity))
            ColorFilterView(this@MainActivity)
                    .also { v -> colorFilterView = v;add(v) }
            XfermodeView(this@MainActivity)
                    .also { v -> xfermodeView = v;add(v) }
            add(StrokeCapView(this@MainActivity))
            add(ShadowLayerView(this@MainActivity))
            MaskFilterView(this@MainActivity)
                    .also { v -> maskFilterView = v;add(v) }
            add(FillPathView(this@MainActivity))
        }

        spidermanBitmap = BitmapUtil.getBitmap(resources, R.drawable.spiderman)
        logoBitmap = BitmapUtil.getBitmap(resources, R.drawable.spider_transparent_logo, 4)
        colorFilterView.bitmap = spidermanBitmap
        xfermodeView.setBitmap(spidermanBitmap, logoBitmap)
        maskFilterView.bitmap = spidermanBitmap

        val pagerAdapter = MyAdapter(tabsTitle, viewList)
        viewpager.adapter = pagerAdapter
        tabLayout.setupWithViewPager(viewpager)
    }

    private class MyAdapter(val titles: Array<String>, val viewList: List<View>) : PagerAdapter() {
        override fun getCount(): Int = titles.size
        override fun getPageTitle(position: Int): CharSequence = titles[position]
        override fun isViewFromObject(view: View, obj: Any) = view == obj

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            return viewList[position].also { v -> container.addView(v) }
        }

        override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
            container.removeView(viewList[position])
        }
    }
}
