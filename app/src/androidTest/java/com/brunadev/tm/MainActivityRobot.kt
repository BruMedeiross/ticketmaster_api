package com.brunadev.tm

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import com.brunadev.tm.repository.Repository
import com.brunadev.tm.view.MainActivity


fun MainActivityTest.withMainActivity(
        func: MainActivityRobot.() -> Unit
    ) = MainActivityRobot().apply(func)


    class MainActivityRobot {

        private lateinit var repository: Repository

        fun launchEmptyActivity(){
            val intent = Intent(ApplicationProvider.getApplicationContext(), MainActivity::class.java)
            ActivityScenario.launch<MainActivity>(intent)
        }

        fun clickAtSearchView() = R.id.search_view.click()
        fun shimmerView() = Thread.sleep(1000)
        fun scrollLayout() = R.id.rvlist.click()

        infix fun actions (func: MainActivityRobot.() -> Unit) = this.apply(func)

        infix fun verify(func: LogonActivityResult.() -> Unit) = LogonActivityResult().apply(func)
    }

    class LogonActivityResult{

        fun  checkIsDisplayed(){
            R.id.search_view.isDisplayed()
            R.id.title_text.isDisplayed()
        }

        fun checkAppName(){
            "TM EVENTS".isTextDisplayed()
        }

        fun checkDetailsIsDisplayed(){
            R.id.event_title.isDisplayed()
            R.id.event_data.isDisplayed()
        }

}