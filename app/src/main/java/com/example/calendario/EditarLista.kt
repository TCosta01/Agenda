package com.example.calendario

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calendario.databinding.ActivityEditarListaBinding
import com.example.calendario.databinding.ActivityListaDadosBinding

class EditarLista : AppCompatActivity() {

    private lateinit var binding: ActivityEditarListaBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityEditarListaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val db = DatabaseHelper(this)



        val i = intent
        var position = i.extras?.getInt(("position"))
        var recebeuID = i.extras?.getString("passandoID")
        var passandoBooking_Group_ID = i.extras?.getString("passandoBooking_Group_ID")
        var passandoNome = i.extras?.getString("passandoNome")

        var passandoNumero = i.extras?.getString("passandoNumero")
        var passandoEnderaco = i.extras?.getString("passandoEnderaco")
        var passandoDescricao = i.extras?.getString("passandoDescricao")
        var passandoValor = i.extras?.getString("passandoValor")
        var passandoAno = i.extras?.getString("passandoAno")
        var passandoMes = i.extras?.getString("passandoMes")
        var passandoDia = i.extras?.getString("passandoDia")





        binding.nameEditText.setText(passandoNome)
        binding.numberEditText.setText(passandoNumero)
        binding.descriptionEditText.setText(passandoDescricao)
        binding.valueEditText.setText(passandoValor)
        binding.addressEditText.setText(passandoEnderaco)
        binding.bookingDatesTextView.setText("Datas da Reserva: ${db.listaTodosOsDiasReservados(passandoNome.toString(), passandoNumero.toString(), passandoEnderaco.toString(), passandoDescricao.toString(), passandoValor.toString())}.")



        binding.atualizarButton.setOnClickListener {

            var nomeAntigo = passandoNome.toString()
            var numeroAntigo = passandoNumero.toString()
            var enderecoAntigo = passandoEnderaco.toString()
            var decricaoAntiga = passandoDescricao.toString()
            var valorAntigo = passandoValor.toString()

            var nomeNovo = binding.nameEditText.text.toString()
            var numeroNovo = binding.numberEditText.text.toString()
            var enderecoNovo = binding.addressEditText.text.toString()
            var decricaoNovo = binding.descriptionEditText.text.toString()
            var valorNovo = binding.valueEditText.text.toString()

            db.atualizarDiretoDaListaa(nomeAntigo,numeroAntigo,enderecoAntigo,decricaoAntiga,valorAntigo,nomeNovo, numeroNovo, enderecoNovo, decricaoNovo,valorNovo)
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.deleteButton.setOnClickListener {

            var n = passandoNome.toString()
            var nu = passandoNumero.toString()
            var e = passandoEnderaco.toString()
            var d = passandoDescricao.toString()
            var v = passandoValor.toString()

            db.deletaDiretoDaLista(n,nu,e,d,v)

            startActivity(Intent(this, MainActivity::class.java))
        }






    }
}