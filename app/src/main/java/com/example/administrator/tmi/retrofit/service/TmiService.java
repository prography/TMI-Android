package com.example.administrator.tmi.retrofit.service;

import com.example.administrator.tmi.data.ItemData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TmiService {
    @GET("users/{user}/repos")
    Call<List<ItemData>> reposForUser(@Path("user") String user);
    //@Path: URL중 동적으로 바뀌는 부분을 위해 사용

    @PUT("api/users/{id}")
    Call<ItemData> updateUser(@Header("Authorization") String token, @Path("id") Long id,
                          @Query("name") String name, @Query("password") String password);
    //@Body: send Java objects as request body.

    @POST("users/LieutenantKang")
    Call<List<ItemData>> createRepo(@Body List<ItemData> list);

    @POST("api/users")
    Call<ItemData> createUser(@Header("Authorization") String token,  @Body ItemData data);

    @DELETE("api/users/{id}")
    Call<String> deleteUser(@Header("Authorization") String token, @Path("id") Long id);

    /*
    SharedPreferences pref = getSharedPreferences("Game", Activity.MODE_PRIVATE);

    private void saveScore() {
        SharedPreferences pref = getSharedPreferences("Game" < SharedPref의 이름이다, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("score", info);
        //score가 key값이고, info라는 String 데이터를 이 key에 저장한다.
        editor.commit();
    }

    private void loadScore() {
        SharedPreferences pref = getSharedPreferences("Game", Activity.MODE_PRIVATE);
        String score = pref.getString("score", "없음" < key에 해당하는 값이 없을 경우 반환 값);
        Toast.makeText(MainActivity.this, "score : " + score, Toast.LENGTH_LONG).show();
    }

    private void deleteScore(){
        SharedPreferences pref = getSharedPreferences("Game", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.remove("score") // score라는 key값의 데이터 삭제
        //모두 삭제하고 싶을 땐 editor.clear();
        editor.commit();
    }
    */
}
