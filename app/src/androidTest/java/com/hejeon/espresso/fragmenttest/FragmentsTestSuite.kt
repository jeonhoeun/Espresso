package com.hejeon.espresso.fragmenttest

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    MyFragmentTest::class,
    ArgumentFragmentTest::class,
    ListArgFragmentTest::class
)
class FragmentsTestSuite