package com.pardeep.jcaimvvmpractice.data.dataRepository

import com.pardeep.jcaimvvmpractice.data.Retrofit.ApiServices
import com.pardeep.jcaimvvmpractice.data.Retrofit.RetrofitInstance
import com.pardeep.jcaimvvmpractice.data.apiDataModels.ApiDataModel
import com.pardeep.jcaimvvmpractice.data.apiDataModels.ApiDataModelItem

class AllObjectRepoImpl(val retrofitInst: RetrofitInstance) : ApiServices {
    override suspend fun getAllListObject(): ApiDataModel {
        return retrofitInst.api.getAllListObject()
    }

    override suspend fun getListOfDataByID(id: Int): ApiDataModelItem {
        return retrofitInst.api.getListOfDataByID(
            id = id
        )
    }
}