package org.wit.assignment1_hillfort.activities


import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_hillfort_list.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivityForResult
import org.wit.assignment1_hillfort.R
import org.wit.assignment1_hillfort.main.MainApp
import org.wit.assignment1_hillfort.models.HillfortModel
import kotlinx.android.synthetic.main.activity_login.*


class HillfortListActivity : AppCompatActivity(), HillfortListener {



    lateinit var app: MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hillfort_list)


        app = application as MainApp
        btnLogout.setOnClickListener{
     //if the logout is selected the clear the loggedinuser to be completed and go back to the login screen
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
         }
        toolbar.title = title
        setSupportActionBar(toolbar)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        loadHillforts()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.item_add -> startActivityForResult<HillfortActivity>(0)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onHillfortClick(hillfort: HillfortModel) {
        startActivityForResult(intentFor<HillfortActivity>().putExtra("hillfort_edit", hillfort), 0)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        loadHillforts()
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun loadHillforts() {
        showHillforts(app.hillforts.findAll())
    }

    fun showHillforts (hillforts: List<HillfortModel>) {
        recyclerView.adapter = HillfortAdapter(hillforts, this)
        recyclerView.adapter?.notifyDataSetChanged()
    }


}