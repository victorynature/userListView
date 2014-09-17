package com.activity;

import java.util.ArrayList;

import org.apache.http.Header;
import org.json.JSONArray;

import android.app.Activity;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.model.User;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.relateiq.R;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class HomeActivity extends Activity {
	private static final String Url = "https://api.github.com/users";
	private ArrayList<User> users;
	private ArrayAdapter<User> aUsers;
	private ListView lvUsers;
	private ImageLoader imageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(this));
        
        loadUsers();
        
        lvUsers = (ListView) findViewById(R.id.lvUsers);
        users = new ArrayList<User>();
        aUsers = new UserArrayAdapter(this, users);
        lvUsers.setAdapter(aUsers);
    }
    
    public void loadUsers(){
    	
    	AsyncHttpClient client = new AsyncHttpClient();
    	client.get(Url, new JsonHttpResponseHandler(){
			@Override
			public void onSuccess(JSONArray response) {
				aUsers.addAll(User.fromJsonArray(response));
			}
    	});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
