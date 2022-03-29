package com.frms.bal

import android.app.Application
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import java.util.*

/**
 * 这里管理所有的Activity及其工具
 *@author Frms(CLY)
 *@time 2022/03/23 22:22
 */
open class BalApplication : Application()
{
	// activity 管理器
	private val activitiesManager = LinkedList<BalBaseActivity>()

	/**
	 * 重写此方法可以监听APP一些配置信息的改变事件（如屏幕旋转等），当配置信息改变的时候会调用这个方法。<p/><p/>
	 *
	 * 在Manifest文件下的Activity标签（注意是Activity）里配置android:configChanges属性相应的配置属性，
	 * 会使Activity在配置改变时候不会重启，只会执行onConfigurationChanged()方法。
	 *
	 * 如：android:configChanges="keyboardHidden|orientation|screenSize"属性可以使Activity旋转时不重启。
	 * @param newConfig Configuration
	 */
	override fun onConfigurationChanged(newConfig: Configuration?)
	{
		super.onConfigurationChanged(newConfig)

	}

	override fun onLowMemory()
	{
		super.onLowMemory()
	}

	fun addActivity(activity: BalBaseActivity) = activitiesManager.add(activity)

	fun getActivityManager() = activitiesManager

	override fun toString(): String =
		"BalApplication, 存活数activity=${activitiesManager.size}"
}