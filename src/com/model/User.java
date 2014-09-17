package com.model;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class User {
	@Override
	public String toString() {
		return getName();
	}

	private String userImageUrl;
	private String name;
	
	public static User fromJson(JSONObject json){
		User u = new User();

        try {
            u.name = json.getString("login");
            u.userImageUrl = json.getString("avatar_url");
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return u;
    
	}
	
	public static ArrayList<User> fromJsonArray(JSONArray jsonArray) {
        ArrayList<User> users = new ArrayList<User>(jsonArray.length());

        for (int i=0; i < jsonArray.length(); i++) {
            JSONObject userJson = null;
            try {
                userJson = jsonArray.getJSONObject(i);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            User user = User.fromJson(userJson);
            if (user != null) {
                users.add(user);
            }
        }

        return users;
    }

	public String getUserImageUrl() {
		return userImageUrl;
	}

	public void setUserImageUrl(String userImageUrl) {
		this.userImageUrl = userImageUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
