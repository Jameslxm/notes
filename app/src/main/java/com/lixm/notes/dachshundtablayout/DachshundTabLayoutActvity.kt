package com.lixm.notes.dachshundtablayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kekstudio.dachshundtablayout.indicators.DachshundIndicator
import com.lixm.notes.R
import kotlinx.android.synthetic.main.activity_dach_shund_tab_layout.*
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter







class DachshundTabLayoutActvity : AppCompatActivity() {
    private val DOG_BREEDS = arrayOf("Pug", "Beagle", "Bulldog", "Poodle")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dach_shund_tab_layout)
        val indicator = DachshundIndicator(tab_layout)
        view_pager.adapter = PagerAdapter(supportFragmentManager)
        tab_layout.animatedIndicator = indicator
        tab_layout.setupWithViewPager(view_pager)
    }

    inner class PagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        override fun getItem(i: Int): Fragment {
            return PageFragment()
        }

        override fun getCount(): Int {
            return DOG_BREEDS.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return DOG_BREEDS[position]
        }
    }


    class PageFragment : Fragment() {

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            return inflater.inflate(R.layout.fragment_page, container, false)
        }
    }
}