package com.example.usupbekov_adilet_5_2hw.ui.result

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.usupbekov_adilet_5_2hw.App
import com.example.usupbekov_adilet_5_2hw.R
import com.example.usupbekov_adilet_5_2hw.databinding.FragmentResultBinding
import com.example.usupbekov_adilet_5_2hw.simpleModels.Love
import com.example.usupbekov_adilet_5_2hw.ui.calculator.CalculatorFragment
import kotlinx.coroutines.NonDisposableHandle.parent


class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater , container ,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initNavigations()
        setArgs()
        initSimpleClicks()
        save()
    }

    private fun save() {
        arguments?.apply {
            val data = Love(
                firstName = getString(CalculatorFragment.KEY_FOR_FNAME),
                secondName = getString(CalculatorFragment.KEY_FOR_SNAME),
                percentage = getString(CalculatorFragment.KEY_FOR_PERC)
            )
            App.db.loveDao().insert(data)
        }
    }

    private fun initSimpleClicks() {
        binding.apply {
            btnTryAgain.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    private fun setArgs() {
        binding.apply {
            tvFirstName.text = arguments?.getString(CalculatorFragment.KEY_FOR_FNAME)
            tvSecondName.text = arguments?.getString(CalculatorFragment.KEY_FOR_SNAME)
            tvResult.text = arguments?.getString(CalculatorFragment.KEY_FOR_RESULT)
            tvPercentage.text = arguments?.getString(CalculatorFragment.KEY_FOR_PERC) + "%"
        }
    }

    private fun initNavigations() {
        binding.apply {
            btnNavigateHome.setOnClickListener {
                findNavController().navigateUp()
            }
            btnNavigateHistory.setOnClickListener {
                findNavController().navigate(R.id.historyFragment)
            }
        }
    }
    }
