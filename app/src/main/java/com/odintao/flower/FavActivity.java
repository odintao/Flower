package com.odintao.flower;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.odintao.adapter.ShowListImgAdapter;
import com.odintao.java.DatabaseHandler;
import com.odintao.model.Movie;
import com.odintao.model.ObjectFav;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Odin on 4/17/2016.
 */
public class FavActivity extends Fragment {

    // Declare variables
    private ProgressDialog pDialog;
    private List<Movie> movieList = new ArrayList<Movie>();
    private ListView listView;
    private ShowListImgAdapter adapter;
    GridView gridView;
    String cateId="";

    String[] allobjImg;
    List<ObjectFav> allData;
    public DatabaseHandler db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_main, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        gridView = (GridView)  getView().findViewById(R.id.gdVw);
        adapter = new ShowListImgAdapter(getActivity(), movieList);
        gridView.setAdapter(adapter);


//        Intent intent = getIntent();
//        cateId = intent.getStringExtra("CATEID");
//
//        System.out.println("-----------------------------------MainActi cateid:" + cateId);
//        pDialog = new ProgressDialog(this);
//        // Showing progress dialog before making http request
//        pDialog.setMessage(getResources().getString(R.string.load_data));
//        pDialog.show();

        db = new DatabaseHandler(getActivity());
        allData = db.getAllData();
        for(ObjectFav obj : allData) {
            Movie movie = new Movie();
            movie.setThumbnailUrl(obj.getImageurl());
            movie.setObjId(obj.getImageName());
            movieList.add(movie);
        }
        ArrayList<String> lstobjImg = new ArrayList<String>();
        for (Movie mv : movieList) {
            lstobjImg.add(mv.getThumbnailUrl());
        }
        allobjImg = lstobjImg.toArray(new String[0]);
        adapter.notifyDataSetChanged();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                TextView c = (TextView) v.findViewById(R.id.txtUrl_dtl);
                String objImgUrl = c.getText().toString();
                Intent intent = new Intent(getActivity().getApplicationContext(),
                        ShowImgActivity.class);
                intent.putExtra("objImgUrl", objImgUrl);
                intent.putExtra("allobjImg", allobjImg);
                intent.putExtra("ISFAV", "Y");
                startActivity(intent);
            }
        });
    }
    public void onResume() {
        super.onResume();
        adapter = new ShowListImgAdapter(getActivity(), movieList);
        gridView.setAdapter(adapter);

        db = new DatabaseHandler(getActivity());
        allData = db.getAllData();
        for(ObjectFav obj : allData) {
            Movie movie = new Movie();
            movie.setThumbnailUrl(obj.getImageurl());
            movie.setObjId(obj.getImageName());
            movieList.add(movie);
        }
        ArrayList<String> lstobjImg = new ArrayList<String>();
        for (Movie mv : movieList) {
            lstobjImg.add(mv.getThumbnailUrl());
        }
        allobjImg = lstobjImg.toArray(new String[0]);
        adapter.notifyDataSetChanged();
    }
}
