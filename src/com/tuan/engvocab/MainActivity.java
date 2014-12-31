package com.tuan.engvocab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// hide the action bar
		ActionBar actionBar = getSupportActionBar();
//		actionBar.hide();
		
		actionBar.setDisplayHomeAsUpEnabled(true);
		//set the title for actionbar
		actionBar.setTitle("TEST actionbar title");

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.main_actionbar, menu);

        // Calling super after populating the menu is necessary here to ensure that the
        // action bar helpers have a chance to handle this event.
        return super.onCreateOptionsMenu(menu);
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
		else if (id == R.id.action_help) {
			Toast.makeText(getApplicationContext(), "search help clicked", Toast.LENGTH_SHORT).show();
			Intent it = new Intent(this, StudyActivity.class);
			startActivity(it);
		}
		else if (id == R.id.action_share) {
			Toast.makeText(getApplicationContext(), "search share clicked", Toast.LENGTH_SHORT).show();
		}
		/*else if (id == R.id.action_search) {
			Toast.makeText(getApplicationContext(), "search button clicked", Toast.LENGTH_SHORT).show();
		}*/
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
