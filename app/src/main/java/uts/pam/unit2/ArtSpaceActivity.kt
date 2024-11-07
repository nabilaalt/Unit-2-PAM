package uts.pam.unit2

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ArtSpaceActivity : AppCompatActivity() {

    private lateinit var artworkImage: ImageView
    private lateinit var artworkTitle: TextView
    private lateinit var artworkArtist: TextView

    // Sample list of artworks
    private val artworks = listOf(
        Pair("Mona Lisa", "Leonardo da Vinci"),
        Pair("Starry Night", "Vincent van Gogh"),
        Pair("The Scream,", "Edvard Munch")
    )
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        artworkImage = findViewById(R.id.artwork_image)
        artworkTitle = findViewById(R.id.artwork_title)
        artworkArtist = findViewById(R.id.artwork_artist)

        val previousButton: Button = findViewById(R.id.previous_button)
        val nextButton: Button = findViewById(R.id.next_button)

        updateArtwork()

        previousButton.setOnClickListener {
            if (currentIndex > 0) {
                currentIndex--
                updateArtwork()
            }
        }

        nextButton.setOnClickListener {
            if (currentIndex < artworks.size - 1) {
                currentIndex++
                updateArtwork()
            }
        }

        previousButton.setOnLongClickListener {
            Toast.makeText(this, "Go to previous artwork", Toast.LENGTH_SHORT).show()
            true
        }

        nextButton.setOnLongClickListener {
            Toast.makeText(this, "Go to next artwork", Toast.LENGTH_SHORT).show()
            true
        }
    }

    private fun updateArtwork() {
        val currentArtwork = artworks[currentIndex]
        artworkTitle.text = currentArtwork.first
        artworkArtist.text = currentArtwork.second
    }
}