package ru.home.mvpapplicationdemo;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import ru.home.mvpapplicationdemo.contact.ContactFragment;
import ru.home.mvpapplicationdemo.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements BaseFragment.OnFragmentInteractionListener,
        ContactFragment.OnListFragmentInteractionListener {

    private static final String CURRENT_FRAGMENT_TAG = "current_fragment_tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_base);

        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            Bundle args = new Bundle();//getIntent().getBundleExtra(BaseActivity.KEY_BUNDLE);
            transaction.add(R.id.container, createFragment(args), CURRENT_FRAGMENT_TAG);
            transaction.commit();
        }
    }

    private Fragment createFragment(Bundle args) {
        return new ContactFragment();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Toast.makeText(this, uri.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        // TODO: implement
    }
}
