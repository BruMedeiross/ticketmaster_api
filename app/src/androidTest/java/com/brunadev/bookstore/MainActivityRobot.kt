package com.brunadev.bookstore

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import com.brunadev.bookstore.repository.BookstoreRepository
import com.brunadev.bookstore.view.MainActivity

fun MainActivityTest.withMainActivity(
        func: MainActivityRobot.() -> Unit
    ) = MainActivityRobot().apply(func)


    class MainActivityRobot {

        private lateinit var repository: BookstoreRepository

        fun launchEmptyActivity(){
            val intent = Intent(ApplicationProvider.getApplicationContext(), MainActivity::class.java)
            ActivityScenario.launch<MainActivity>(intent)
        }

        fun clickAtFabButton() = R.id.fab_dialog.click()

        fun scrollLayout() = R.id.rvlist.fastSwipeUp()

        infix fun actions (func: MainActivityRobot.() -> Unit) = this.apply(func)

        infix fun verify(func: LogonActivityResult.() -> Unit) = LogonActivityResult().apply(func)
    }

    class LogonActivityResult{

        fun  checkIsDisplayed(){
            R.id.fab_dialog.isDisplayed()
            R.id.title_text.isDisplayed()
            R.id.shimmer_list.isDisplayed()
            R.id.layout_main.isDisplayed()
        }

        fun checkAppName(){
            "BOOKSTORE".isTextDisplayed()
        }

}