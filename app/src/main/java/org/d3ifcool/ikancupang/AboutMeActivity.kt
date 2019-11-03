package org.d3ifcool.ikancupang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class AboutMeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)

        val actionbar = supportActionBar
        actionbar!!.title = "Tentang Saya"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val me: ImageView = findViewById(R.id.img_photo)

        val profile = "https://www.dicoding.com/images/small/avatar/2019100622475317f66215d8ee74c78249da0a02c253f0.jpg"

        Glide.with(this)
            .load(profile)
            .apply(RequestOptions())
            .into(me)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
