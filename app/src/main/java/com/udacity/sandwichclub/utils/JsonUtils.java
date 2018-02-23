package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            // JSONObject is created here, pulling out all the values needed to create a Sandwich object
            JSONObject sandwichJson = new JSONObject(json);
            String name = sandwichJson.getJSONObject("name").getString("mainName");
            JSONArray alsoKnownAs = sandwichJson.getJSONObject("name").getJSONArray("alsoKnownAs");
            String placeOfOrigin = sandwichJson.getString("placeOfOrigin");
            String description = sandwichJson.getString("description");
            String image = sandwichJson.getString("image");
            JSONArray ingredients = sandwichJson.getJSONArray("ingredients");

            // Array list of Strings, adds each new String to an ArrayList called listOfAlsoKnownAs
            ArrayList<String> listOfAlsoKnownAs = new ArrayList<String>();
            if (alsoKnownAs != null) {
                for (int i = 0; i < alsoKnownAs.length(); i++) {
                    listOfAlsoKnownAs.add(alsoKnownAs.getString(i));
                }
            }

            // Array list of Strings, adds each new String to an ArrayList called listOfIngredients
            ArrayList<String> listOfIngredients = new ArrayList<String>();
            if (ingredients != null) {
                for (int i = 0; i < ingredients.length(); i++) {
                    listOfIngredients.add(ingredients.getString(i));
                }
            }

            Sandwich sandwich = new Sandwich(name, listOfAlsoKnownAs, placeOfOrigin, description, image, listOfIngredients);
            return sandwich;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
