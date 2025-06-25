package com.pardeep.jcaimvvmpractice.data.Retrofit

import com.pardeep.jcaimvvmpractice.data.apiDataModels.ApiDataModel
import com.pardeep.jcaimvvmpractice.data.apiDataModels.ApiDataModelItem
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServices {

    // these for get all data
    @GET("/objects")
    suspend fun getAllListObject(): ApiDataModel

    //https://api.restful-api.dev/objects?id=3&id=5&id=10
    // get data based on id
    @GET("/objects/{id}")
    suspend fun getListOfDataByID(
        @Path("id") id: Int,
        @Query("q") query: String
    ): ApiDataModelItem

    @PUT("/objects/{id}")
    suspend fun UpdateData(
        @Path("id") id:Int,
        
    ){

    }
}