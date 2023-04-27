package com.bignerdranch.android.chind_de_compose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.navigation.NavController
import com.bignerdranch.android.chind_de_compose.R

@Composable
fun ProfileScreen(controller: NavController){
    val constraint = ConstraintSet {
        val enter = createRefFor("ENTER")
        val reg = createRefFor("REG")
        val guideLine = createGuidelineFromTop(100.dp)

        constrain(enter){
            top.linkTo(guideLine)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(reg){
            top.linkTo(enter.bottom, 10.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
    }
    ConstraintLayout(constraint, Modifier
        .fillMaxSize()
        .background(
            color = colorResource(id = R.color.back)
        )){
        Button_forJOb(text = stringResource(R.string.enter), name = "ENTER", sizeF = 250, sizeS = 75) {

        }
        Button_forJOb(text = stringResource(R.string.registration), name = "REG", sizeF = 250, sizeS = 75) {
            
        }
    }
}