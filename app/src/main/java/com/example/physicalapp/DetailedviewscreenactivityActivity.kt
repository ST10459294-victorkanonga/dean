

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.physicalapp.R

class detailedviewscreenactivity : AppCompatActivity() {
    private lateinit var detailsTextView: TextView
    private lateinit var averageTextView: TextView
    private lateinit var backButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.detailedviewscreenactivity)

        detailsTextView = findViewById(R.id.detailsTextView)
        averageTextView = findViewById(R.id.avarageTextview)
        backButton = findViewById(R.id.backButton)

        val dates = intent.getStringArrayListExtra("dates") ?: arrayListOf()
        val morningScreenTimes = intent.getIntegerArrayListExtra("morningScreenTimes") ?: arrayListOf()
        val afternoonScreenTimes = intent.getIntegerArrayListExtra("afternoonScreenTimes") ?: arrayListOf()
        val activityNotes = intent.getStringArrayListExtra("activityNotes") ?: arrayListOf()

        val details = StringBuilder()
        var totalScreenTime = 0
        for (i in dates.indices) {
            details.append("${dates[i]}: Morning - ${morningScreenTimes[i]} mins, Afternoon - " +
                    "${afternoonScreenTimes[i]} mins, Notes - ${activityNotes[i]}\n")
            totalScreenTime += morningScreenTimes[i] + afternoonScreenTimes[i]
        }
        val averageScreenTime = if (dates.isNotEmpty()) totalScreenTime / dates.size else 0

        detailsTextView.text = details.toString()
        averageTextView.text = "Average screen time: $averageScreenTime mins"

        backButton.setOnClickListener {
            finish()
        }
    }
}