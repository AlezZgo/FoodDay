package com.example.funday.presentation.menu

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.funday.core.BaseFragment
import com.example.funday.databinding.FragmentMenuBinding
import com.example.funday.domain.MealDomain
import com.example.funday.presentation.menu.adapter.MealAdapter

class MenuFragment :
    BaseFragment<FragmentMenuBinding, MenuViewModel>(FragmentMenuBinding::inflate) {

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, viewModelFactory)[MenuViewModel::class.java]

        setUpAdapter()
    }

    private fun setUpAdapter() {
        val adapter = MealAdapter()
        binding.menuRecyclerView.adapter = adapter
        adapter.submitList(
            listOf(
                MealDomain("Beef",
                    "https://www.themealdb.com//images//media//meals//uvuyxu1503067369.jpg"),
                MealDomain("Sea",
                    "https://www.themealdb.com/images/media/meals/xxrxux1503070723.jpg"),
                MealDomain("Beef",
                    "https://www.themealdb.com//images//media//meals//uvuyxu1503067369.jpg"),
                MealDomain("Beef",
                    "https://www.themealdb.com//images//media//meals//uvuyxu1503067369.jpg"),
                MealDomain("Beef",
                    "https://www.themealdb.com//images//media//meals//uvuyxu1503067369.jpg"),
                MealDomain("Beef",
                    "https://www.themealdb.com//images//media//meals//uvuyxu1503067369.jpg"),
                MealDomain("Beef",
                    "https://www.themealdb.com//images//media//meals//uvuyxu1503067369.jpg"),
                MealDomain("Beef",
                    "https://www.themealdb.com//images//media//meals//uvuyxu1503067369.jpg"),
                MealDomain("Beef",
                    "https://www.themealdb.com//images//media//meals//uvuyxu1503067369.jpg"),
                MealDomain("Beef",
                    "https://www.themealdb.com//images//media//meals//uvuyxu1503067369.jpg"),
                MealDomain("Beef",
                    "https://www.themealdb.com//images//media//meals//uvuyxu1503067369.jpg"),
                MealDomain("Beef",
                    "https://www.themealdb.com//images//media//meals//uvuyxu1503067369.jpg"),
            )
        )
    }

}