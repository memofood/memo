package it.sii.android.fragmentnavigationdrawertest;

import it.sii.android.fragmentnavigationdrawertest.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class FragmentNavigationDrawerActivity extends FragmentActivity {

	private String[] mFragmentNames;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		mFragmentNames = getResources().getStringArray(R.array.fragments_names_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, mFragmentNames));
        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
		
	}

	private class DrawerItemClickListener implements ListView.OnItemClickListener {
	    @Override
	    public void onItemClick(AdapterView parent, View view, int position, long id) {
	        selectItem(position);
	    }
	}
	
	private void selectItem(int position) {
	    // Insert the fragment by replacing any existing fragment
		Fragment fragment = null;
		Log.d("fabry","pos="+position);
		if(position==0) // First
			fragment = new FirstFragment();
		else if(position==1) // Second
			fragment = new SecondFragment();
		else if(position==2) // Third
			fragment = new ThirdFragment();
		FragmentManager fragmentManager = getSupportFragmentManager();
	    fragmentManager.beginTransaction()
	                   .replace(R.id.content_frame, fragment)
	                   .commit();
	    mDrawerList.setItemChecked(position, true);
	    setTitle(mFragmentNames[position]);
	    mDrawerLayout.closeDrawer(mDrawerList);
	}	

	public static class FirstFragment extends Fragment {
		 @Override
	        public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                Bundle savedInstanceState) {

		     return inflater.inflate(R.layout.first, container, false);
		 }
	}
	
	public static class SecondFragment extends Fragment {
		 @Override
	        public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                Bundle savedInstanceState) {

		     return inflater.inflate(R.layout.second, container, false);
	        }
	}
	public static class ThirdFragment extends Fragment {
			
		 @Override
	        public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                Bundle savedInstanceState) {
		        getActivity().setContentView(R.layout.third);
		        ViewGroup layout = (ViewGroup)getActivity().findViewById(R.id.linearLayout);
		        for(int i =0;i<20;i++){
		        	Button button = new Button(getActivity());
		        	button.setText("Button_"+i);
		        	layout.addView(button);
		        }

		     return inflater.inflate(R.layout.third, container, false);
	        }
	  }

}
 