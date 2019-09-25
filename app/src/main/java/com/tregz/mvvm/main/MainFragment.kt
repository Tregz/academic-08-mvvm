package com.tregz.mvvm.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tregz.mvvm.R
import com.tregz.mvvm.core.date.DateUtil
import com.tregz.mvvm.data.DataApple
import com.tregz.mvvm.list.ListApple
import com.tregz.mvvm.view.ViewApple
import java.util.*

class MainFragment : Fragment() {

    private lateinit var viewModel: MainBackend
    private var listApple: ListApple? = null

    private val apple : DataApple
        get() = DataApple(Date()).apply {
            listApple?.add(this)
            this.color = R.color.colorPrimary
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val apple1 = DataApple(Date())  // today
        apple1.color = R.color.colorAccent
        listApple = (activity as MainActivity?)?.let { ListApple(it) }
        listApple?.add(apple1)
        listApple?.add(apple1)
        Log.i(TAG, "La pomme 1 est comestible? " + apple1.edible())
        Log.i(TAG, "La pomme 1 est de couleur: " + apple1.color)

        val apple2 = DataApple(DateUtil.addMonth(Date(), -1)) // last month
        listApple?.add(apple2)
        apple2.color = android.R.color.white
        Log.i(TAG, "La pomme 2 est comestible? " + apple2.edible())
        Log.i(TAG, "La pomme 2 est de couleur: " + apple2.color)


        val apple3 = DataApple(null)
        listApple?.add(apple3)
        apple3.color = R.color.colorPrimary
        Log.i(TAG, "La pomme 3 est comestible? " + apple3.edible())
        Log.i(TAG, "La pomme 3 est de couleur: " + apple3.color)

        val apple4 = apple
        Log.i(TAG, "La pomme 4 est comestible? " + apple4.edible())
        Log.i(TAG, "La pomme 4 est de couleur: " + apple4.color)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainBackend::class.java)
        // TODO: Use the ViewModel
    }

    companion object {
        fun newInstance() = MainFragment()
        private val TAG: String = MainFragment::class.java.simpleName
    }
}
