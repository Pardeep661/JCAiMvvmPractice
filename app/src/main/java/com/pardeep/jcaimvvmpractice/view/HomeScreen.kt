package com.pardeep.jcaimvvmpractice.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pardeep.jcaimvvmpractice.UiState
import com.pardeep.jcaimvvmpractice.data.Retrofit.RetrofitInstance
import com.pardeep.jcaimvvmpractice.data.apiDataModels.ApiDataModelItem
import com.pardeep.jcaimvvmpractice.data.dataRepository.AllObjectRepoImpl
import com.pardeep.jcaimvvmpractice.viewModel.HomeScreenViewModel
import com.pardeep.jcaimvvmpractice.viewModel.HomeScreenViewModelFactory

@Composable
fun HomeUi(modifier: Modifier = Modifier) {

    val retrofitInstance = RetrofitInstance
    val allObjectRepoImpl = AllObjectRepoImpl(retrofitInstance)
    val factory = HomeScreenViewModelFactory(allObjectRepoImpl)
    val homeScreenViewModel: HomeScreenViewModel = viewModel(factory = factory)
    val uiState by homeScreenViewModel.uiState.collectAsState()
    val textFieldValue by homeScreenViewModel.textFieldData.collectAsState()

    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = textFieldValue,
                    onValueChange = {
                        homeScreenViewModel.updateTextField(it)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text("Enter field like : 1,2,3...")
                    }
                )
                when (uiState) {
                    is UiState.onLoading -> {
                        CircularProgressIndicator()
                    }

                    is UiState.onSuccess -> {
                        val list = (uiState as UiState.onSuccess<List<ApiDataModelItem>>).data

                        LazyColumn {
                            items(list.size) { index ->
                                Column(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalArrangement = Arrangement.SpaceAround
                                ) {
                                    Card(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(70.dp)
                                            .clip(RoundedCornerShape(15.dp))
                                            .padding(horizontal = 5.dp)
                                            .clickable(
                                                onClick = {
                                                    homeScreenViewModel.updateDataRequest(index)
                                                }
                                            )
                                    ) {
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceAround
                                        ) {
                                            Column(
                                                modifier = Modifier
                                                    .weight(1f)
                                                    .fillMaxHeight(),
                                                verticalArrangement = Arrangement.SpaceEvenly
                                            ) {
                                                Text(
                                                    text = "Item name",
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .padding(
                                                            horizontal = 8.dp,
                                                            vertical = 5.dp
                                                        ),
                                                    textAlign = TextAlign.Center
                                                )
                                                Text(
                                                    text = list[index].name,
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .padding(
                                                            horizontal = 8.dp,
                                                            vertical = 5.dp
                                                        ),
                                                    textAlign = TextAlign.Center
                                                )
                                            }
                                            Column(
                                                modifier = Modifier
                                                    .weight(1f)
                                                    .fillMaxHeight(),
                                                verticalArrangement = Arrangement.SpaceEvenly

                                            ) {
                                                Text(
                                                    text = "Price",
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .padding(
                                                            horizontal = 8.dp,
                                                            vertical = 5.dp
                                                        ),
                                                    textAlign = TextAlign.Center
                                                )
                                                Text(
                                                    text = "${list[index].data?.price ?: 0.0}",
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .padding(
                                                            horizontal = 8.dp,
                                                            vertical = 5.dp
                                                        ),
                                                    textAlign = TextAlign.Center
                                                )
                                            }
                                            Column(
                                                modifier = Modifier
                                                    .weight(1f)
                                                    .fillMaxHeight(),
                                                verticalArrangement = Arrangement.SpaceEvenly

                                            ) {
                                                Text(
                                                    text = "Color",
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .padding(
                                                            horizontal = 8.dp,
                                                            vertical = 5.dp
                                                        ),
                                                    textAlign = TextAlign.Center
                                                )
                                                Text(
                                                    text = list[index].data?.color.toString(),
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .padding(
                                                            horizontal = 8.dp,
                                                            vertical = 5.dp
                                                        ),
                                                    textAlign = TextAlign.Center
                                                )
                                            }
                                        }

                                    }
                                    Spacer(modifier = Modifier.height(4.dp))
                                }
                            }
                        }
                    }

                    is UiState.onError -> {
                        Text(
                            text = (uiState as UiState.onError).err,
                            color = Color.Red,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }

            }

        }
    }

}

@Preview
@Composable
private fun ShowPrev() {
    HomeUi()
}