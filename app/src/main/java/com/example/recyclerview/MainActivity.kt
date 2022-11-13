package com.example.recyclerview

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    lateinit var toggle: ActionBarDrawerToggle

    /** Toolbar Code */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        /** Kode NavDraw nyelip dikit gapapa lahh */
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        /** END */

        when (item.itemId) {

            R.id.tb_add -> Toast.makeText(this, "You added another Entry!", Toast.LENGTH_SHORT)
                .show()
            R.id.tb_fav -> Toast.makeText(
                this,
                "You liked this? Thank you kindly!!",
                Toast.LENGTH_SHORT
            ).show()
            R.id.tb_settings -> Toast.makeText(this, "YOU SHALL NOT PASS!!!!", Toast.LENGTH_SHORT)
                .show()

        }
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /** Navigation Drawer Core Code */
        val drawerLayout: DrawerLayout = findViewById(R.id.navdraw_layout)
        val navView: NavigationView = findViewById(R.id.navdraw_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.navdraw_account -> Toast.makeText(
                    this,
                    "Account? What's that?",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.navdraw_logout -> Toast.makeText(
                    this,
                    "You don't even have an account!",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.navdraw_share -> Toast.makeText(
                    this,
                    "Thanks for sharing!",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.navdraw_rate -> Toast.makeText(
                    this,
                    "How would you rate us from 1 to 10?",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.navdraw_contact -> Toast.makeText(this, "CAN'T WE'RE BUSY", Toast.LENGTH_SHORT)
                    .show()
            }

            true

        }
        /** END */

        val dragonsList = listOf<Dragons>(
            Dragons(
                R.drawable.azrefoth,
                "Azrefoth the Doombringer",
                "Bearing the title Dragon of Doom, Azrefoth brought destruction upon where he fly." +
                        "\nWas last seen hovering above Kinkyall Volcano 200 years ago, probably looking for a spot to hibernate, or worse; incubating his eggs." +
                        "\n| High Scholar of Karakan, Glendale Hazermoth |"
            ),
            Dragons(
                R.drawable.hafrum,
                "Hafrum the Jailer",
                "Hafrum the Jailer was tasked with holding the Great Evil Fzoddkr from escaping." +
                        "\nWhen the Great Evil managed to escape 150 years ago, Hafrum fought him to the point of separating the Great Continent." +
                        "\nFortunately, Hafrum killed Fzoddkr. This image are illustration when he emerged victorious against Fzoddkr." +
                        "\nHe was never seen ever since. The last time someone managed to see him, he flew over Llordorn, into the Snowy Mountains of Brizzk 50 years ago." +
                        "\n| High Scholar of Karakan, Glendale Hazermoth |"
            ),
            Dragons(
                R.drawable.raphtoz,
                "Raphtoz the Hunter",
                "True to his title, Raphtoz was a magnificent hunter." +
                        "\nHis greatest kill was probably the Lord of The Lake Kindjall, a massive serpent who guards the Lake of Dreams." +
                        "\nFortunately, since his failure hunting Zark the Wise 125 years ago, nobody ever saw him again." +
                        "\nLet's hope he stays silent. We don't want another Age of Hunt again." +
                        "\n| High Scholar of Karakan, Glendale Hazermoth |"
            ),
            Dragons(
                R.drawable.hykars,
                "Hykars the Liberator",
                "Hykars the Liberator helped Zark the Wise on freeing the world from the Age of Hunt, instigated by Raphtoz the Hunter." +
                        "\nEverybody says that, but in reality, he betrayed Raphtoz in the middle of Great Hunt, causing Raphtoz to fail." +
                        "\nHow do i know of that? Hohohoho, that's a secret i will take to the grave honey." +
                        "\n| High Scholar of Karakan, Glendale Hazermoth |"
            ),

            )

        val recyclerView = findViewById<RecyclerView>(R.id.rv_dragon)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = DragonsAdapter(this, dragonsList) {
            val intent = Intent(this, DetailDragonActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)

        }
    }
}