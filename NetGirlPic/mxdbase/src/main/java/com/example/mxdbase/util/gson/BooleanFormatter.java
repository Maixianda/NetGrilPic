package com.example.mxdbase.util.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Created by Administrator on 2016/8/11.
 * 说明:           Gson解析时,如果本应该接收boolean类型的接收到意外类型,返回0
 * 创建人:         maixianda
 * 创建时间:       2016/8/11 15:25
 */
public class BooleanFormatter extends TypeAdapter<Boolean> {
    @Override
    public void write(JsonWriter out, Boolean value) throws IOException {
        out.value(String.valueOf(value));
    }

    @Override
    public Boolean read(JsonReader in) throws IOException {
            return Boolean.parseBoolean(in.nextString());
    }
}
