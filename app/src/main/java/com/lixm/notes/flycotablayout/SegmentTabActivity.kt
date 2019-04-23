package com.lixm.notes.flycotablayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.flyco.tablayout.listener.OnTabSelectListener
import com.lixm.notes.R
import kotlinx.android.synthetic.main.activity_segment_tab.*








class SegmentTabActivity : AppCompatActivity() {
    private val mTitles = arrayOf("首页", "消息")
    private val mTitles_2 = arrayOf("首页", "消息", "联系人")
    private val mTitles_3 = arrayOf("首页", "消息", "联系人", "更多")
    private val mFragments = ArrayList<Fragment>()
    private val mFragments2 = ArrayList<Fragment>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segment_tab)
        for (title in mTitles_3) {
            mFragments.add(SimpleCardFragment.getInstance("Switch ViewPager $title"))
        }
        for (title in mTitles_2) {
            mFragments2.add(SimpleCardFragment.getInstance("Switch Fragment $title"))
        }
        tl_1.setTabData(mTitles)
        tl_1.showDot(1)

        tl_2.setTabData(mTitles_2)

        tl3()

        tl_4.setTabData(mTitles_2,this, com.lixm.notes.R.id.fl_change,mFragments2)

        tl_5.setTabData(mTitles_3)
    }

    private fun tl3() {
        vp_2.adapter = MyPagerAdapter(supportFragmentManager)
        tl_3.setTabData(mTitles_3)
        tl_3.setOnTabSelectListener(object :OnTabSelectListener{
            override fun onTabSelect(position: Int) {
                vp_2.currentItem = position
            }

            override fun onTabReselect(position: Int) {
            }
        })
        vp_2.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                tl_3.currentTab = position
            }
        })
        vp_2.currentItem = 1
    }
    private inner class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getCount(): Int {
            return mFragments.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return mTitles_3[position]
        }

        override fun getItem(position: Int): Fragment {
            return mFragments.get(position)
        }
    }
}