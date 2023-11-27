package d.tmesaric.jadrijazadatak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import d.tmesaric.jadrijazadatak.R
import d.tmesaric.jadrijazadatak.domain.model.Zadatak

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val zadatak: Zadatak? = intent.getSerializableExtra("zadatak") as? Zadatak
        Log.d("TAG", zadatak?.title!!)
    }
}