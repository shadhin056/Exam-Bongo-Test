package com.shadhin.test;

import com.shadhin.AnagramsFinder;
import org.junit.Assert;

import static org.hamcrest.CoreMatchers.is;

public class AnagramsTest {
    AnagramsFinder SUT;

    @org.junit.Before
    public void setUp() throws Exception {
        SUT = new AnagramsFinder();
    }

    @org.junit.Test
    public void checkAnagram_emptyString_falseWarningReturn() {
        boolean result = AnagramsFinder.checkAnagram("", "");
        Assert.assertThat(result, is(false));
    }

    @org.junit.Test
    public void checkAnagram_lengthNotSame_falseReturn() {
        boolean result = AnagramsFinder.checkAnagram("shadhin", "shadhinshadhin");
        Assert.assertThat(result, is(false));
    }

    @org.junit.Test
    public void checkAnagram_withSpaceValidCheck_trueReturn() {
        boolean result = AnagramsFinder.checkAnagram("shadhin", " s ha dh in");
        Assert.assertThat(result, is(true));
    }

    @org.junit.Test
    public void checkAnagram_withUppercaseLowercaseCheck_trueReturn() {
        boolean result = AnagramsFinder.checkAnagram("SHAdhin", " s ha dh in");
        Assert.assertThat(result, is(true));
    }
    @org.junit.Test
    public void checkAnagram_withLengthSameButNotValidCheck_falseReturn() {
        boolean result = AnagramsFinder.checkAnagram("SHAdhin", " h ha dh in");
        Assert.assertThat(result, is(false));
    }
    @org.junit.Test
    public void checkAnagram_withEmptyStringAndString_falseReturn() {
        boolean result = AnagramsFinder.checkAnagram("", " h ha dh in");
        Assert.assertThat(result, is(false));
    }
}