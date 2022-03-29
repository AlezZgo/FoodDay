package com.example.funday.presentation.menu.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.funday.domain.MealDomain

class MealDiffCallback : DiffUtil.ItemCallback<MealDomain>() {

    override fun areItemsTheSame(oldItem: MealDomain, newItem: MealDomain): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: MealDomain, newItem: MealDomain): Boolean {
        return oldItem == newItem
    }
}