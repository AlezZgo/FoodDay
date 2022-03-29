package com.example.funday.presentation.menu

import MealAdapter
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.funday.core.BaseFragment
import com.example.funday.databinding.FragmentMenuBinding
import com.example.funday.domain.MealDomain
import javax.inject.Inject

class MenuFragment :
BaseFragment<FragmentMenuBinding, MenuViewModel>(FragmentMenuBinding::inflate) {

    @Inject
    lateinit var onTabClickHandler: OnTabClickHandler

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, viewModelFactory)[MenuViewModel::class.java]

        setUpAdapter()

        setUpTabBarClickListener()
    }

    private fun setUpTabBarClickListener() {
        binding.tabs.apply {
            setOnClickListener {
                viewModel.changeCategory(onTabClickHandler.handle(selectedTabPosition))
            }
        }
    }

    private fun setUpAdapter() {
        val adapter = MealAdapter()
        binding.menuRecyclerView.adapter = adapter
        viewModel.meals.observe(viewLifecycleOwner){
            adapter.submitList(
                it
            )
        }

    }

}