package com.adiputrastwn.viatrip.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.adiputrastwn.viatrip.databinding.FragmentHomeBinding
import com.adiputrastwn.viatrip.models.Highlight
import com.adiputrastwn.viatrip.recycler.adapter.CategoryRecyclerAdapter
import com.adiputrastwn.viatrip.recycler.adapter.HighlightPagerAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()

    private var highlightPagerAdapter = HighlightPagerAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            viewPagerHighlight.apply {
                adapter = highlightPagerAdapter
            }
            recyclerViewCategories.apply {
                layoutManager =
                    GridLayoutManager(requireContext(), 2, GridLayoutManager.HORIZONTAL, false)
                adapter = CategoryRecyclerAdapter()
            }
        }

        lifecycleScope.launchWhenResumed {
            viewModel.uiState.collect { uiState ->
                binding.swipeRefreshLayout.isRefreshing =
                    uiState is HomeViewModel.HomeUiState.Loading
                when (uiState) {
                    is HomeViewModel.HomeUiState.HighlightList -> {
                        setHighlights(uiState.highlights)
                    }
                    is HomeViewModel.HomeUiState.Error -> {

                    }
                    else -> {

                    }
                }
            }
        }
    }

    private fun setHighlights(highlights: List<Highlight>) {
        highlightPagerAdapter.setHighlights(highlights)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}