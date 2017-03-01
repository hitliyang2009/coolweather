package com.hillstone.coolweather.util;

import android.text.TextUtils;
import android.util.Log;

import com.hillstone.coolweather.db.City;
import com.hillstone.coolweather.db.Province;
import com.hillstone.coolweather.db.County;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hillstone on 2017/2/28.
 */

public class Utility {
    private static final String TAG = "Utility";
    /*
    * 解析和处理服务器返回的省级数据
    * */
    public static boolean handleProvinceResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allProvince = new JSONArray(response);
                
                for (int i = 0; i < allProvince.length(); i++) {
                    
                    JSONObject provinceObject = allProvince.getJSONObject(i);
                    
                    Province province = new Province();
                    
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    
                    province.save();
                }
                Log.d(TAG, "handleProvinceResponse: Got all province data");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            
            return true;
        }
        Log.e(TAG, "handleProvinceResponse: none data of province responsed");
        return false;
    }

    /*
    * 解析和处理服务器返回的city级数据
    * */
    public static boolean handleCityResponse(String response, int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCities = new JSONArray(response);

                for (int i = 0; i < allCities.length(); i++) {

                    JSONObject cityObject = allCities.getJSONObject(i);

                    City city = new City();

                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);

                    city.save();
                }
                Log.d(TAG, "handleCityResponse: Got all city data");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return true;
        }
        Log.e(TAG, "handleCityResponse: none data of city responsed");
        return false;
    }

    /*
    * 解析和处理服务器返回的county级数据
    * */
    public static boolean handleCountyResponse(String response, int cityId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCounties = new JSONArray(response);

                for (int i = 0; i < allCounties.length(); i++) {

                    JSONObject countyObject = allCounties.getJSONObject(i);

                    County county = new County();

                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);

                    county.save();
                }
                Log.d(TAG, "handleCountyResponse: Got all county data");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return true;
        }
        Log.e(TAG, "handleCountyResponse: none data of county responsed");
        return false;
    }
}
