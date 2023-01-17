package com.ghao.lib.core

import org.jetbrains.annotations.TestOnly

object TestConfig {
    /**
     * @return true if running in any test environment (both device and JVM-only return true).
     * This is the true setting, and can't be overridden by [.forceNotTest].
     */
    val defaultIsTest: Boolean = classExists("org.junit.runners.ParentRunner")
    private val DEFAULT_IS_ANDROID_TEST = defaultIsAndroidTest
    private val DEFAULT_IS_JVM_TEST = defaultIsTest && !DEFAULT_IS_ANDROID_TEST

    /**
     * @return true if running an Android test
     */
    var isAndroidTest = DEFAULT_IS_ANDROID_TEST
        private set

    /**
     * @return true if running in a JVM-only test environment
     */
    var isJvmTest = DEFAULT_IS_JVM_TEST
        private set

    /**
     * @return true if running in any test environment (both device and JVM-only return true)
     */
    var isTest = defaultIsTest
        private set

    // our testing automation framework provides helpers/extensions on top of UiAutomator
    // For the JVM tests of the same, this exists in the classpath but fails to instantiate as expected.
    private val defaultIsAndroidTest: Boolean
        get() = try {
            // our testing automation framework provides helpers/extensions on top of UiAutomator
            // For the JVM tests of the same, this exists in the classpath but fails to instantiate as expected.
            classExists("androidx.test.uiautomator.UiAutomatorInstrumentationTestRunner")
        } catch (error: NoClassDefFoundError) {
            false
        }

    @TestOnly
    fun reset() {
        isJvmTest = DEFAULT_IS_JVM_TEST
        isAndroidTest = DEFAULT_IS_ANDROID_TEST
        isTest = defaultIsTest
    }
}
