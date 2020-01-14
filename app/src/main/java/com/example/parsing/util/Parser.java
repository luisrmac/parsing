package com.example.parsing.util;

import com.example.parsing.model.Info;
import com.example.parsing.model.Name;
import com.example.parsing.model.RandomResponse;
import com.example.parsing.model.Result;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Parser {

    private static Parser INSTANCE = null;

    private Parser() {

    }

    public static Parser getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Parser();
        }
        return INSTANCE;
    }

    public RandomResponse parseResponse(String json) {
        try {
            JSONObject jsonObjectResponse = new JSONObject(json);
            RandomResponse randomPerson = new RandomResponse();

            JSONObject infoJSONObject = jsonObjectResponse.getJSONObject(RandomResponse.SERIALIZED_NAME_INFO);
            Info info = new Info();
            info.setSeed(infoJSONObject.getString(Info.SERIALIZED_NAME_SEED));
            info.setResults(infoJSONObject.getInt(Info.SERIALIZED_NAME_RESULTS));
            info.setPage(infoJSONObject.getInt(Info.SERIALIZED_NAME_PAGE));
            info.setVersion(infoJSONObject.getString(Info.SERIALIZED_NAME_VERSION));
            randomPerson.setInfo(info);

            ArrayList<Result> results = new ArrayList<>();
            JSONArray jsonArray = jsonObjectResponse.getJSONArray(RandomResponse.SERIALIZED_NAME_RESULTS);
            for(int i =0; i<jsonArray.length(); i++) {
                Result result = new Result();
                JSONObject resultJSONObject = jsonArray.getJSONObject(i);
                result.setGender(resultJSONObject.getString(Result.SERIALIZED_NAME_GENDER));
                JSONObject nameJSONObject = resultJSONObject.getJSONObject(Result.SERIALIZED_NAME_NAME);
                Name name = new Name();
                name.setTitle(nameJSONObject.getString(Name.SERIALIZED_NAME_TITLE));
                name.setFirst(nameJSONObject.getString(Name.SERIALIZED_NAME_FIRST));
                name.setLast(nameJSONObject.getString(Name.SERIALIZED_NAME_LAST));
                result.setName(name);
                results.add(result);
            }
            randomPerson.setResults(results);
            return randomPerson;
        } catch (JSONException je) {
            je.printStackTrace();
        }
        return null;
    }
}
