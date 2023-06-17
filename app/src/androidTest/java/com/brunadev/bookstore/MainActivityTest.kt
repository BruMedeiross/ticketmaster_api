package com.brunadev.bookstore

import org.junit.Test

class MainActivityTest {

    @Test
    fun givenHomeActivityWhenClickButtonThenCheckDisplayedItens() {
        withMainActivity {
            launchEmptyActivity()
        } actions {
            clickAtFabButton()
        } verify {
            checkIsDisplayed()
            checkAppName()
        }
    }
}