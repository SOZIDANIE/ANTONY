package com.bignerdranch.android.chind_de_compose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.navigation.NavController
import com.bignerdranch.android.chind_de_compose.R
import com.bignerdranch.android.chind_de_compose.navigation.NavigationForScreens


@Composable
fun EnterScreen(controller: NavController){
    val constraint = ConstraintSet {
        val enter = createRefFor("ENTER")
        val pass = createRefFor("pass")
        val name = createRefFor("Name")
        val enterGlav = createRefFor("ENTER")
        val guideLine = createGuidelineFromTop(250.dp)

        /*constrain(enterGlav){
            top.linkTo(parent.top, 10.dp)
            start.linkTo(name.start)
            end.linkTo(name.end)
        }*/
        constrain(name){
            top.linkTo(guideLine)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(pass){
            top.linkTo(name.bottom, 10.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(enter){
            top.linkTo(pass.bottom, 30.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
    }
    ConstraintLayout(constraint, Modifier
        .fillMaxSize()
        .background(
            color = colorResource(id = R.color.back)
        )){
        /*Text(text = stringResource(id = R.string.enterGlav), Modifier.alpha(0.3f).layoutId("ENTER"),
            style = TextStyle(fontWeight = FontWeight.Bold, color = colorResource(id = R.color.white), fontSize = 30.sp))*/
        OutlinedTextField(
            value = "",
            onValueChange = {  },
            label = { Text(stringResource(id = R.string.enterName)) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .size(300.dp, 60.dp)
                .layoutId("Name")
        )
        OutlinedTextField(
            value = "",
            onValueChange = {  },
            label = { Text(stringResource(id = R.string.enterPass)) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .size(300.dp, 60.dp)
                .layoutId("pass")
        )
        Button_forJOb(text = stringResource(R.string.enter), name = "ENTER", sizeF = 250, sizeS = 75) {
            controller.navigate(NavigationForScreens.Main.rotate)
        }
    }
}