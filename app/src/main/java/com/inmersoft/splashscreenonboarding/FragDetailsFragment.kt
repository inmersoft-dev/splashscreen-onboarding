package com.inmersoft.splashscreenonboarding

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.inmersoft.splashscreenonboarding.databinding.FragmentFlagDescriptionBinding


class FragDetailsFragment : Fragment(R.layout.fragment_flag_description) {

    private lateinit var _binding: FragmentFlagDescriptionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val animation = TransitionInflater.from(requireContext()).inflateTransition(
            android.R.transition.move
        )

        sharedElementEnterTransition = animation
        sharedElementReturnTransition = animation
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFlagDescriptionBinding.inflate(layoutInflater, container, false)

        _binding.imageViewFlag.setOnClickListener {
            val extra = FragmentNavigatorExtras(_binding.imageViewFlag to "small_flag")
            findNavController().navigate(
                R.id.action_fragDetailsFragment_to_homeFragment, null, null, extra
            )
        }

        return _binding.root
    }


}