/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.nav

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.NavType.IntType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.DogDetail
import com.example.androiddevchallenge.DogList
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.nav.MainDestinations.DOG_DETAIL
import com.example.androiddevchallenge.nav.MainDestinations.DOG_DETAIL_KEY

object MainDestinations {
    const val DOG_LIST = "list"
    const val DOG_DETAIL = "detail"
    const val DOG_DETAIL_KEY = "detailId"
}

@Composable
fun NavGraph(startDestination: String = MainDestinations.DOG_LIST) {
    val navController = rememberNavController()
    val (canPop, setCanPop) = remember { mutableStateOf(false) }
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val actions = remember(navController) { MainActions(navController) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.app_name)) },
                navigationIcon = if (canPop) {
                    {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(Icons.Outlined.ArrowBack, "back")
                        }
                    }
                } else {
                    null
                },
            )
        },
        scaffoldState = scaffoldState
    ) {
        NavHost(
            navController = navController,
            startDestination = startDestination
        ) {

            composable(MainDestinations.DOG_LIST) {
                setCanPop(false)
                DogList(callback = actions.selectPuppy)
            }

            composable(
                "$DOG_DETAIL/{$DOG_DETAIL_KEY}",
                arguments = listOf(navArgument(DOG_DETAIL_KEY) { type = IntType })
            ) { backStackEntry ->
                val arguments = requireNotNull(backStackEntry.arguments)
                setCanPop(true)
                DogDetail(id = arguments.getInt(DOG_DETAIL_KEY))
            }
        }
    }
}

/**
 * Models the navigation actions in the app.
 */
class MainActions(navController: NavHostController) {
    val selectPuppy: (Int) -> Unit = {
        navController.navigate("$DOG_DETAIL/$it")
    }
}
