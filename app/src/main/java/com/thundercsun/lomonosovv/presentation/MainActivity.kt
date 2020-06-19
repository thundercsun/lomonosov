package com.thundercsun.lomonosovv.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.thundercsun.lomonosovv.R
import com.thundercsun.lomonosovv.presentation.base.view.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}