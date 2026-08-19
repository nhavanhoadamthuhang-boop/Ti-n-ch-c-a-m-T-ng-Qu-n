package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.model.AppTab
import com.example.ui.MainUiState
import com.example.ui.MainViewModel
import com.example.ui.components.AppBottomNav
import com.example.ui.components.AppTopBar
import com.example.ui.components.NotificationToastBanner
import com.example.ui.screens.AboutAndSettingsScreen
import com.example.ui.screens.GameToolsScreen
import com.example.ui.screens.MediaAndSimScreen
import com.example.ui.screens.VietnamKnowledgeScreen
import com.example.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val uiState by viewModel.uiState.collectAsStateWithLifecycle()
                MainAppScreen(
                    uiState = uiState,
                    viewModel = viewModel
                )
            }
        }
    }
}

@Composable
fun MainAppScreen(
    uiState: MainUiState,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            AppTopBar(
                isPremium = uiState.isPremium,
                dailyLimitRemaining = uiState.dailyLimitRemaining,
                maxDailyLimit = uiState.maxDailyLimit,
                onToggleVip = { viewModel.togglePremium() }
            )
        },
        bottomBar = {
            AppBottomNav(
                currentTab = uiState.currentTab,
                onTabSelected = { viewModel.setTab(it) }
            )
        },
        containerColor = MaterialTheme.colorScheme.background,
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            NotificationToastBanner(message = uiState.lastNotificationMessage)

            Crossfade(
                targetState = uiState.currentTab,
                label = "TabCrossfade",
                modifier = Modifier.weight(1f)
            ) { tab ->
                when (tab) {
                    AppTab.GAME_CREATOR -> GameToolsScreen(uiState = uiState, viewModel = viewModel)
                    AppTab.VIETNAM_KNOWLEDGE -> VietnamKnowledgeScreen(uiState = uiState, viewModel = viewModel)
                    AppTab.MEDIA_SIMULATOR -> MediaAndSimScreen(uiState = uiState, viewModel = viewModel)
                    AppTab.PROJECT_INFO -> AboutAndSettingsScreen(uiState = uiState, viewModel = viewModel)
                }
            }
        }
    }
}
