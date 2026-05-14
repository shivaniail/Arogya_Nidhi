//package com.example.arogyanidhi
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.material3.CircularProgressIndicator
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.hilt.navigation.compose.hiltViewModel
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import androidx.navigation.toRoute
//import com.example.arogyanidhi.ui.auth.AuthViewModel
//import com.example.arogyanidhi.ui.auth.LoginScreen
//import com.example.arogyanidhi.ui.auth.RegisterScreen
//import com.example.arogyanidhi.ui.dashboard.DashboardScreen
//import com.example.arogyanidhi.ui.dashboard.DashboardViewModel
//import com.example.arogyanidhi.ui.eligibility.EligibilityScreen
//import com.example.arogyanidhi.ui.eligibility.EligibilityViewModel
//import com.example.arogyanidhi.ui.hospitals.HospitalListScreen
//import com.example.arogyanidhi.ui.hospitals.HospitalViewModel
//import com.example.arogyanidhi.ui.profile.ProfileScreen
//import com.example.arogyanidhi.ui.profile.ProfileViewModel
//import com.example.arogyanidhi.ui.settings.SettingsScreen
//import com.example.arogyanidhi.ui.settings.SettingsViewModel
//import com.example.arogyanidhi.ui.schemes.SchemeDetailScreen
//import com.example.arogyanidhi.ui.schemes.SchemeDetailViewModel
//import com.example.arogyanidhi.ui.schemes.SchemeListScreen
//import com.example.arogyanidhi.ui.schemes.SchemeViewModel
//import com.example.arogyanidhi.ui.onboarding.OnboardingScreen
//import com.example.arogyanidhi.ui.onboarding.OnboardingViewModel
//import com.example.arogyanidhi.ui.splash.SplashViewModel
//import com.example.arogyanidhi.ui.navigation.Screen
//import com.example.arogyanidhi.ui.theme.ArogyaNidhiTheme
//import dagger.hilt.android.AndroidEntryPoint
//
//@AndroidEntryPoint
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//
//        setContent {
//            ArogyaNidhiTheme {
//                ArogyaNidhiMain()
//            }
//        }
//    }
//}
//@Composable
//fun ArogyaNidhiMain() {
//
//    val navController = rememberNavController()
//
//    // ✅ SharedPreferences (to remember onboarding)
//    val context = androidx.compose.ui.platform.LocalContext.current
//    val prefs = context.getSharedPreferences("app_prefs", android.content.Context.MODE_PRIVATE)
//
//    val isOnboardingCompleted = prefs.getBoolean("onboarding_completed", false)
//
//    NavHost(
//        navController = navController,
//        startDestination = if (isOnboardingCompleted) Screen.Login else Screen.Onboarding
//    ) {
//
//        // 🔹 ONBOARDING
//        composable<Screen.Onboarding> {
//            val onboardingViewModel: OnboardingViewModel = hiltViewModel()
//
//            OnboardingScreen(
//                onContinue = {
//
//                    // ✅ SAVE ONBOARDING COMPLETED
//                    prefs.edit()
//                        .putBoolean("onboarding_completed", true)
//                        .apply()
//
//                    onboardingViewModel.completeOnboarding()
//
//                    navController.navigate(Screen.Login) {
//                        popUpTo(Screen.Onboarding) { inclusive = true }
//                    }
//                }
//            )
//        }
//
//        // 🔹 LOGIN
//        composable<Screen.Login> {
//            val authViewModel: AuthViewModel = hiltViewModel()
//
//            LoginScreen(
//                viewModel = authViewModel,
//                onNavigateToRegister = {
//                    navController.navigate(Screen.Register)
//                },
//                onLoginSuccess = {
//                    navController.navigate(Screen.Dashboard) {
//                        popUpTo(Screen.Login) { inclusive = true }
//                    }
//                }
//            )
//        }
//
//        // 🔹 REGISTER
//        composable<Screen.Register> {
//            val authViewModel: AuthViewModel = hiltViewModel()
//
//            RegisterScreen(
//                viewModel = authViewModel,
//                onNavigateToLogin = {
//                    navController.popBackStack()
//                },
//                onRegisterSuccess = {
//                    navController.navigate(Screen.Dashboard) {
//                        popUpTo(Screen.Register) { inclusive = true }
//                    }
//                }
//            )
//        }
//
//        // 🔹 DASHBOARD
//        composable<Screen.Dashboard> {
//            val dashboardViewModel: DashboardViewModel = hiltViewModel()
//
//            DashboardScreen(
//                viewModel = dashboardViewModel,
//                onNavigateToEligibility = { navController.navigate(Screen.EligibilityChecker) },
//                onNavigateToSchemes = { navController.navigate(Screen.Schemes) },
//                onNavigateToHospitals = { navController.navigate(Screen.Hospitals) },
//                onNavigateToProfile = { navController.navigate(Screen.Profile) },
//                onNavigateToSettings = { navController.navigate(Screen.Settings) }
//            )
//        }
//
//        // 🔹 SETTINGS
//        composable<Screen.Settings> {
//            val settingsViewModel: SettingsViewModel = hiltViewModel()
//
//            SettingsScreen(
//                viewModel = settingsViewModel,
//                onNavigateBack = { navController.popBackStack() },
//                onLogout = {
//                    navController.navigate(Screen.Login) {
//                        popUpTo(0) { inclusive = true }
//                    }
//                }
//            )
//        }
//
//        // 🔹 ELIGIBILITY
//        composable<Screen.EligibilityChecker> {
//            val eligibilityViewModel: EligibilityViewModel = hiltViewModel()
//
//            EligibilityScreen(
//                viewModel = eligibilityViewModel,
//                onNavigateBack = { navController.popBackStack() }
//            )
//        }
//
//        // 🔹 SCHEMES
//        composable<Screen.Schemes> {
//            val schemeViewModel: SchemeViewModel = hiltViewModel()
//
//            SchemeListScreen(
//                viewModel = schemeViewModel,
//                onNavigateBack = { navController.popBackStack() },
//                onSchemeClick = { schemeId ->
//                    navController.navigate(Screen.SchemeDetail(schemeId))
//                }
//            )
//        }
//
//        // 🔹 SCHEME DETAIL
//        composable<Screen.SchemeDetail> { backStackEntry ->
//            val route: Screen.SchemeDetail = backStackEntry.toRoute()
//            val viewModel: SchemeDetailViewModel = hiltViewModel()
//
//            SchemeDetailScreen(
//                schemeId = route.schemeId,
//                viewModel = viewModel,
//                onNavigateBack = { navController.popBackStack() }
//            )
//        }
//
//        // 🔹 HOSPITALS
//        composable<Screen.Hospitals> {
//            val hospitalViewModel: HospitalViewModel = hiltViewModel()
//
//            HospitalListScreen(
//                viewModel = hospitalViewModel,
//                onNavigateBack = { navController.popBackStack() }
//            )
//        }
//
//        // 🔹 PROFILE
//        composable<Screen.Profile> {
//            val profileViewModel: ProfileViewModel = hiltViewModel()
//
//            ProfileScreen(
//                viewModel = profileViewModel,
//                onNavigateBack = { navController.popBackStack() }
//            )
//        }
//    }
//}
////@Composable
////fun ArogyaNidhiMain() {
////
////    val navController = rememberNavController()
////
////    NavHost(
////        navController = navController,
////        startDestination = Screen.Onboarding
////    ) {
////
////        // 🔹 ONBOARDING
////        composable<Screen.Onboarding> {
////            val onboardingViewModel: OnboardingViewModel = hiltViewModel()
////
////            OnboardingScreen(
////                onContinue = {
////                    onboardingViewModel.completeOnboarding()
////                    navController.navigate(Screen.Login)
////                }
////            )
////        }
////
////        // 🔹 LOGIN
////        composable<Screen.Login> {
////            val authViewModel: AuthViewModel = hiltViewModel()
////
////            LoginScreen(
////                viewModel = authViewModel,
////                onNavigateToRegister = {
////                    navController.navigate(Screen.Register)
////                },
////                onLoginSuccess = {
////                    navController.navigate(Screen.Dashboard) {
////                        popUpTo(Screen.Login) { inclusive = true }
////                    }
////                }
////            )
////        }
////
////        // 🔹 REGISTER
////        composable<Screen.Register> {
////            val authViewModel: AuthViewModel = hiltViewModel()
////
////            RegisterScreen(
////                viewModel = authViewModel,
////                onNavigateToLogin = {
////                    navController.popBackStack()
////                },
////                onRegisterSuccess = {
////                    navController.navigate(Screen.Dashboard) {
////                        popUpTo(Screen.Register) { inclusive = true }
////                    }
////                }
////            )
////        }
////
////        // 🔹 DASHBOARD
////        composable<Screen.Dashboard> {
////            val dashboardViewModel: DashboardViewModel = hiltViewModel()
////
////            DashboardScreen(
////                viewModel = dashboardViewModel,
////                onNavigateToEligibility = { navController.navigate(Screen.EligibilityChecker) },
////                onNavigateToSchemes = { navController.navigate(Screen.Schemes) },
////                onNavigateToHospitals = { navController.navigate(Screen.Hospitals) },
////                onNavigateToProfile = { navController.navigate(Screen.Profile) },
////                onNavigateToSettings = { navController.navigate(Screen.Settings) }
////            )
////        }
////
////        // 🔹 SETTINGS
////        composable<Screen.Settings> {
////            val settingsViewModel: SettingsViewModel = hiltViewModel()
////
////            SettingsScreen(
////                viewModel = settingsViewModel,
////                onNavigateBack = { navController.popBackStack() },
////                onLogout = {
////                    navController.navigate(Screen.Login) {
////                        popUpTo(0) { inclusive = true }
////                    }
////                }
////            )
////        }
////
////        // 🔹 ELIGIBILITY
////        composable<Screen.EligibilityChecker> {
////            val eligibilityViewModel: EligibilityViewModel = hiltViewModel()
////
////            EligibilityScreen(
////                viewModel = eligibilityViewModel,
////                onNavigateBack = { navController.popBackStack() }
////            )
////        }
////
////        // 🔹 SCHEMES
////        composable<Screen.Schemes> {
////            val schemeViewModel: SchemeViewModel = hiltViewModel()
////
////            SchemeListScreen(
////                viewModel = schemeViewModel,
////                onNavigateBack = { navController.popBackStack() },
////                onSchemeClick = { schemeId ->
////                    navController.navigate(Screen.SchemeDetail(schemeId))
////                }
////            )
////        }
////
////        // 🔹 SCHEME DETAIL
////        composable<Screen.SchemeDetail> { backStackEntry ->
////            val route: Screen.SchemeDetail = backStackEntry.toRoute()
////            val viewModel: SchemeDetailViewModel = hiltViewModel()
////
////            SchemeDetailScreen(
////                schemeId = route.schemeId,
////                viewModel = viewModel,
////                onNavigateBack = { navController.popBackStack() }
////            )
////        }
////
////        // 🔹 HOSPITALS
////        composable<Screen.Hospitals> {
////            val hospitalViewModel: HospitalViewModel = hiltViewModel()
////
////            HospitalListScreen(
////                viewModel = hospitalViewModel,
////                onNavigateBack = { navController.popBackStack() }
////            )
////        }
////
////        // 🔹 PROFILE
////        composable<Screen.Profile> {
////            val profileViewModel: ProfileViewModel = hiltViewModel()
////
////            ProfileScreen(
////                viewModel = profileViewModel,
////                onNavigateBack = { navController.popBackStack() }
////            )
////        }
////    }
////}
package com.example.arogyanidhi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.arogyanidhi.ui.auth.AuthViewModel
import com.example.arogyanidhi.ui.auth.LoginScreen
import com.example.arogyanidhi.ui.auth.RegisterScreen
import com.example.arogyanidhi.ui.dashboard.DashboardScreen
import com.example.arogyanidhi.ui.dashboard.DashboardViewModel
import com.example.arogyanidhi.ui.eligibility.EligibilityScreen
import com.example.arogyanidhi.ui.eligibility.EligibilityViewModel
import com.example.arogyanidhi.ui.hospitals.HospitalListScreen
import com.example.arogyanidhi.ui.hospitals.HospitalViewModel
import com.example.arogyanidhi.ui.profile.ProfileScreen
import com.example.arogyanidhi.ui.profile.ProfileViewModel
import com.example.arogyanidhi.ui.settings.SettingsScreen
import com.example.arogyanidhi.ui.settings.SettingsViewModel
import com.example.arogyanidhi.ui.schemes.SchemeDetailScreen
import com.example.arogyanidhi.ui.schemes.SchemeDetailViewModel
import com.example.arogyanidhi.ui.schemes.SchemeListScreen
import com.example.arogyanidhi.ui.schemes.SchemeViewModel
import com.example.arogyanidhi.ui.onboarding.OnboardingScreen
import com.example.arogyanidhi.ui.onboarding.OnboardingViewModel
import com.example.arogyanidhi.ui.splash.SplashViewModel
import com.example.arogyanidhi.ui.navigation.Screen
import com.example.arogyanidhi.ui.theme.ArogyaNidhiTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArogyaNidhiTheme {
                ArogyaNidhiMain()
            }
        }
    }
}

