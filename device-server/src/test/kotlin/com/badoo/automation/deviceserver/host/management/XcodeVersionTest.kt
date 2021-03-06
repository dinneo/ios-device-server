package com.badoo.automation.deviceserver.host.management

import org.junit.Assert.*
import org.junit.Test

class XcodeVersionTest {
    @Test
    fun shouldParseXcodeBuildOutput() {
        val out = "Xcode 9.2\nBuild version 9C40b"

        val version = XcodeVersion.fromXcodeBuildOutput(out)

        assertEquals(9, version.major)
        assertEquals(2, version.minor)
    }

    @Test
    fun shouldParseXcodeBuildOutputWithPatchVersion() {
        val out = "Xcode 9.2.1\nBuild version 9C40b"

        val version = XcodeVersion.fromXcodeBuildOutput(out)

        assertEquals(9, version.major)
        assertEquals(2, version.minor)
    }

    @Test
    fun shouldCompareToLess() {
        val v1 = XcodeVersion(9, 1)
        val v2 = XcodeVersion(9, 2)

        assert(v1 < v2)
    }

    @Test
    fun shouldCompareToEqual() {
        val v1 = XcodeVersion(9, 1)
        val v2 = XcodeVersion(9, 1)

        assert(v1 == v2)
    }

    @Test
    fun shouldCompareToGreater() {
        val v1 = XcodeVersion(9, 1)
        val v2 = XcodeVersion(9, 0)

        assert(v1 > v2)
    }
}
