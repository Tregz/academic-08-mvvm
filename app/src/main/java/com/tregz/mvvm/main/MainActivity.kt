package com.tregz.mvvm.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tregz.mvvm.R
import com.tregz.mvvm.list.ListApple
import com.tregz.mvvm.view.ViewApple

class MainActivity : AppCompatActivity(), ViewApple {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

    override fun onAppleCreated(listSize: Int, setSize:Int) {
        Log.i(TAG, "Pomme ajoutée")
        Log.i(TAG, "Taille de la liste: $listSize")
        Log.i(TAG, "Taille de l'ensemble: $setSize")
    }

    companion object {
        private val TAG: String = MainActivity::class.java.simpleName
    }
}
