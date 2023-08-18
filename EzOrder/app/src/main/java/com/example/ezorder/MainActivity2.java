package com.example.ezorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraPosition;
import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.Overlay;
import com.naver.maps.map.util.MarkerIcons;

public class MainActivity2 extends AppCompatActivity
        implements OnMapReadyCallback {
    private MapView mapView;
    private static NaverMap naverMap;

    //마커 변수 선언 및 초기화
    private Marker marker1 = new Marker();
    private Marker marker2 = new Marker();
    private Marker marker3 = new Marker();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Button btnMark = findViewById(R.id.btnmark);

//        setMarker(marker1, 35.1560157, 129.0594088, R.drawable.marker, 0);
//        setMarker(marker2, 35.156071, 129.0588261, R.drawable.marker, 1);
//        setMarker(marker3, 35.1560, 129.06, R.drawable.marker, 2);
//        Button btnMark2 = findViewById(R.id.btnmark2);
//        Button btnMark3 = findViewById(R.id.btnmark3);
//
//        btnMark1.setOnClickListener(new Button.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                setMarker(marker1, 33.2712, 126.5354, R.drawable.marker, 0);
//
//                marker1.setOnClickListener(new Overlay.OnClickListener() {
//                    @Override
//                    public boolean onClick(@NonNull Overlay overlay)
//                    {
//                        Toast.makeText(getApplication(), "마커1 클릭", Toast.LENGTH_SHORT).show();
//                        return false;
//                    }
//                });
//            }
//        });
//
//
        btnMark.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setMarker(marker1, 35.1560157, 129.0594088, R.drawable.marker, 0);
                setMarker(marker2, 35.156071, 129.0588261, R.drawable.marker, 1);
                setMarker(marker3, 35.1560, 129.06, R.drawable.marker, 2);

            }
        });
//
//        btnMark3.setOnClickListener(new Button.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                setMarker(marker3, 33.49957, 126.531128, R.drawable.marker, 0);
//            }
//        });


//        //네이버 지도
        mapView = findViewById(R.id.map_view);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
    }

    private void setMarker(Marker marker,  double lat, double lng, int resourceID, int zIndex)
    {
        //원근감 표시
        //marker.setIconPerspectiveEnabled(true);
        //아이콘 지정

        marker.setIcon(MarkerIcons.RED);
        //마커의 투명도
        marker.setAlpha(0.8f);
        //마커 위치
        marker.setPosition(new LatLng(lat, lng));
        //마커 우선순위
        marker.setZIndex(zIndex);
        //마커 표시
        marker.setMap(naverMap);
    }


    @Override
    public void onMapReady(@NonNull NaverMap naverMap)
    {
        this.naverMap = naverMap;

        //배경 지도 선택
        naverMap.setMapType(NaverMap.MapType.Navi);

        //건물 표시
        naverMap.setLayerGroupEnabled(naverMap.LAYER_GROUP_BUILDING, true);

        //위치 및 각도 조정
//        CameraPosition cameraPosition = new CameraPosition(
//                new LatLng(33.38, 126.55),   // 위치 지정
//                9,                                     // 줌 레벨
//                45,                                       // 기울임 각도
//                0                                     // 방향
//        );
        //naverMap.setCameraPosition(cameraPosition);

        setMarker(marker1, 35.1560157, 129.0594088, R.drawable.marker, 0);
        setMarker(marker2, 35.156071, 129.0588261, R.drawable.marker, 1);
        setMarker(marker3, 35.1560, 129.06, R.drawable.marker, 2);
    }

    @Override
    public void onStart()
    {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume()
    {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause()
    {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop()
    {
        super.onStop();
        mapView.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory()
    {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}