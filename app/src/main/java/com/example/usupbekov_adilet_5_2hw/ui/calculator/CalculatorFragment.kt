package com.example.usupbekov_adilet_5_2hw.ui.calculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.usupbekov_adilet_5_2hw.CalcLoveViewModel
import com.example.usupbekov_adilet_5_2hw.R
import com.example.usupbekov_adilet_5_2hw.databinding.FragmentCalculatorBinding


class CalculatorFragment : Fragment() {

    private lateinit var binding: FragmentCalculatorBinding
    val viewModel: CalcLoveViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalculatorBinding.inflate(inflater , container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initNavigations()
        initClickListeners()
    }

    private fun initClickListeners() {
        binding.apply {
            btnCalculate.setOnClickListener {
                if (etFirstName.text!!.isEmpty()) {
                    etFirstName.error = "field for first name is empty(("
                } else if (etSecondName.text!!.isEmpty()) {
                    etSecondName.error = "field for second name is empty(("
                } else {
                    viewModel.liveLove(etFirstName.text.toString(), etSecondName.text.toString()).observe(viewLifecycleOwner, Observer {
                        findNavController().navigate(
                            R.id.resultFragment,
                            bundleOf(
                                KEY_FOR_FNAME to it.firstName,
                                KEY_FOR_SNAME to it.secondName,
                                KEY_FOR_PERC to it.percentage,
                                KEY_FOR_RESULT to it.result
                            )
                        )
                    })
                }
            }
        }
    }

    private fun initNavigations() {
        binding.apply {
            btnNavigateHome.setOnClickListener {
                findNavController().navigate(R.id.calculatorFragment)
            }
            btnNavigateHistory.setOnClickListener {
                findNavController().navigate(R.id.historyFragment)
            }

        }

    }
    companion object {
        const val KEY_FOR_FNAME = "fname"
        const val KEY_FOR_SNAME = "sname"
        const val KEY_FOR_PERC = "1000%"
        const val KEY_FOR_RESULT = "result"
    }
}