@Composable
fun ArogyaNidhiMain() {

    val navController = rememberNavController()

    // ── Use SplashViewModel which reads DataStore (same source as SettingsViewModel)
    // This fixes the Reset Onboarding bug — previously MainActivity used
    // SharedPreferences while SettingsViewModel reset DataStore. Now both use DataStore.
    val splashViewModel: SplashViewModel = hiltViewModel()
    val startDestination by splashViewModel.startDestination.collectAsState()

    // Show loading spinner until SplashViewModel decides where to go
    if (startDestination == null) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF1B5E20)),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(color = Color.White)
        }
        return
    }

    NavHost(
        navController = navController,
        startDestination = startDestination!!
    ) {

        // 🔹 ONBOARDING
        composable<Screen.Onboarding> {
            val onboardingViewModel: OnboardingViewModel = hiltViewModel()

            OnboardingScreen(
                onContinue = {
                    // ✅ DataStore save (via ViewModel) — consistent with SettingsViewModel reset
                    onboardingViewModel.completeOnboarding()

                    navController.navigate(Screen.Login) {
                        popUpTo(Screen.Onboarding) { inclusive = true }
                    }
                }
            )
        }

        // 🔹 LOGIN
        composable<Screen.Login> {
            val authViewModel: AuthViewModel = hiltViewModel()

            LoginScreen(
                viewModel = authViewModel,
                onNavigateToRegister = {
                    navController.navigate(Screen.Register)
                },
                onLoginSuccess = {
                    navController.navigate(Screen.Dashboard) {
                        popUpTo(Screen.Login) { inclusive = true }
                    }
                }
            )
        }

        // 🔹 REGISTER
        composable<Screen.Register> {
            val authViewModel: AuthViewModel = hiltViewModel()

            RegisterScreen(
                viewModel = authViewModel,
                onNavigateToLogin = {
                    navController.popBackStack()
                },
                onRegisterSuccess = {
                    navController.navigate(Screen.Dashboard) {
                        popUpTo(Screen.Register) { inclusive = true }
                    }
                }
            )
        }

        // 🔹 DASHBOARD
        composable<Screen.Dashboard> {
            val dashboardViewModel: DashboardViewModel = hiltViewModel()

            DashboardScreen(
                viewModel = dashboardViewModel,
                onNavigateToEligibility = { navController.navigate(Screen.EligibilityChecker) },
                onNavigateToSchemes = { navController.navigate(Screen.Schemes) },
                onNavigateToHospitals = { navController.navigate(Screen.Hospitals) },
                onNavigateToProfile = { navController.navigate(Screen.Profile) },
                onNavigateToSettings = { navController.navigate(Screen.Settings) }
            )
        }

        // 🔹 SETTINGS
        composable<Screen.Settings> {
            val settingsViewModel: SettingsViewModel = hiltViewModel()

            SettingsScreen(
                viewModel = settingsViewModel,
                onNavigateBack = { navController.popBackStack() },
                onLogout = {
                    navController.navigate(Screen.Login) {
                        popUpTo(0) { inclusive = true }
                    }
                }
            )
        }

        // 🔹 ELIGIBILITY
        composable<Screen.EligibilityChecker> {
            val eligibilityViewModel: EligibilityViewModel = hiltViewModel()

            EligibilityScreen(
                viewModel = eligibilityViewModel,
                navController = navController,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }

        // 🔹 SCHEMES
        composable<Screen.Schemes> {
            val schemeViewModel: SchemeViewModel = hiltViewModel()

            SchemeListScreen(
                viewModel = schemeViewModel,
                onNavigateBack = { navController.popBackStack() },
                onSchemeClick = { schemeId ->
                    navController.navigate(Screen.SchemeDetail(schemeId))
                }
            )
        }

        // 🔹 SCHEME DETAIL
        composable<Screen.SchemeDetail> { backStackEntry ->
            val route: Screen.SchemeDetail = backStackEntry.toRoute()
            val viewModel: SchemeDetailViewModel = hiltViewModel()

            SchemeDetailScreen(
                schemeId = route.schemeId,
                viewModel = viewModel,
                onNavigateBack = { navController.popBackStack() }
            )
        }

//        // 🔹 HOSPITALS
//        composable<Screen.Hospitals> {
//            val hospitalViewModel: HospitalViewModel = hiltViewModel()
//
//            HospitalListScreen(
//                viewModel = hospitalViewModel,
//                onNavigateBack = { navController.popBackStack() }
//            )
//        }
        // 🔹 HOSPITALS — NEW (supports optional scheme context)
        composable<Screen.Hospitals> { backStackEntry ->
            val hospitalViewModel: HospitalViewModel = hiltViewModel()

            // If navigated from eligibility, schemeNames will be non-empty
            val schemeNames = backStackEntry.savedStateHandle
                .get<List<String>>("schemeNames") ?: emptyList()

            LaunchedEffect(schemeNames) {
                if (schemeNames.isNotEmpty()) {
                    hospitalViewModel.setEligibleSchemes(schemeNames)
                } else {
                    hospitalViewModel.resetToAll()
                }
            }

            HospitalListScreen(
                viewModel = hospitalViewModel,
                onNavigateBack = {
                    hospitalViewModel.resetToAll()
                    navController.popBackStack()
                }
            )
        }

        // 🔹 PROFILE
        composable<Screen.Profile> {
            val profileViewModel: ProfileViewModel = hiltViewModel()

            ProfileScreen(
                viewModel = profileViewModel,
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}