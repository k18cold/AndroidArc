/**
 * @Copyright © 2015 广州四三九九信息科技有限公司. All Rights Reserved.
*/

package com.dba.util;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GsonUtils {

	public static <T extends Serializable> T parse(String json, Class<T> clz){
		if(TextUtils.isEmpty(json)){
			return null;
		}
		T bean = null;
		try{
			bean = new Gson().fromJson(json, clz);
		}catch (Exception e){
			Log.e("gson", e.getMessage());
		}
		return bean;
	}

	public static String toJsonString(Object obj){
		if(obj == null){
			return null;
		}
		return new Gson().toJson(obj);
	}

	public static <T extends Serializable> List<T> parseToList(String json,Class<T> clz) {
		List<T> result = null;
		if (TextUtils.isEmpty(json)) {
			return result;
		}

		try{
			result = new ArrayList<T>();
			JSONArray jArray = new JSONArray(json);
			int length = jArray.length();
			for(int i = 0; i < length; i++){
				String str = jArray.getString(i);
				T obj = parse(str, clz);
				result.add(obj);
			}
		}catch (Exception e){
			Log.e("gson", e.getMessage());
		}
		return result;
	}

	public static boolean isArray(String json){
		boolean result = false;
		if(TextUtils.isEmpty(json)){
			return false;
		}
		try {
			JSONArray jsonArray = new JSONArray(json);
			result = true;
		} catch (JSONException e) {
		}
		return result;
	}
}
