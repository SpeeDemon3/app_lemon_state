package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            LemonadeTheme {
                LemonadeApp()
            }

        }
    }
}

@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {

    var currentStep by remember {
        mutableStateOf(1)
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when (currentStep) {
            1 -> {
                Column (horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(text = stringResource(R.string.one))
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(painter = painterResource(R.drawable.lemon_tree),
                        contentDescription = stringResource(R.string.desc1_lemon_tree),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable {
                                currentStep = 2
                            }
                        )

                }
            }

            2 -> {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(text = stringResource(R.string.two))
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(painter = painterResource(R.drawable.lemon_squeeze),
                        contentDescription = stringResource(R.string.desc2_lemon_squeeze),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable() {
                                    currentStep = 3
                            }
                    )
                }
            }

            3 -> {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(text = stringResource(R.string.three))
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(painter = painterResource(R.drawable.lemon_drink),
                        contentDescription = stringResource(R.string.desc3_lemon_drink),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable {
                                currentStep = 4
                            }
                    )
                }
            }

            else -> {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(text = stringResource(R.string.four))
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(painter = painterResource(R.drawable.lemon_restart),
                        contentDescription = stringResource(R.string.desc4_emoty_glass),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable {
                                currentStep = 1
                            }
                    )
                }
            }

        }
    }

}


@Preview
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}