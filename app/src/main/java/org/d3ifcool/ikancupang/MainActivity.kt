package org.d3ifcool.ikancupang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvFish: RecyclerView
    private var list: ArrayList<Fish> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionBar = supportActionBar
        actionBar!!.title = "Jenis Ikan Cupang"

        rvFish = findViewById(R.id.rv_ikan)
        rvFish.setHasFixedSize(true)

        list.addAll(FishData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvFish.layoutManager = LinearLayoutManager(this)
        rvFish.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        val listFishAdapter = ListFistAdapter(list)
        rvFish.adapter = listFishAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selected: Int) {
        when (selected){
            R.id.me -> {
                val aboutMe = Intent(this@MainActivity, AboutMeActivity::class.java)
                startActivity(aboutMe)
            }
        }
    }
}
