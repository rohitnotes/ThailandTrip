package com.yanin.thailandtrip.framework;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.yanin.thailandtrip.db.Schedule;


public class IntentUtil {

    public static String PACKAGE_GOOGLE_MAP = "com.google.android.apps.maps";

    public static boolean openGoogleMap(Schedule schedule, Context context){
        String mapUri = toMapFormat(schedule.getLongitude(), schedule.getLatitude(), schedule.getLocation());
        Uri uri = Uri.parse(mapUri);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri);
        mapIntent.setPackage(PACKAGE_GOOGLE_MAP);

        if (mapIntent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(mapIntent);
            return true;
        }else{
            return false;
        }
    }

    private static String toMapFormat(String longitude, String latitude, String description){
        return "geo:0,0?q=" + latitude + "," + longitude + "(" + description + ")";
    }
}
