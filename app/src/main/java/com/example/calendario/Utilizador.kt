package com.example.calendario

class Utilizador(
    var id: Int, var booking_group_id: String, var nome: String, var numero: String, var endereco: String, var descricao: String, var valor: String, var ano: Int ,var mes: Int, var dia: Int) {
   // val id: Int = 0, booking_group_id: String = "", var nome: String = "", var perfil: String = "", var numero: String = "", var endereco: String = "", var descricao: String = "", var valor: String = "", var ano: Int = 0, var mes: Int = 0, var dia: Int = 0) {



    override fun toString(): String {
      //  return "Evento(id=$id, cliente='$nome', data='$ano $mes $dia', numero = '$numero', endereco = '$endereco' descricao = '$descricao', valor = '$valor')"
        // return "Evento(ids=$id e booking_group_id = $booking_group_id, nome='$nome', data='$ano $mes $dia', numero = '$numero', endereco = '$endereco' descricao = '$descricao', valor = '$valor')"

        val quebraDeLinha = System.lineSeparator()
        return "Data:${dia}/${mes}/${ano} ${quebraDeLinha} Nome: ${nome} - Numero: ${numero}"

    }
}