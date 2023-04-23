package com.bignerdranch.android.chind_de_compose.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.android.style.LetterSpacingSpanPx
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.navigation.NavController
import com.bignerdranch.android.chind_de_compose.R
import com.bignerdranch.android.chind_de_compose.ui.theme.Shapes
import org.intellij.lang.annotations.JdkConstants
import androidx.compose.foundation.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip

@Composable
fun MainScreen(controller: NavController) {
    val image = painterResource(id = R.drawable.test)
    val constraint = ConstraintSet {
        val buttonNEWc = createRefFor("buttonNEW")
        val STOCKS = createRefFor("stocks")
        val DRINKS = createRefFor("drinks")
        val FOOD = createRefFor("food")
        val FISH = createRefFor("fish")
        val APPER = createRefFor("apper")
        val PROFILE = createRefFor("profile")
        val outline = createGuidelineFromTop(200.dp)
        val leftline = createGuidelineFromAbsoluteRight(35.dp)
        val rightline = createGuidelineFromAbsoluteLeft(35.dp)
        val profileLeft = createGuidelineFromAbsoluteLeft(10.dp)
        val profileRight = createGuidelineFromAbsoluteRight(325.dp)
        val profileTop = createGuidelineFromTop(15.dp)
        constrain(PROFILE){
            top.linkTo(profileTop)
            start.linkTo(profileLeft)
            end.linkTo(profileRight)
        }
        constrain(buttonNEWc){
            top.linkTo(outline)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(STOCKS){
            top.linkTo(buttonNEWc.bottom, 10.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(DRINKS){
            top.linkTo(STOCKS.bottom, 10.dp)
            start.linkTo(leftline)
            end.linkTo(FOOD.start, 8.dp)
        }
        constrain(FOOD){
            top.linkTo(STOCKS.bottom, 10.dp)
            start.linkTo(DRINKS.end, 8.dp)
            end.linkTo(rightline)
        }
        constrain(FISH){
            top.linkTo(DRINKS.bottom, 10.dp)
            start.linkTo(leftline)
            end.linkTo(APPER.start, 8.dp)
        }
        constrain(APPER){
            top.linkTo(FOOD.bottom, 10.dp)
            start.linkTo(FISH.end, 8.dp)
            end.linkTo(rightline)
        }
    }

    ConstraintLayout(constraint, Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.back))) {
        Button_forJOb(text = stringResource(id = R.string.news), "buttonNEW", 309,99)
        Button_forJOb(text = stringResource(id = R.string.stocks), "stocks", 309,99)
        Button_forJOb(text = stringResource(id = R.string.drinks), "drinks" , 147, 147)
        Button_forJOb(text = stringResource(id = R.string.food),"food", 147 , 147)
        Button_forJOb(text = stringResource(id = R.string.fish), "fish", 147, 147)
        Button_forJOb(text = stringResource(id = R.string.apper), "apper", 147, 147)
        profileButton(image = image, name = "profile")
    }
}

@Composable
fun profileButton(image: Painter, name: String) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .border(
                width = 2.dp,
                color = colorResource(id = R.color.yellow),
                shape = RoundedCornerShape(50.dp)
            )
            .border(
                width = 4.dp,
                color = colorResource(id = R.color.tealkor),
                shape = RoundedCornerShape(50.dp)
            )
            .size(50.dp, 50.dp)
            .layoutId(name)
    ){
        Image(painter = image, contentDescription = "profile",
            Modifier.fillMaxSize().clip(CircleShape).size(50.dp, 50.dp),
            contentScale = ContentScale.FillBounds)
    }
}

@Composable
fun Button_forJOb(text: String, name: String, sizeF : Int, sizeS : Int /*, onItemClick: () -> Unit, */){
    Row(
        modifier = Modifier
            .border(
                width = 2.dp,
                color = colorResource(id = R.color.yellow),
                shape = RoundedCornerShape(10.dp)
            )
            .border(
                width = 4.dp,
                color = colorResource(id = R.color.tealkor),
                shape = RoundedCornerShape(10.dp)
            )
            .size(sizeF.dp, sizeS.dp)
            .background(
                color = colorResource(
                    id = R.color.buttons
                ), shape = RoundedCornerShape(10.dp)
            )
            .layoutId(name),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column() {
            Text(text = text, Modifier.alpha(0.3f), style = TextStyle(fontWeight = FontWeight.Bold, color = colorResource(
                id = R.color.white), fontSize = 15.sp))
            Text(text = text,
                Modifier
                    .alpha(0.1f)
                    .rotate(180f)
                    .padding(end = 3.dp),
                style = TextStyle(fontWeight = FontWeight.Bold, color = colorResource(id = R.color.white), fontSize = 13.sp))
        }
    }
}

