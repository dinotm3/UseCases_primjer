package d.tmesaric.jadrijazadatak

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import d.tmesaric.jadrijazadatak.domain.model.Zadatak
import d.tmesaric.jadrijazadatak.presentation.ZadatakEvent
import d.tmesaric.jadrijazadatak.presentation.ZadatakViewModel
import d.tmesaric.jadrijazadatak.presentation.recycler_view.ZadatakAdapter
import dagger.hilt.android.AndroidEntryPoint
import java.util.Date
import java.time.LocalDateTime

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: ZadatakViewModel by viewModels()
    private lateinit var adapter: ZadatakAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvZadatak = findViewById<RecyclerView>(R.id.rvZadatak)
        val btnAddZadatak = findViewById<Button>(R.id.btnAddZadatak)

        lifecycleScope.launchWhenStarted {
            viewModel.state.collect { state ->
                Log.d("MainActivity", "Observed data: ${state.zadaci}")
                adapter = ZadatakAdapter(state.zadaci)
                Log.d("TAG", viewModel.state.value.zadaci.toString())
                rvZadatak.adapter = adapter

            }
        }

        rvZadatak.layoutManager = LinearLayoutManager(this)

        btnAddZadatak.setOnClickListener {
            showPopup(this, adapter)
        }
    }

    private fun showPopup(context: Context, adapter: ZadatakAdapter) {
        val builder = AlertDialog.Builder(context)
        val inflater = LayoutInflater.from(context)
        val dialogView: View = inflater.inflate(R.layout.popup, null)

        val etTitle: EditText = dialogView.findViewById(R.id.etTitle)
        val etContent: EditText = dialogView.findViewById(R.id.etContent)

        builder.setView(dialogView)
            .setPositiveButton("Submit") { dialog, which ->

                val title = etTitle.text.toString()
                val content = etContent.text.toString()
                val zadatak = Zadatak(null, title, content, System.currentTimeMillis(), false)
                viewModel.onEvent(ZadatakEvent.AddZadatak(zadatak))
                adapter.notifyItemInserted(adapter.zadaci.size - 1)
                Log.d("TAG", adapter.zadaci.toString())

            }
            .setNegativeButton("Cancel") { dialog, which ->
                dialog.dismiss()
            }
            .show()
    }
}