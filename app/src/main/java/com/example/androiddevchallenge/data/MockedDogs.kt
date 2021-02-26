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
package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Dog

object MockedDogs {

    operator fun invoke(): List<Dog> {
        val dogs = arrayListOf<Dog>().apply {
            add(Dog(1, R.drawable.charlie, "Charlie", R.string.charlie_description, "CA", "3 years old", "Pit Bull Terrier"))
            add(Dog(2, R.drawable.sally, "Tink", R.string.sally_description, "CA", "2 years old", "Shepherd"))
            add(Dog(3, R.drawable.molly, "Molly", R.string.molly_description, "CA", "3 years old", "Labrador"))
            add(Dog(4, R.drawable.males, "Males", R.string.males_description, "CA", "4 years old", "Greyhound"))
            add(Dog(5, R.drawable.rosie, "Rosie", R.string.rosie_description, "CA", "2 years old", "Pit Bull Terrier "))
            add(Dog(6, R.drawable.bigben, "Big Ben", R.string.bigben_description, "CA", "10 years old", "American Bulldog"))
            add(Dog(7, R.drawable.loyalty, "Loyalty", R.string.loyalty_description, "CA", "10 years old", "German Shepherd"))
        }
        return dogs.toList()
    }
}
