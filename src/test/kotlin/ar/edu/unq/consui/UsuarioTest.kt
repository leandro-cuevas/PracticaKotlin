package ar.edu.unq.consui

import org.junit.Test
import org.junit.jupiter.api.*
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import java.time.LocalDate
import kotlin.test.assertEquals

class UsuarioTest {

    var nacho = Usuario("Nacho Moreira", "nachomun", "nachito@gmail.com", LocalDate.of(1990, 5, 15))
    var lean = Usuario("Leandro Cuevas", "leanc", "lean@yahoo.com.ar", LocalDate.of(1996, 8, 16))
    var rodri = Usuario("Rodri Bolaños", "rodriweber", "rodri@hotmail.com", LocalDate.of(2002, 2, 1))


    @Test
    fun constructorTest() {
        assertEquals(nacho.nombreUsuario, "nachomun")
        assertEquals(nacho.nombreApellido, "Nacho Moreira")
        assertEquals(nacho.email, "nachito@gmail.com")
        assertEquals(nacho.fechaNac, LocalDate.of(1990, 5, 15))
    }

    @Test
    fun edadTest(){
        assertEquals(nacho.edad(), 33)
    }

    @Test
    fun gmailTest(){
        assertEquals(nacho.elMailEsGmail(), true)
        assertEquals(lean.elMailEsGmail(), false)
    }

    @Test
    fun mutualsTest() {
        nacho.seguir(rodri)
        nacho.seguir(lean)
        rodri.seguir(nacho)
        rodri.seguir(lean)
        assertEquals(lean.mutuals().size, 0)
        assertEquals(rodri.mutuals().size, 1)
    }
}