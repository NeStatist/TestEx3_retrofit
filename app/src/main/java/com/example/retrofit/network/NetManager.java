package com.example.retrofit.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

final class NetManager {

    private static UserAPI userAPI;
    private static Gson gson;
    private static long readTimeout;
    private static long writeimeout;
    private static NetManager INSTANCE;

    public static NetManager getInstance() {
        if (INSTANCE == null) {
            synchronized ((NetManager.class)) {
                if (INSTANCE == null) {
                    INSTANCE = new NetManager();
                }
            }
        }
        return INSTANCE;
    }

    private OkHttpClient okHttpClient = new OkHttpClient()
            .newBuilder()
            .connectTimeout(3, TimeUnit.MINUTES)
            .writeTimeout(3, TimeUnit.MINUTES)
            .readTimeout(3, TimeUnit.MINUTES)
            .addInterceptor(new ResponseInterceptor()).build();

    private Retrofit getRetofit() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.screenlife.com/")
                .addConverterFactory(GsonConverterFactory.create(createGson()))
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    class ResponseInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Response response = chain.proceed(chain.request());

            Response.Builder builder;

            builder = response.newBuilder()
                    .addHeader("Content-Type", "application/json; charset=utf-8");

            return builder.build();
        }
    }

    public final UserAPI getRestApi() {
        if(userAPI == null) {
            userAPI = getRetofit().create(UserAPI.class);
        }
        return userAPI;
    }

    private Gson createGson() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .setLenient()
                .create();
    }

}
