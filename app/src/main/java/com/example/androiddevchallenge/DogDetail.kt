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
package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.MockedDogs

@Composable
fun DogDetail(id: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        val data = MockedDogs().find { it.id == id } ?: throw IllegalArgumentException()
        val image: Painter = painterResource(id = data.imgRes)
        Image(
            painter = image,
            contentDescription = data.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier.aspectRatio(1f)
        )
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = data.name,
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.primary,
            )

            Text(
                text = stringResource(id = data.description),
                style = MaterialTheme.typography.caption,
                color = MaterialTheme.colors.onSurface,
            )
        }
    }
}
