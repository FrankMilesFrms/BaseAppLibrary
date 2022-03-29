package com.frms.bal

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import 	android.content.Intent
import android.view.LayoutInflater
import com.frms.bal.test.TestGuideActivity
import com.frms.bal.test.TestSplashActivity
import com.frms.bal.ui.BalGuideActivity
import com.frms.bal.utils.BalActivitiesKit
import com.frms.bal.view.BalDialogs

class MainActivity : BalBaseActivity(), View.OnClickListener
{
	val mRecyclerViewItems = ArrayList<String>()
	val functions = arrayOf(
		"BalApplication ： 全局Application",
		"BalGuideActivity : 新用户引导页",
		"BalSplashActivity : 开始页"
	)
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

	}

	override fun onStart()
	{
		super.onStart()

		val recyclerView = findViewById<RecyclerView>(R.id.test_recyclerView)
		// 功能添加
		for (i in functions)
			mRecyclerViewItems.add(i)

		recyclerView.adapter = RecyclerAdapter(this)
		recyclerView.layoutManager = LinearLayoutManager(this)

	}

	class RecyclerAdapter(activity: MainActivity) : RecyclerView.Adapter<RecyclerHolder>()
	{
		private val ctx = activity;

		override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerHolder
		{
			val view = LayoutInflater.from(ctx).inflate(R.layout.test_title, parent, false)
			return RecyclerHolder(view)
		}

		override fun onBindViewHolder(holder: RecyclerHolder, position: Int)
		{
			holder.text.text = ctx.mRecyclerViewItems[position]
			holder.text.setOnClickListener(ctx)
		}

		override fun getItemCount(): Int = ctx.functions.size

	}

	class RecyclerHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
	{
		val text : TextView = itemView.findViewById(R.id.test_textView)
	}

	override fun onClick(v: View?)
	{
		(v as TextView).let {
			when (v.text)
			{
				functions[0] -> {
					BalDialogs.rawShowDialog(it.context, "本application = $application")
				}

				functions[1] -> {
					// 引导页
					val intent = Intent(this@MainActivity, TestGuideActivity::class.java)
					startActivity(intent)
				}

				functions[2] -> {
					val intent = Intent(this@MainActivity, TestSplashActivity::class.java)
					startActivity(intent)
				}

			}
		}
	}
}