package com.example.android_beginner

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvNovel: RecyclerView
    private val list = ArrayList<Novel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvNovel = findViewById(R.id.rv_novel)
        rvNovel.setHasFixedSize(true)

        list.addAll(getListNovel())
        showRecyclerList()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.it_about -> {
                val moveIntent = Intent(this@MainActivity, AboutPage::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }


    private fun getListNovel(): ArrayList<Novel> {
        val dataTittle = resources.getStringArray(R.array.data_tittle)
        val dataSinopsis = resources.getStringArray(R.array.data_sinopsis)
        val dataPrice = resources.getStringArray(R.array.data_price)
        val dataPublisher = resources.getStringArray(R.array.data_publisher)
        val dataCover = resources.obtainTypedArray(R.array.data_cover)
        val listNovel = ArrayList<Novel>()
        for (i in dataTittle.indices) {
            val novel = Novel(dataTittle[i], dataSinopsis[i], dataPrice[i], dataPublisher[i], dataCover.getResourceId(i, -1))
            listNovel.add(novel)
        }
        return listNovel
    }

    private fun showRecyclerList() {
        rvNovel.layoutManager = LinearLayoutManager(this)
        val listNovelAdapter = ListNovelAdapter(list)
        rvNovel.adapter = listNovelAdapter

        listNovelAdapter.setOnItemClickCallback(object : ListNovelAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Novel) {
                showSelectedNovel(data)
            }
        })
    }
    private fun showSelectedNovel(novel: Novel) {
        startActivity(Intent(this, DetailNovel::class.java))
    }

}

