package ipca.calorias.a22735

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.*

class MainActivity : AppCompatActivity() {

    var alimentos: List<Alimento> = arrayListOf(
        Alimento("Maça", 123.00, false),
        Alimento("Batata", 141.76, false),
        Alimento("Bolacha Maria", 232.12, false),
        Alimento("Fiambre", 105.00, false),
        Alimento("Queijo", 108.00, false)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listViewAlimentos = findViewById<ListView>(R.id.listViewAlimentos)
        val alimentosAdapter = AlimentosAdapter()
        listViewAlimentos.adapter = alimentosAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_button, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_total -> {
                var total: Double = 0.0
                for (a in alimentos) {
                    if (a.isChecked == true) {
                        total += a.calorias!!
                    }
                }
                Toast.makeText( this@MainActivity, "Total : $total", Toast.LENGTH_SHORT).show()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

        inner class AlimentosAdapter : BaseAdapter() {
            override fun getCount(): Int {
                return alimentos.size
            }

            override fun getItem(position: Int): Any {
                return alimentos[position]
            }

            override fun getItemId(position: Int): Long {
                return 0
            }

            override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {

                val rootView = layoutInflater.inflate(R.layout.row_content, viewGroup, false)
                val textViewNome = rootView.findViewById<TextView>(R.id.textViewNome)
                val textViewCalorias = rootView.findViewById<TextView>(R.id.textViewCalorias)
                val checkBox = rootView.findViewById<CheckBox>(R.id.checkBox)

                // preencher views
                textViewNome.text = alimentos[position].name
                textViewCalorias.text = alimentos[position].calorias.toString()

                checkBox.setOnClickListener {
                    if (checkBox.isChecked) {
                        alimentos[position].isChecked = true
                    } else {
                        alimentos[position].isChecked = false
                    }
                }

                return rootView

            }

        }
    }