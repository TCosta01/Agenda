package com.example.calendario

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calendario.databinding.ActivityListaDadosBinding

class ListaDados : AppCompatActivity() {
    private lateinit var binding: ActivityListaDadosBinding
    private lateinit var adapter: ArrayAdapter<Utilizador>
    private var pos: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityListaDadosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val db = DatabaseHelper(this)

        val listaUtilizadores = db.utilizadorListSelectAll()
        db.utilizadorListSelectAll()


        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaUtilizadores)
        binding.listView.adapter = adapter
        adapter.notifyDataSetChanged()

        binding.listView.setOnItemClickListener { _, _, position, _ ->
            /*
            binding.textId.setText("ID: ${listaUtilizadores[position].id}")
            binding.editUsername.setText(listaUtilizadores[position].username)
            binding.editPassword.setText(listaUtilizadores[position].password)
            pos = position
            */
            var passandoID = listaUtilizadores[position].id.toString()
            var passandoBooking_Group_ID = listaUtilizadores[position].booking_group_id.toString()

            var passandoNome = listaUtilizadores[position].nome.toString()

            var passandoNumero = listaUtilizadores[position].numero.toString()
            var passandoEnderaco = listaUtilizadores[position].endereco.toString()
            var passandoDescricao = listaUtilizadores[position].descricao.toString()
            var passandoValor = listaUtilizadores[position].valor.toString()
            var passandoAno = listaUtilizadores[position].ano.toString()
            var passandoMes = listaUtilizadores[position].mes.toString()
            var passandoDia = listaUtilizadores[position].dia.toString()


            pos = position

            var i = Intent(this, EditarLista::class.java)
            i.putExtra("position",pos)
            i.putExtra("passandoID",passandoID)
            i.putExtra("passandoNome",passandoNome)
            i.putExtra("passandoBooking_Group_ID",passandoBooking_Group_ID)
            i.putExtra("passandoNumero",passandoNumero)
            i.putExtra("passandoEnderaco",passandoEnderaco)
            i.putExtra("passandoDescricao",passandoDescricao)
            i.putExtra("passandoValor",passandoValor)
            i.putExtra("passandoAno",passandoAno)
            i.putExtra("passandoMes",passandoMes)
            i.putExtra("passandoDia",passandoDia)
            startActivity(i)
        }

        binding.buttonBuscar.setOnClickListener {

            var palavra = binding.editPalavraChave.text.toString()
            var anoP = binding.editAno.text.toString()
            var mesP = binding.editMes.text.toString()



            val especificolistaUtilizadores = db.especificoUtilizadorListSelectAll(palavra, anoP, mesP)
            db.especificoUtilizadorListSelectAll(palavra, anoP, mesP)


            adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, especificolistaUtilizadores)
            binding.listView.adapter = adapter


            adapter.notifyDataSetChanged()
        }


    }
}