package d.tmesaric.jadrijazadatak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.viewModels
import d.tmesaric.jadrijazadatak.R
import d.tmesaric.jadrijazadatak.domain.model.Zadatak
import d.tmesaric.jadrijazadatak.presentation.ZadatakEvent
import d.tmesaric.jadrijazadatak.presentation.ZadatakViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {
    private val viewModel: ZadatakViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val tvDetailsTitle: TextView = findViewById(R.id.tvDetailsTitle)
        val tvDetailsContent: TextView = findViewById(R.id.tvDetailsContent)
        val tvTimeStamp: TextView = findViewById(R.id.tvTimeStamp)
        val cbDetailsComplete: CheckBox = findViewById(R.id.cbDetailsComplete)
        val zadatak: Zadatak? = intent.getSerializableExtra("zadatak", Zadatak::class.java)

        try {
            tvDetailsTitle.text = zadatak?.title
            tvDetailsContent.text = zadatak?.content

            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
            tvTimeStamp.text = sdf.format(Date(zadatak?.timestamp!!))
            cbDetailsComplete.isChecked = zadatak.isComplete
            cbDetailsComplete.setOnCheckedChangeListener { _, isChecked ->
                zadatak.isComplete = isChecked
                viewModel.onEvent(ZadatakEvent.AddZadatak(zadatak))
            }
        } catch (e: Exception) {
            e.printStackTrace()
            finish()
        }
    }
}