package com.example.module_3_lesson_6_hw_1_compose

class MainActivityPresenter(private val mainView: MainActivityContract.MainView) : MainActivityContract.Presenter {
    override fun showBlueComposable() {
        val blueComposablePresenter = BlueComposablePresenter()
        blueComposablePresenter.setPresenter(this)

        val composable = getBlueComposable(blueComposablePresenter)
        mainView.setComposable(composable)
    }

    override fun showGreenComposable() {
        val greenComposablePresenter = GreenComposablePresenter()
        greenComposablePresenter.setPresenter(this)

        val composable = getGreenComposable(greenComposablePresenter)
        mainView.setComposable(composable)
    }

    override fun showRedComposable() {
        val redComposablePresenter = RedComposablePresenter()
        redComposablePresenter.setPresenter(this)

        val composable = getRedComposable(redComposablePresenter)
        mainView.setComposable(composable)
    }

    override fun showYellowComposable() {
        val yellowComposablePresenter = YellowComposablePresenter()
        yellowComposablePresenter.setPresenter(this)

        val composable = getYellowComposable(yellowComposablePresenter)
        mainView.setComposable(composable)
    }

    override fun getDbData() {
        TODO("Not yet implemented")
    }

    override fun getServerData() {
        TODO("Not yet implemented")
    }
}