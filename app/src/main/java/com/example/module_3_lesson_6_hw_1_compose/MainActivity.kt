package com.example.module_3_lesson_6_hw_1_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.module_3_lesson_6_hw_1_compose.ui.theme.Module_3_Lesson_6_hw_1_ComposeTheme
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue

class MainActivity : ComponentActivity(), MainActivityContract.MainView {

    private val mainActivityPresenter = MainActivityPresenter(this)
    private var currentComposable by mutableStateOf<(@Composable () -> Unit)?>(null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Module_3_Lesson_6_hw_1_ComposeTheme {
                AppScreen(
                    currentComposable = currentComposable,
                    onBlueClick = { mainActivityPresenter.showBlueComposable() },
                    onGreenClick = { mainActivityPresenter.showGreenComposable() },
                    onRedClick = { mainActivityPresenter.showRedComposable() },
                    onYellowClick = { mainActivityPresenter.showYellowComposable() }
                )
            }
        }
    }

    override fun setComposable(composable: @Composable () -> Unit) {
        currentComposable = composable
    }

    override fun updateTopMenu() {
        TODO("Not yet implemented")
    }
}

@Composable
fun AppScreen(
    currentComposable: (@Composable () -> Unit)?,
    onBlueClick: () -> Unit,
    onGreenClick: () -> Unit,
    onRedClick: () -> Unit,
    onYellowClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .background(Color.DarkGray),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                modifier = Modifier.fillMaxWidth(0.2f),
                onClick = onBlueClick,
                colors = ButtonDefaults.buttonColors(Color.Blue)
            ) { }
            Button(
                modifier = Modifier.fillMaxWidth(0.25f),
                onClick = onGreenClick,
                colors = ButtonDefaults.buttonColors(Color.Green)
            ) { }
            Button(
                modifier = Modifier.fillMaxWidth(0.35f),
                onClick = onRedClick,
                colors = ButtonDefaults.buttonColors(Color.Red)
            ) { }
            Button(
                modifier = Modifier.fillMaxWidth(0.5f),
                onClick = onYellowClick,
                colors = ButtonDefaults.buttonColors(Color.Yellow)
            ) { }
        }
        currentComposable?.invoke()
    }
}

fun getBlueComposable(presenter: BlueComposablePresenter): @Composable () -> Unit {
    return {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Blue),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.clickable {
                    presenter.getPresenter()?.showGreenComposable()
                },
                text = stringResource(id = R.string.blue_to_green),
                color = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier.clickable {
                    presenter.getPresenter()?.showYellowComposable()
                },
                text = stringResource(id = R.string.blue_to_yellow),
                color = Color.White
            )
        }
    }
}

fun getGreenComposable(presenter: GreenComposablePresenter): @Composable () -> Unit {
    return {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Green),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.clickable {
                    presenter.getPresenter()?.showRedComposable()
                },
                text = stringResource(id = R.string.green_to_red)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier.clickable {
                    presenter.getPresenter()?.showBlueComposable()
                },
                text = stringResource(id = R.string.green_to_blue)
            )
        }
    }
}

fun getRedComposable(presenter: RedComposablePresenter): @Composable () -> Unit {
    return {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Red),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.clickable {
                    presenter.getPresenter()?.showYellowComposable()
                },
                text = stringResource(id = R.string.red_to_yellow)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier.clickable {
                    presenter.getPresenter()?.showGreenComposable()
                },
                text = stringResource(id = R.string.red_to_green)
            )
        }
    }
}

fun getYellowComposable(presenter: YellowComposablePresenter): @Composable () -> Unit {
    return {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Yellow),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.clickable {
                    presenter.getPresenter()?.showBlueComposable()
                },
                text = stringResource(id = R.string.yellow_to_blue)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier.clickable {
                    presenter.getPresenter()?.showRedComposable()
                },
                text = stringResource(id = R.string.yellow_to_red)
            )
        }
    }
}