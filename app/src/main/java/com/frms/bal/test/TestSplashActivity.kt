package com.frms.bal.test

import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.widget.Toast
import com.frms.bal.MainActivity
import com.frms.bal.R
import com.frms.bal.ui.BalSplashActivity
import com.frms.bal.utils.BalActivitiesKit

/**
 *
 *@author Frms(CLY)
 *@time 2022/03/29 22:20
 */
class TestSplashActivity : BalSplashActivity()
{
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.bal_default_splash)

		BalActivitiesKit.fullScreen(this).hideNavigationBar(this)
		addWaitTime(1000, MainActivity::class.java)
		Toast.makeText(this, "默认背景板色可视(延时1s)", Toast.LENGTH_LONG).show()

		Handler().post {
			Thread.sleep(1000)
			onRun()
		}
	}

}