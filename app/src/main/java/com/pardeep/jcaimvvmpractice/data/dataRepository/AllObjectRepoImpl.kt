package com.pardeep.jcaimvvmpractice.data.dataRepository

import android.util.Log
import com.pardeep.jcaimvvmpractice.data.Retrofit.ApiServices
import com.pardeep.jcaimvvmpractice.data.Retrofit.RetrofitInstance
import com.pardeep.jcaimvvmpractice.data.apiDataModels.ApiDataModel
import com.pardeep.jcaimvvmpractice.data.apiDataModels.ApiDataModelItem
import com.pardeep.jcaimvvmpractice.data.apiDataModels.UpdateRequest
import com.pardeep.jcaimvvmpractice.data.apiDataModels.UpdateRequestResponse
import java.util.Objects

class AllObjectRepoImpl(val retrofitInst: RetrofitInstance) : ApiServices {
    override suspend fun getAllListObject(): ApiDataModel {
        return retrofitInst.api.getAllListObject()
    }

    override suspend fun getListOfDataByID(id: Int): ApiDataModelItem {
        return retrofitInst.api.getListOfDataByID(
            id = id
        )
    }

    override suspend fun UpdateData(id: Int, objectData: UpdateRequest): UpdateRequestResponse {
        Log.d(
            "AllObjectRepoImpl", "UpdateData: Update data :${
                retrofitInst.api.UpdateData(
                    id,
                    updateRequest = objectData
                )
            }"
        )
        return retrofitInst.api.UpdateData(
            id,
            updateRequest =objectData
        )
    }
}