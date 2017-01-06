package ojh102.github.com.baseproject.common

import android.app.Activity
import android.support.v4.app.Fragment
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

/**
 * Created by ohjaehwan on 2017. 1. 4..
 */
fun Activity.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}

fun Fragment.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, message, length).show()
}

fun ImageView.loadImage(url: String) {
    Glide.with(context).load(url).into(this)
}