package com.frms.bal.view

import android.app.AlertDialog
import android.content.Context

/**
 *对话框
 *@author Frms(CLY)
 *@time 2022/03/25 20:25
 */
object BalDialogs
{
	fun rawShowDialog(ctx : Context, message : String)
	{
		val builder = AlertDialog.Builder(ctx)
		builder.setTitle("Raw Show Dialog")
			.setMessage(message)
			.setNegativeButton("关闭", null)
			.create().show()
	}
}