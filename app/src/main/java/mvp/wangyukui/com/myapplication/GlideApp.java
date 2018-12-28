package mvp.wangyukui.com.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.RequestManager;

import java.io.File;

/**
 * The entry point for interacting with Glide for Applications
 *
 * <p>Includes all generated APIs from all
 * {@link com.bumptech.glide.annotation.GlideExtension}s in source and dependent libraries.
 *
 * <p>This class is generated and should not be modified
 * @see Glide
 */
public final class GlideApp {
  private GlideApp() {
  }

  /**
   * @see Glide#getPhotoCacheDir(Context)
   */
  @Nullable
  public static File getPhotoCacheDir(@NonNull Context arg0) {
    return Glide.getPhotoCacheDir(arg0);
  }

  /**
   * @see Glide#getPhotoCacheDir(Context, String)
   */
  @Nullable
  public static File getPhotoCacheDir(@NonNull Context arg0, @NonNull String arg1) {
    return Glide.getPhotoCacheDir(arg0, arg1);
  }

  /**
   * @see Glide#get(Context)
   */
  @NonNull
  public static Glide get(@NonNull Context arg0) {
    return Glide.get(arg0);
  }

  /**
   * @see Glide#init(Glide)
   */
  @Deprecated
  @VisibleForTesting
  @SuppressLint("VisibleForTests")
  public static void init(Glide glide) {
    Glide.init(glide);
  }

  /**
   * @see Glide#init(Context, GlideBuilder)
   */
  @VisibleForTesting
  @SuppressLint("VisibleForTests")
  public static void init(@NonNull Context arg0, @NonNull GlideBuilder arg1) {
    Glide.init(arg0, arg1);
  }

  /**
   * @see Glide#tearDown()
   */
  @VisibleForTesting
  @SuppressLint("VisibleForTests")
  public static void tearDown() {
    Glide.tearDown();
  }

  /**
   * @see Glide#with(Context)
   */
  @NonNull
  public static GlideRequests with(@NonNull Context arg0) {
    return (GlideRequests) Glide.with(arg0);
  }

  /**
   * @see Glide#with(Activity)
   */
  @NonNull
  public static GlideRequests with(@NonNull Activity arg0) {
    return (GlideRequests) Glide.with(arg0);
  }

  /**
   * @see Glide#with(FragmentActivity)
   */
  @NonNull
  public static GlideRequests with(@NonNull FragmentActivity arg0) {
    if (Glide.with(arg0) instanceof GlideRequests){
      return (GlideRequests) Glide.with(arg0);
    }
    RequestManager manager= Glide.with(arg0);
    GlideRequests requests= (GlideRequests) manager;
    return requests;
  }

  /**
   * @see Glide#with(Fragment)
   */
  @NonNull
  public static GlideRequests with(@NonNull Fragment arg0) {
    return (GlideRequests) Glide.with(arg0);
  }

  /**
   * @see Glide#with(Fragment)
   */
  @NonNull
  public static GlideRequests with(@NonNull android.support.v4.app.Fragment arg0) {
    return (GlideRequests) Glide.with(arg0);
  }

  /**
   * @see Glide#with(View)
   */
  @NonNull
  public static GlideRequests with(@NonNull View arg0) {
    return (GlideRequests) Glide.with(arg0);
  }
}
