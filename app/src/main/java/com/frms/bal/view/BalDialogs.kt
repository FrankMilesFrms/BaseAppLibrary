package com.frms.bal.view

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.dialog.MaterialDialogs

/**
 *对话框, 注意，
 *@author Frms(CLY)
 *@time 2022/03/25 20:25
 */
object BalDialogs
{
//	val NORMAL_THEME = -1

	/*
	https://blog.csdn.net/cunchi4221/article/details/107477069

		style:
		<style name="AlertDialogTheme">
	        <item name="buttonBarPositiveButtonStyle">@style/Alert.Button.Positive</item>
	        <item name="buttonBarNeutralButtonStyle">@style/Alert.Button.Neutral</item>
	    </style>

	    <style name="Alert.Button.Positive" parent="Widget.MaterialComponents.Button.TextButton">
	        <item name="backgroundTint">@color/colorPrimaryDark</item>
	        <item name="rippleColor">@color/colorAccent</item>
	        <item name="android:textColor">@android:color/white</item>
	        <item name="android:textSize">14sp</item>
	        <item name="android:textAllCaps">false</item>
	    </style>

	    <style name="Alert.Button.Neutral" parent="Widget.MaterialComponents.Button.TextButton">
	        <item name="backgroundTint">@android:color/transparent</item>
	        <item name="rippleColor">@color/colorAccent</item>
	        <item name="android:textColor">@android:color/darker_gray</item>
	        <item name="android:textSize">14sp</item>
	    </style>
	 */
	fun ordinaryDialog(
		ctx : Context, overrideThemeResId : Int,
		title : String, message : String,
		click : (dialog : MaterialAlertDialogBuilder) -> Unit
	) : MaterialAlertDialogBuilder
	=
		with(MaterialAlertDialogBuilder(ctx, overrideThemeResId))
		{
			setTitle(title)
			setMessage(message)
			click(this)
			this
		}

	fun ordinaryDialog(
		ctx : Context,
		title : String, message : String, click : (dialog : MaterialAlertDialogBuilder) -> Unit
	) : MaterialAlertDialogBuilder
	=
		ordinaryDialog(
			ctx, 0,
			title, message, click
		)

	fun itemDialog()
	{
//		with(MaterialAlertDialogBuilder())
//		{
//
//		}
	}

	fun addOnClick(
		dialog : MaterialAlertDialogBuilder,
		positive : String, posClick : DialogInterface.OnClickListener?,
		negative : String, negClick : DialogInterface.OnClickListener?,
		neutral  : String, neuClick : DialogInterface.OnClickListener?)
	{
		with(dialog)
		{
			setPositiveButton(positive, posClick
					?: DialogInterface.OnClickListener { dialog, which -> })
			setNegativeButton(negative, negClick?: DialogInterface.OnClickListener { dialog, which -> })
			setNeutralButton(neutral, neuClick?: DialogInterface.OnClickListener { dialog, which -> })
		}
	}
}