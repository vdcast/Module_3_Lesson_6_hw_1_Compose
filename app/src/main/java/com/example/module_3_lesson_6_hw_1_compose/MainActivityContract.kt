package com.example.module_3_lesson_6_hw_1_compose

import androidx.compose.runtime.Composable

interface MainActivityContract {
    interface MainView {
        fun setComposable(composable: @Composable () -> Unit)
        fun updateTopMenu()
    }

    interface BlueComposableView {
        fun setPresenter(presenter: Presenter)
        fun getPresenter(): Presenter?
    }

    interface GreenComposableView {
        fun setPresenter(presenter: Presenter)
        fun getPresenter(): Presenter?
    }

    interface RedComposableView {
        fun setPresenter(presenter: Presenter)
        fun getPresenter(): Presenter?
    }

    interface YellowComposableView {
        fun setPresenter(presenter: Presenter)
        fun getPresenter(): Presenter?
    }

    interface Presenter {
        fun showBlueComposable()
        fun showGreenComposable()
        fun showRedComposable()
        fun showYellowComposable()
        fun getDbData()
        fun getServerData()
    }
}