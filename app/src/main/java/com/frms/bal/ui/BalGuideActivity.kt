package com.frms.bal.ui

import android.content.Context
import android.os.Bundle
import android.provider.BrowserContract
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView

import androidx.viewpager2.widget.ViewPager2
import com.frms.bal.BalBaseActivity
import com.frms.bal.R
import com.frms.bal.utils.BalActivitiesKit

/**
 * 新用户开始引导页
 *@author Frms(CLY)
 *@time 2022/03/25 19:20
 */
open class BalGuideActivity : BalBaseActivity()
{
	private lateinit var viewPager2: ViewPager2;
	private lateinit var rl : RelativeLayout
	private lateinit var linear : LinearLayout
	private lateinit var btn : Button

	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)

		BalActivitiesKit
			.fullScreen(this)
			.hideNavigationBar(this)

		setContentView(R.layout.bal_act_guide_act)
		viewPager2 = findViewById(R.id.bal_act_guide_viewpager2)
		rl = findViewById(R.id.bal_act_guide_rl)
		linear = findViewById(R.id.bal_act_guide_linear)
		btn = findViewById(R.id.bal_act_guide_btn)

	}

	companion object {
		private lateinit var images : Array<Int>
		private val imageViews : ArrayList<ImageView> = ArrayList()
	}

	fun addImages(resources : Array<Int>, click : View.OnClickListener)
	{
		images = resources
		viewPager2.adapter = MyAdapter(this)

		var img : ImageView
		var grayIv : ImageView

		for(i in images.indices)
		{
			img = ImageView(this)
			img.setImageResource(images[i])
			imageViews.add(img)

			grayIv = ImageView(this)
			grayIv.setImageResource(R.drawable.bal_gray_circle)
			//使用LayoutParams改变控件的位置
			val layoutParams =  LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT
			)

			if(i > 0)
				layoutParams.leftMargin = 20

			grayIv.layoutParams = layoutParams
			linear.addView(grayIv)
		}
		val red = ImageView(this)
		red.setImageResource(R.drawable.bal_red_circle)
		rl.addView(red)

		var left = 0
		red.viewTreeObserver.addOnGlobalLayoutListener {
			// 求距离
			left = linear.getChildAt(1).left - linear.getChildAt(0).left
		}

		viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback()
		{
			override fun onPageSelected(position: Int)
			{
				super.onPageSelected(position)

					btn.visibility =
						if(position == images.size-1)
							View.VISIBLE
						else
							View.GONE
			}

			override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int)
			{
				super.onPageScrolled(position, positionOffset, positionOffsetPixels)
				val layoutParams = red.layoutParams as RelativeLayout.LayoutParams
				layoutParams.leftMargin = (left * positionOffset + position*left).toInt()
				red.layoutParams = layoutParams;
			}

		})

		btn.setOnClickListener(click)

	}

	private class MyAdapter constructor(ctx : Context) : RecyclerView.Adapter<MyViewHolder> ()
	{
		val ctx = ctx

		override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder
		{
			val image = ImageView(ctx)
			val lp = LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.MATCH_PARENT
			)
			image.layoutParams = lp
			return MyViewHolder(image)
		}

		override fun onBindViewHolder(holder: MyViewHolder, position: Int)
		{
			holder.imageview.setImageResource(images[position])
		}

		override fun getItemCount() = images.size

	}

	data class MyViewHolder(val imageview: ImageView) : RecyclerView.ViewHolder(imageview)
}