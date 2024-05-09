package com.example.mobpro2.navigation

import com.example.mobpro2.ui.screen.KEY_ID_MURID

sealed class Screen(val route: String){
    data object Home: Screen("mainscreen")
    data object FormBaru: Screen("detailScreen")
    data object FormUbah: Screen("detailScreen/{$KEY_ID_MURID}") {
        fun withId(id:Long) = "detailScreen/$id"
    }
}