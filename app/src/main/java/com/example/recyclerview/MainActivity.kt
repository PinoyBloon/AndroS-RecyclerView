package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
            val intent = Intent (this, DetailDragonActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)

        }
    }
}