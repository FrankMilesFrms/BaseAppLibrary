package com.frms.bal

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

/**
 *基本Activity， 这管理着所有Activity
 *@author Frms(CLY)
 *@time 2022/03/25 19:08
 */
open class BalBaseActivity : AppCompatActivity()
{
	override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?)
	{
		super.onCreate(savedInstanceState, persistentState)

		(application as BalApplication).getActivityManager().add(this)
	}

}