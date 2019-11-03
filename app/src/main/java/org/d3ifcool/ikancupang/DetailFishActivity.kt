package org.d3ifcool.ikancupang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.uncopt.android.widget.text.justify.JustifiedTextView

class DetailFishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_fish)
        val actionBar = supportActionBar
        actionBar!!.title = "Detail Ikan Cupang"
        actionBar.setDisplayHomeAsUpEnabled(true)

        val tvSetName: TextView = findViewById(R.id.detailName)
        val tvSetType: TextView = findViewById(R.id.detailType)
        val tvSetPhoto: ImageView = findViewById(R.id.detailImage)
        val tvSetDesc: TextView = findViewById(R.id.detailDesc)

        val dName = intent.getStringExtra(EXTRA_NAME)
        val dType = intent.getStringExtra(EXTRA_TYPE)
        val dPhoto = intent.getStringExtra(EXTRA_PHOTO)
        val dDesc = intent.getStringExtra(EXTRA_DESC)

        tvSetName.text = dName
        tvSetType.text = dType
        Glide.with(this)
            .load(dPhoto)
            .apply(RequestOptions())
            .into(tvSetPhoto)
        tvSetDesc.text = dDesc
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_TYPE = "extra_type"
        const val EXTRA_DESC = "extra_desc"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
