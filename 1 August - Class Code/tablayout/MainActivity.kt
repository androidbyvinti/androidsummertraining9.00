package com.bmpl.tablayout

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        tabLayout.setupWithViewPager(viewPager) // tabs will attached to the view pager

        // custom function --> we attach fragment files with view pager
        setUpPages(viewPager) // fragments will be loaded from this method in our activity
    }
    // void print(int value){}
    // fun print(value : Int){}
    fun setUpPages(viewPager : ViewPager){
                        //custom class --> object created of our custom class
        var fragmentLoader = FragmentLoader(supportFragmentManager)

        var contactsFragment = ContactsFragment()

        fragmentLoader.add(contactsFragment, "Contacts") // tab title
        fragmentLoader.add(CallsFragment(), "Calls") // new object of CallsFragment class
        viewPager.adapter = fragmentLoader
    }
    // inner class
    class FragmentLoader(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager){

        var fragmentList = ArrayList<Fragment>()
        var titleList = ArrayList<String>()

        override fun getPageTitle(position: Int): CharSequence {
            return titleList[position]
        }

        override fun getItem(position: Int): Fragment {
            return fragmentList[position] // position < fragmentList.size
                                            // fragmentList.size = 2
                                        // 1<2
        }
        override fun getCount(): Int {
            return fragmentList.size //
        }

        fun add(fragment : Fragment, title : String){
            fragmentList.add(fragment) //  0 --> contactfragment obj, 1 -> callfragment obj
            titleList.add(title)
        }
    }

}
