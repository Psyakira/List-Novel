package com.example.android_beginner

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailNovel : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_novel)

        val dataNovel = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("key_novel", Novel::class.java)
        }
        else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("key_novel")
        }

        val tvDetailTittle: TextView = findViewById(R.id.tv_detailtittle)
        val tvDetailSinopsis: TextView = findViewById(R.id.tv_detailsinopsis)
        val ivDetailCover: ImageView = findViewById(R.id.iv_detailcover)
        val tvDetailPrice: TextView = findViewById(R.id.tv_detailprice)
        val tvDetailPublisher: TextView = findViewById(R.id.tv_detailpublisher)

        tvDetailTittle.text = dataNovel?.tittle
        tvDetailSinopsis.text = dataNovel?.sinopsis
        tvDetailPrice.text = dataNovel?.price
        tvDetailPublisher.text = dataNovel?.publisher
        dataNovel?.cover?.let { ivDetailCover.setImageResource(it) }

    }
}