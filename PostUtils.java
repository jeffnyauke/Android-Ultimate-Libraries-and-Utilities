package com.example.jeffreynyauke.myapplication.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.util.Log;
import android.view.View;

import com.example.jeffreynyauke.myapplication.MainActivity;
import com.example.jeffreynyauke.myapplication.R;
import com.example.jeffreynyauke.myapplication.models.Post;
import com.example.jeffreynyauke.myapplication.services.MyDownloadService;

/**
 * Created by Jeffrey Nyauke on 2/2/2017.
 */

public class PostUtils {

    private static ProgressDialog mProgressDialog;
    public void navigateToGameDetails(Post post, View viewToshare) {

       /* Intent detailsActivityIntent = new Intent(activityContext, DetailsActivity.class);
        detailsActivityIntent.putExtra(DetailsActivity.GAME_EXTRA, Parcels.wrap(game));

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                (Activity) activityContext, viewToshare, "sharedImage");

        ActivityCompat.startActivity((Activity) activityContext, detailsActivityIntent, options.toBundle());*/
    }

    public static void beginDownload(String folder, String name, Context context) {
        // Get path
        String path = folder + name;

        // Kick off MyDownloadService to download the file
        Intent intent = new Intent(context, MyDownloadService.class)
                .putExtra(MyDownloadService.EXTRA_DOWNLOAD_PATH, path)
                .setAction(MyDownloadService.ACTION_DOWNLOAD);
        context.startService(intent);

        // Show loading spinner
        showProgressDialog(context.getString(R.string.progress_downloading), context);
    }

    private static void showProgressDialog(String caption, Context context) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(context);
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.setMessage(caption);
        mProgressDialog.show();
    }

    private void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }
}
