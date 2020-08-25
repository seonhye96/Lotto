package com.naesseuapp.lotto

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    var mContext = this

    abstract fun setupEvents()
    abstract fun setupValues()
}