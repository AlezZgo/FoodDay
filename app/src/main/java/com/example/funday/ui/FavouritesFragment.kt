package com.example.funday.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.funday.databinding.FragmentJokesBinding
import com.example.funday.databinding.FragmentProfileBinding

class FavouritesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return FragmentProfileBinding.inflate(inflater,container,false).root
    }

}