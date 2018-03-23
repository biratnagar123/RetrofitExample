package curesoft.retrofitexample.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Prabin kumar mallick on 12-09-2017.
 */

public class ApiClient
 {
    private static final String Base_Url="http://api.themoviedb.org/3/";
     public static Retrofit retrofit=null;
    public static Retrofit getApiClient(){
         if(retrofit==null){
             retrofit=new Retrofit.Builder().baseUrl(Base_Url).addConverterFactory(GsonConverterFactory.create()).build();
         }
         return retrofit;
     }


}
