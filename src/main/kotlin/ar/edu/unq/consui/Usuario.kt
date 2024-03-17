package ar.edu.unq.consui

import java.time.LocalDate
import java.time.Period

class Usuario(val nombreApellido: String, val nombreUsuario: String, var email: String, val fechaNac: LocalDate) {

    val seguidores : MutableSet<Usuario> = mutableSetOf()
    val seguidos : MutableSet<Usuario> = mutableSetOf()

    fun edad(): Int{

        val cantidad = Period.between(fechaNac, LocalDate.now())

        return cantidad.years
    }

    fun elMailEsGmail(): Boolean{
        val dominio : String = email.substringAfter('@')

        return dominio == "gmail.com"
    }

    fun seguir(usuario: Usuario) {
        seguidos.add(usuario)
        usuario.seguidores.add(this);
    }

    fun dejarDeSeguir(usuario: Usuario){
        seguidos.remove(usuario)
        usuario.seguidores.remove(this)
    }

    fun mutuals(): Set<Usuario>{
        val mutuos = seguidores.intersect(seguidos)

        return mutuos
    }


}