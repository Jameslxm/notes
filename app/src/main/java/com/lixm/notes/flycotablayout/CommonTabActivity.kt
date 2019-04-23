package com.lixm.notes.flycotablayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import kotlinx.android.synthetic.main.activity_common_tab.*
import com.lixm.notes.flycotablayout.entity.TabEntity
import kotlin.random.Random
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.lixm.notes.R






class CommonTabActivity : AppCompatActivity() {
    private val mTitles = arrayOf("首页", "消息", "联系人", "更多")
    private val mTabEntities = ArrayList<CustomTabEntity>()
    private val mFragments = ArrayList<Fragment>()
    private val mFragments2 = ArrayList<Fragment>()
    private val mIconSelectIds = intArrayOf(
        com.lixm.notes.R.mipmap.tab_home_select,
        com.lixm.notes.R.mipmap.tab_speech_select,
        com.lixm.notes.R.mipmap.tab_contact_select,
        com.lixm.notes.R.mipmap.tab_more_select
    )
    private val mIconUnselectIds = intArrayOf(
        com.lixm.notes.R.mipmap.tab_home_unselect,
        com.lixm.notes.R.mipmap.tab_speech_unselect,
        com.lixm.notes.R.mipmap.tab_contact_unselect,
        com.lixm.notes.R.mipmap.tab_more_unselect
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.lixm.notes.R.layout.activity_common_tab)
        for (title in mTitles) {
            mFragments.add(SimpleCardFragment.getInstance("Switch ViewPager $title"))
            mFragments2.add(SimpleCardFragment.getInstance("Switch Fragment " + title));
        }
        for (i in 0 until mTitles.size) {
            mTabEntities.add(TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]))
        }

        tl_1.setTabData(mTabEntities)
        tl_1.showDot(3)
        tl_1.showMsg(1,99)


        tl2()

        tl_3.setTabData(mTabEntities,this, R.id.fl_change, mFragments2)
        tl_3.currentTab = 1
        tl_3.showDot(1)
        tl_3.setOnTabSelectListener(object :OnTabSelectListener{
            override fun onTabSelect(position: Int) {
            }

            override fun onTabReselect(position: Int) {
            }
        })

        tl_4.setTabData(mTabEntities)

        tl_5.setTabData(mTabEntities)

        tl_6.setTabData(mTabEntities)

        tl_7.setTabData(mTabEntities)

        tl_8.setTabData(mTabEntities)
    }

    private fun tl2() {
        vp_2.adapter = MyPagerAdapter(supportFragmentManager)
        var random = Random
        tl_2.setTabData(mTabEntities)
        tl_2.setOnTabSelectListener(object : OnTabSelectListener{
            override fun onTabSelect(position: Int) {
                vp_2.currentItem = position
            }

            override fun onTabReselect(position: Int) {
                if(position == 0){
                    tl_2.showMsg(position,random.nextInt(100)+1)
                }
            }
        })
        vp_2.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                tl_2.currentTab = position
            }
        })
        vp_2.currentItem = 1
    }

    private inner class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getCount(): Int {
            return mFragments.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return mTitles[position]
        }

        override fun getItem(position: Int): Fragment {
            return mFragments.get(position)
        }
    }
}