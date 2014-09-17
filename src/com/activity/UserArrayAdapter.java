package com.activity;

import java.util.List;

import com.model.User;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.relateiq.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class UserArrayAdapter extends ArrayAdapter<User> {

	public UserArrayAdapter(Context context, List<User> users) {
		
		super(context, 0, users);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// Get the data item for position
		User user = getItem(position);
		
		View view;
		
		if(convertView == null){
			LayoutInflater inflater = LayoutInflater.from(getContext());
			view = inflater.inflate(R.layout.user_item, parent, false);
		} else{
			view = convertView;
		}
		
		ImageView imageView = (ImageView) view.findViewById(R.id.ivProfileImage);
		imageView.setImageResource(android.R.color.transparent);
		ImageLoader imageLoader = ImageLoader.getInstance();
		imageLoader.displayImage(user.getUserImageUrl(), imageView);
		
		TextView nameView = (TextView) view.findViewById(R.id.tvUserName);
		nameView.setText(user.getName());
		
		return view;
	}

}
