package com.other.horoscope.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.other.horoscope.App;
import com.other.horoscope.R;
import com.other.horoscope.internal.di.component.DaggerSunsignModelComponent;
import com.other.horoscope.internal.mvp.presenter.SunsignPresenter;
import com.other.horoscope.internal.mvp.view.SunsignView;
import com.other.horoscope.model.Sunsign;
import com.other.horoscope.preference.AppSharePreference;
import com.other.horoscope.ui.adapter.SunsignAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import easymvp.annotation.FragmentView;
import easymvp.annotation.Presenter;

/**
 * A placeholder fragment containing a simple view.
 */
@FragmentView(presenter = SunsignPresenter.class)
public class ContentFragment extends BaseFragment implements SunsignView, AdapterView.OnItemClickListener {

    @Inject
    @Presenter
    SunsignPresenter presenter;

    @Inject
    AppSharePreference sharePreference;

    @BindView(R.id.rvhoroscope)
    RecyclerView recyclerView;

    @BindView(R.id.adView)
    AdView adView;

    SunsignAdapter adapter;

    public ContentFragment() {
    }

    public static ContentFragment newInstance() {
        
        Bundle args = new Bundle();
        
        ContentFragment fragment = new ContentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerSunsignModelComponent.builder().appComponent(App.getAppComponent()).build().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("EA876E4F8E664BBFBDBD1189D31D8683")
                .build();

        adView.loadAd(adRequest);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(),3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onRequest() {

    }

    @Override
    public void populate(List<Sunsign> data) {
        adapter = new SunsignAdapter(data, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        sharePreference.setString("sun8",adapter.getList().get(i).getSuns8());
        sharePreference.setInt("res",adapter.getList().get(i).getRes());
        sharePreference.setString("date",adapter.getList().get(i).getDate());
        sharePreference.setInt("color",adapter.getList().get(i).getColor());
        getActivity().getSupportFragmentManager().beginTransaction().add(R.id.container, DetailFragment.newInstance()).addToBackStack("Hello").commit();
    }

    @Override
    public void onPause() {
        if (adView != null) {
            adView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adView != null) {
            adView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }
}
