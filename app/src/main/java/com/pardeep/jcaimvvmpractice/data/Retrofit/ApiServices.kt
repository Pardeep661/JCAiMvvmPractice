package com.pardeep.jcaimvvmpractice.data.Retrofit

import com.pardeep.jcaimvvmpractice.data.apiDataModels.ApiDataModel
import com.pardeep.jcaimvvmpractice.data.apiDataModels.ApiDataModelItem
import com.pardeep.jcaimvvmpractice.data.apiDataModels.UpdateRequest
import com.pardeep.jcaimvvmpractice.data.apiDataModels.UpdateRequestResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiServices {

    // these for get all data
    @GET("/objects")
    suspend fun getAllListObject(): ApiDataModel

    //https://api.restful-api.dev/objects?id=3&id=5&id=10
    // get data based on id
    @GET("/objects/{id}")
    suspend fun getListOfDataByID(
        @Path("id") id: Int
    ): ApiDataModelItem

    // for update the data
    @PUT("/objects/{id}")
    suspend fun UpdateData(
        @Path("id") id: Int,
        @Body updateRequest: UpdateRequest
    ): UpdateRequestResponse
}