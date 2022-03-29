package com.frms.bal.utils

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
import android.view.View.SYSTEM_UI_FLAG_IMMERSIVE
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity


/**
 *活动页的通用工具
 *@author Frms(CLY)
 *@time 2022/03/29 12:45
 */
object BalActivitiesKit
{
	/**
	 * 通过设置全屏，设置状态栏透明
	 */
	fun fullScreen(activity : Activity) : BalActivitiesKit
	{

		if(activity.actionBar != null)
			activity.actionBar.hide()
		if(activity is AppCompatActivity)
			activity.supportActionBar?.hide()

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
		{
			//5.x开始需要把颜色设置透明，否则导航栏会呈现系统默认的浅灰色
			val window = activity.window
			val decorView = window.decorView
			//两个 flag 要结合使用，表示让应用的主体内容占用系统状态栏的空间
			val option: Int = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
					or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
			decorView.systemUiVisibility = option
			window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
			window.statusBarColor = Color.TRANSPARENT
			//导航栏颜色也可以正常设置
//                window.setNavigationBarColor(Color.TRANSPARENT);
		} else
		{
			val window = activity.window
			val attributes = window.attributes
			val flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
			val flagTranslucentNavigation = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
			attributes.flags = attributes.flags or flagTranslucentStatus
			//                attributes.flags |= flagTranslucentNavigation;
			window.attributes = attributes
		}
		return this
	}

	/**
	 * 隐藏导航栏
	 * @param activity Activity
	 */
	fun hideNavigationBar(activity: Activity) : BalActivitiesKit
	{
		val decorView = activity.window.decorView
		val option = SYSTEM_UI_FLAG_HIDE_NAVIGATION or SYSTEM_UI_FLAG_IMMERSIVE
		decorView.systemUiVisibility = option
		return this
	}
}