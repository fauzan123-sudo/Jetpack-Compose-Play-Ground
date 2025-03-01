package com.infinity.jepackcomposeplayground.ui.screen.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.infinity.jepackcomposeplayground.SetUpNavGraph
import com.infinity.jepackcomposeplayground.ui.screen.auth.AuthViewModel
import com.infinity.jepackcomposeplayground.ui.screen.navigation.AppNavigation
import com.infinity.jepackcomposeplayground.ui.screen.navigation.BottomNavigation
import com.infinity.jepackcomposeplayground.ui.theme.JetpackComposePlayGroundTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    private val splashViewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: AuthViewModel = viewModel()
            AppNavigation(viewModel)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposePlayGroundTheme {

    }
}