package com.other.horoscope.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.other.horoscope.App;
import com.other.horoscope.R;
import com.other.horoscope.internal.di.component.DaggerHoroscopeModelComponent;
import com.other.horoscope.internal.di.component.DaggerSunsignModelComponent;
import com.other.horoscope.internal.mvp.presenter.HoroscopePresenter;
import com.other.horoscope.internal.mvp.presenter.SunsignPresenter;
import com.other.horoscope.internal.mvp.view.HoroScopeView;
import com.other.horoscope.model.Horoscope;
import com.other.horoscope.preference.AppSharePreference;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import easymvp.annotation.FragmentView;
import easymvp.annotation.Presenter;

/**
 * A simple {@link Fragment} subclass.
 */
@FragmentView(presenter = HoroscopePresenter.class)
            public class DetailFragment extends BaseFragment implements HoroScopeView {

    @Inject
    @Presenter
    HoroscopePresenter presenter;

    @Inject
    AppSharePreference sharePreference;

    @BindView(R.id.txtday)
    TextView txtday;

    @BindView(R.id.txtweek)
    TextView txtweek;

    @BindView(R.id.txtmonth)
    TextView txtmonth;

    @BindView(R.id.txtyear)
    TextView txtyear;

    @BindView(R.id.barday)
    ProgressBar barday;

    @BindView(R.id.barweek)
    ProgressBar barweek;

    @BindView(R.id.barmonth)
    ProgressBar barmonth;

    @BindView(R.id.baryear)
    ProgressBar baryear;

    @BindView(R.id.txtdate)
    TextView txtdate;

    @BindView(R.id.txtborder)
    TextView txtborder;

    @BindView(R.id.txtname)
    TextView txtname;

    @BindView(R.id.imghoro)
    ImageView imgSunsign;


    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerHoroscopeModelComponent.builder().appComponent(App.getAppComponent()).build().inject(this);

    }

    public static DetailFragment newInstance() {
        
        Bundle args = new Bundle();
        
        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int color=sharePreference.getInt("color");
        String date=sharePreference.getString("date");
        String sun8=sharePreference.getString("sun8");
        int res=sharePreference.getInt("res");

        txtborder.setBackgroundColor(color);
        txtday.setText(date);
        txtname.setText(sun8);
        imgSunsign.setImageResource(res);
    }

    @Override
    public void onRequest() {

    }

    @Override
    public void showLoading() {
        txtday.setVisibility(View.INVISIBLE);
        txtweek.setVisibility(View.INVISIBLE);
        txtmonth.setVisibility(View.INVISIBLE);
        txtyear.setVisibility(View.INVISIBLE);

        barday.setVisibility(View.VISIBLE);
        barweek.setVisibility(View.VISIBLE);
        barmonth.setVisibility(View.VISIBLE);
        baryear.setVisibility(View.VISIBLE);

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showContent() {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void populateToday(Horoscope data) {
        txtday.setText(data.getHoroscope());
        txtday.setVisibility(View.VISIBLE);
        barday.setVisibility(View.INVISIBLE);

    }

    @Override
    public void populateWeek(Horoscope data) {
        txtweek.setText(data.getHoroscope());
        txtweek.setVisibility(View.VISIBLE);
        barweek.setVisibility(View.INVISIBLE);

    }

    @Override
    public void populateMonth(Horoscope data) {
        txtmonth.setText(data.getHoroscope());
        txtmonth.setVisibility(View.VISIBLE);
        barmonth.setVisibility(View.INVISIBLE);

    }

    @Override
    public void populateYear(Horoscope data) {
        txtyear.setText(data.getHoroscope());
        txtyear.setVisibility(View.VISIBLE);
        baryear.setVisibility(View.INVISIBLE);
    }
}
