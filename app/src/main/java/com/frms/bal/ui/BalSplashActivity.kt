package com.frms.bal.ui

import android.R
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import com.frms.bal.BalBaseActivity
import com.frms.bal.MainActivity
import java.sql.Time


/**
 *默认加载开始页
 *@author Frms(CLY)
 *@time 2022/03/29 22:19
 */
open class BalSplashActivity : BalBaseActivity()
{
	private lateinit var mThread: Thread
	private lateinit var mActivity: Class<*>
	private var waitTime : Long = 0L

	fun addWaitTime(second : Long, activity : Class<*>)
	{
		waitTime = second
		mActivity = activity
	}

	fun onRun()
	{
		Thread.sleep(waitTime)
		finish()
		val intent = Intent(this, mActivity)
		startActivity(intent)
		overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
	}

}