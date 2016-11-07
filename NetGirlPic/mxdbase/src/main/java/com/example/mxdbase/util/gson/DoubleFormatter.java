package com.example.mxdbase.util.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Created by Administrator on 2016/8/11.
 * 说明:           Gson解析时,如果本应该接收double类型的接收到意外类型,返回0
 * 创建人:         maixianda
 * 创建时间:       2016/8/11 15:21
 */
public class DoubleFormatter extends TypeAdapter<Double> {
    @Override
    public void write(JsonWriter out, Double value) throws IOException {
        out.value(String.valueOf(value));
    }

    @Override
    public Double read(JsonReader in) throws IOException {
        try {
            return Double.parseDouble(in.nextString());
        }
        catch (NumberFormatException e)
        {
            return Double.valueOf(0);
        }
    }
}
