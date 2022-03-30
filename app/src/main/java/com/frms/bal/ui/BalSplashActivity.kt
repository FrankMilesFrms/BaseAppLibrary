package com.frms.bal.ui

import android.R
import android.content.Intent


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
		startActivity()
	}

	/**
	 * 也可以将加载项作为不定加载时间
	 * @param runnable Runnable
	 */
	fun onRun(runnable: Runnable)
	{
		Thread(runnable).run()
		startActivity()
	}

	private fun startActivity()
	{
		finish()
		val intent = Intent(this, mActivity)
		startActivity(intent)
		overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
	}

}