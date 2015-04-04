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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

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
			 
			 
			 
			 View Third=(View) inflater.inflate(R.layout.third, container, false);
			 
			  Button banana=(Button) Third.findViewById(R.id.button1);
			  Button banana2=(Button) Third.findViewById(R.id.button2);
			  Button banana3=(Button) Third.findViewById(R.id.button3);
			  
			  banana.setOnClickListener(new View.OnClickListener() {
			        @Override
			        public void onClick(View Third) {
			        	
			        	ImageView image=(ImageView) getActivity().findViewById(R.id.categoria);
			        	TextView text1=(TextView) getActivity().findViewById(R.id.nome_categoria);
			        	TextView text2=(TextView) getActivity().findViewById(R.id.descrizione);
			        	
			        	if(image.getVisibility()==android.view.View.VISIBLE){
			        		
			        		image.setVisibility(android.view.View.GONE);
			        		text1.setVisibility(android.view.View.GONE);
			        		text2.setVisibility(android.view.View.GONE);
			        	}
			        	else{
			        		image.setVisibility(android.view.View.VISIBLE);
			        		text1.setVisibility(android.view.View.VISIBLE);
			        		text2.setVisibility(android.view.View.VISIBLE);	
			        	}
			        }
			    });
			  
			  banana2.setOnClickListener(new View.OnClickListener() {
			        @Override
			        public void onClick(View Third) {
			        	
			        	ImageView image=(ImageView) getActivity().findViewById(R.id.categoria2);
			        	TextView text1=(TextView) getActivity().findViewById(R.id.nome_categoria2);
			        	TextView text2=(TextView) getActivity().findViewById(R.id.descrizione2);
			        	
			        	if(image.getVisibility()==android.view.View.VISIBLE){
			        		
			        		image.setVisibility(android.view.View.GONE);
			        		text1.setVisibility(android.view.View.GONE);
			        		text2.setVisibility(android.view.View.GONE);
			        	}
			        	else{
			        		image.setVisibility(android.view.View.VISIBLE);
			        		text1.setVisibility(android.view.View.VISIBLE);
			        		text2.setVisibility(android.view.View.VISIBLE);	
			        	}
			        }
			    });
			  
			  banana3.setOnClickListener(new View.OnClickListener() {
			        @Override
			        public void onClick(View Third) {
			        	
			        	ImageView image=(ImageView) getActivity().findViewById(R.id.categoria3);
			        	TextView text1=(TextView) getActivity().findViewById(R.id.nome_categoria3);
			        	TextView text2=(TextView) getActivity().findViewById(R.id.descrizione3);
			        	
			        	if(image.getVisibility()==android.view.View.VISIBLE){
			        		
			        		image.setVisibility(android.view.View.GONE);
			        		text1.setVisibility(android.view.View.GONE);
			        		text2.setVisibility(android.view.View.GONE);
			        	}
			        	else{
			        		image.setVisibility(android.view.View.VISIBLE);
			        		text1.setVisibility(android.view.View.VISIBLE);
			        		text2.setVisibility(android.view.View.VISIBLE);	
			        	}
			        }
			    });

		     return Third;
	        }
		 
		 
		 
	  }

}
 