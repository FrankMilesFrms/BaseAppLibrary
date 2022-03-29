package com.frms.bal.test

import android.os.Bundle
import android.view.View
import android.widget.Button
import com.frms.bal.R
import com.frms.bal.ui.BalGuideActivity

/**
 *
 *@author Frms(CLY)
 *@time 2022/03/29 14:57
 */
class TestGuideActivity : BalGuideActivity()
{
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
	}

	override fun onStart()
	{
		super.onStart()
		addImages(
			intArrayOf(
				R.drawable.bal_test3,
				R.drawable.bal_test4,
				R.drawable.bal_test3,
				R.drawable.bal_test4
			)
		) {
			finish()
		}

		getButton().text = "replace"
	}
}