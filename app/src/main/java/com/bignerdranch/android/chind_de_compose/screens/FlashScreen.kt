package com.bignerdranch.android.chind_de_compose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import com.bignerdranch.android.chind_de_compose.R
import com.bignerdranch.android.chind_de_compose.navigation.NavigationForScreens
import kotlinx.coroutines.delay

@Composable
fun FlashScreen(controller: NavController){
    val const = ConstraintSet {
        val logo = createRefFor("LOGO")
        val name = createRefFor("NAME")
        val outline = createGuidelineFromBottom(20.dp)
        constrain(logo) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
        }
        constrain(name) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(outline)
        }
    }

    LaunchedEffect(key1 = true)
    {
        delay(1500)
        controller.popBackStack()
        controller.navigate(NavigationForScreens.Main.rotate)
    }

    ConstraintLayout(const,
        Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.back))) {
        Logo()
        NameChin()
    }
}

@Composable
fun Logo() {
    val image = painterResource(id = R.drawable.logochin)
    Image(painter = image, contentDescription = "LOGOCHINGISHANA",
        Modifier
            .size(200.dp, 200.dp)
            .layoutId("LOGO"))
}

@Composable
fun NameChin() {
    val nameImege = painterResource(id = R.drawable.name)
    Image(painter = nameImege, contentDescription = "NAMECHINGISHANA",
        Modifier
            .size(150.dp, 37.dp)
            .layoutId("NAME"))
}

