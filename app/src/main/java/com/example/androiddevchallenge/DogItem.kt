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
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Dog

@Composable
fun ItemList(dog: Dog, callback: (Int) -> Unit) {
    Row(Modifier.clickable(onClick = { callback(dog.id) })) {
        Image(
            painter = painterResource(dog.imgRes),
            contentDescription = dog.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(130.dp)
                .padding(16.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape)
                .height(300.dp)
                .fillMaxWidth()
        )

        Column(modifier = Modifier.align(Alignment.CenterVertically)) {
            Row {
                Text(
                    text = "Name:",
                    modifier = Modifier.padding(start = 4.dp, top = 16.dp),
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = dog.name,
                    modifier = Modifier.padding(start = 4.dp, top = 16.dp)
                )
            }

            Row {
                Text(
                    text = "Breed:",
                    modifier = Modifier.padding(start = 4.dp, top = 16.dp),
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = dog.breed,
                    modifier = Modifier.padding(start = 4.dp, top = 16.dp)
                )
            }
        }
    }
}
