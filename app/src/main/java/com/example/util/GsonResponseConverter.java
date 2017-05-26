package com.example.util;

import com.example.common.baserx.ServerException;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by lxl on 2017/5/3.
 */

public class GsonResponseConverter<T> implements Converter<ResponseBody,T>{
    private final Gson gson;
    private final Type type;

    public GsonResponseConverter(Gson gson,Type type){
        this.gson = gson;
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        if(!response.substring(0,1).equals("{")){
            System.out.println(response.substring(2,response.length()-1));
            return gson.fromJson(response.substring(2,response.length()-1),type);
        }else{
            return gson.fromJson(response,type);
        }
    }
}
