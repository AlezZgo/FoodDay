package com.example.funday.presentation.menu

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.funday.core.BaseFragment
import com.example.funday.databinding.FragmentMenuBinding

class MenuFragment :
BaseFragment<FragmentMenuBinding, MenuViewModel>(FragmentMenuBinding::inflate) {

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, viewModelFactory)[MenuViewModel::class.java]

    }

}