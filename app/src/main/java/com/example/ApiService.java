package com.example;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Author:紫楼主
 * Date:2019/7/7
 */
public interface ApiService {

    @Multipart
    @POST("small/user/verify/v1/modifyHeadPic")
    Call<UploadBean> upLoadPic(@Part MultipartBody.Part file);
}
