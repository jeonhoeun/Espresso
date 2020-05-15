package com.hejeon.espresso.basictest

import com.hejeon.espresso.basictest.MainActivityTest
import com.hejeon.espresso.basictest.SecondActivityTest
import com.hejeon.espresso.fragmenttest.ArgumentFragmentTest
import com.hejeon.espresso.fragmenttest.MyFragmentTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

//TEST__06 액티비티 테스트 묶음
@RunWith(Suite::class)
@Suite.SuiteClasses(
    MainActivityTest::class,
    SecondActivityTest::class,
    MyFragmentTest::class,
    ArgumentFragmentTest::class
)
class ActivityTestSuite