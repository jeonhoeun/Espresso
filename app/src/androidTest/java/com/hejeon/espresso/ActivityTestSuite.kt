package com.hejeon.espresso

import org.junit.runner.RunWith
import org.junit.runners.Suite

//TEST__06 액티비티 테스트 묶음
@RunWith(Suite::class)
@Suite.SuiteClasses(
    MainActivityTest::class,
    SecondActivityTest::class
)
class ActivityTestSuite