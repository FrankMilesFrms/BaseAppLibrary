package com.frms.bal

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest
{


	@Test
	@Throws(Exception::class)
	fun addition_isCorrect()
	{
		val sum = 2 + 2
		println("结果为：$sum")
		assertEquals(4, sum)
	}
}