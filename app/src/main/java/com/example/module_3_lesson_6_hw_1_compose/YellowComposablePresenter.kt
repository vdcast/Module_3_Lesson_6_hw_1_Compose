package com.example.module_3_lesson_6_hw_1_compose

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class YellowComposablePresenter : MainActivityContract.YellowComposableView {
    private val _mainActivityPresenter = MutableStateFlow<MainActivityContract.Presenter?>(null)
    val mainActivityPresenter: StateFlow<MainActivityContract.Presenter?> = _mainActivityPresenter.asStateFlow()

    override fun setPresenter(presenter: MainActivityContract.Presenter) {
        _mainActivityPresenter.value = presenter
    }

    override fun getPresenter(): MainActivityContract.Presenter? {
        return _mainActivityPresenter.value
    }
}