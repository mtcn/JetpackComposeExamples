package com.apps.jetpackcomposeexamples.example1.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.apps.jetpackcomposeexamples.R
import com.apps.jetpackcomposeexamples.example1.model.EventModel
import com.apps.jetpackcomposeexamples.ui.theme.*
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun JoinWithCodeCard() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
        color = White,
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 16.dp)
        ) {
            BasicTextField(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .align(Alignment.CenterVertically),
                textStyle = TextStyle(
                    color = LightGrey,
                    fontSize = 20.sp,
                    fontFamily = MuliRegular
                ),
                value = "Join with code",
                onValueChange = {})

            Image(
                painter = painterResource(id = R.drawable.ic_event_add),
                contentDescription = "Join",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(4.dp)
                    .width(32.dp)
                    .height(32.dp),
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EventCard(eventModel: EventModel, onClick: (event: EventModel) -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        color = White,
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp,
        onClick = { onClick(eventModel) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Image(
                painter = painterResource(id = eventModel.mainLogo),
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .fillMaxWidth(0.15f),
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .fillMaxHeight()
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = eventModel.name,
                    maxLines = 1,
                    style = TextStyle(
                        color = Color.Black, fontSize = 16.sp, fontFamily = MuliBold
                    ),
                    modifier = Modifier
                        .padding(top = 24.dp, start = 8.dp, end = 8.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = eventModel.date,
                    maxLines = 1,
                    style = TextStyle(
                        color = Color.LightGray,
                        fontSize = 12.sp,
                        fontFamily = MuliRegular
                    ),
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp)
                        .fillMaxWidth()
                )
            }

            Image(
                painter = painterResource(id = R.drawable.ic_event_right_arrow),
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(4.dp)
                    .width(32.dp)
                    .height(32.dp),
            )
        }
    }
}

@Composable
fun EventScreen(events: List<EventModel>? = null, onEventClick: (event: EventModel) -> Unit) {
    rememberSystemUiController().apply {
        setSystemBarsColor(EventPrimary, darkIcons = false)
        setNavigationBarColor(White, true)
    }
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(AlmostWhite)
    ) {
        val (joinCard, topView, logoView, profilePhoto, text, eventList) = createRefs()
        Box(
            modifier = Modifier
                .constrainAs(topView) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth()
                .fillMaxHeight(0.3f)
                .background(EventPrimary)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_event_logo),
            contentDescription = "",
            modifier = Modifier
                .padding(top = 36.dp, start = 24.dp)
                .constrainAs(logoView) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
        )
        Image(
            painter = painterResource(id = R.drawable.ic_event_pp),
            contentDescription = "",
            modifier = Modifier
                .padding(top = 36.dp, end = 24.dp)
                .height(64.dp)
                .width(64.dp)
                .constrainAs(profilePhoto) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
        )
        Text(
            text = "Meet with new people and\nexpand your professional network!",
            modifier = Modifier
                .constrainAs(text) {
                    top.linkTo(logoView.bottom)
                    start.linkTo(parent.start)
                }
                .padding(start = 24.dp, top = 36.dp, end = 24.dp),
            style = TextStyle(
                color = White,
                fontSize = 20.sp,
                fontFamily = MuliRegular
            )
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp)
                .constrainAs(joinCard) {
                    top.linkTo(topView.bottom)
                    bottom.linkTo(topView.bottom)
                }) {
            JoinWithCodeCard()
        }

        events?.let { events ->
            LazyColumn(content = {
                items(items = events) { event ->
                    Spacer(modifier = Modifier.padding(top = 8.dp))
                    EventCard(eventModel = event) {
                        onEventClick(it)
                    }
                }
            },
                modifier = Modifier
                    .constrainAs(eventList) {
                        top.linkTo(joinCard.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .fillMaxHeight()
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                contentPadding = PaddingValues(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp,
                    bottom = 500.dp
                ))
        }
    }
}