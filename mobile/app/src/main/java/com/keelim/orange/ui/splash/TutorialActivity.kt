package com.keelim.orange.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.keelim.orange.databinding.ActivityTutorialBinding
import com.keelim.orange.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TutorialActivity : AppCompatActivity() {
    private val binding by lazy { ActivityTutorialBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() = with(binding) {
        viewpager.adapter = ViewPager2Adapter()
        btnSkip.setOnClickListener {
            goNext()
        }
        btnNext.setOnClickListener {
            val current = viewpager.currentItem + 1
            if (current < 4) {
                viewpager.currentItem = current
            } else {
                goNext()
            }
        }
        TabLayoutMediator(tabIndicator, viewpager) { tab, position ->
        }.attach()
    }

    private fun goNext() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    inner class ViewPager2Adapter : FragmentStateAdapter(this) {
        private val fragments = listOf<Fragment>(
            TutorialFragment(),
            TutorialFragment(),
            TutorialFragment(),
            TutorialFragment(),
        )

        override fun getItemCount(): Int {
            return fragments.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragments[position]
        }
    }
}