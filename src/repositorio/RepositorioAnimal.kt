package repositorio

import modelo.Animal
import modelo.Cor

class RepositorioAnimal {
    private val animais: MutableList<Animal> = mutableListOf()

    fun adicionar(animal: Animal) {
        animais.add(animal)
    }

    fun remover(animal: Animal?): Boolean {
        return animais.remove(animal)
    }

    fun listar() {
        if(animais.isNotEmpty()) animais.forEach { println("${it.javaClass.simpleName}: ${it.nome}") }
        else println("Nenhum animal cadastrado ainda!")
    }

    fun listarPorCor(cor: Cor): List<Animal> {
        return animais.filter { it.cor == cor }
    }

    fun listarPorIdade(idade: Int): List<Animal> {
        return animais.filter { it.idadeEmAnosHumanos() == idade }
    }

    fun buscarNome(nome: String): Animal? {
        return animais.find { it.nome == nome }
    }

    fun emitirSom() {
        if(animais.isNotEmpty()) animais.forEach {"${it.javaClass.simpleName} ${it.nome}: ${it.emitirSom()}"}
        else println("Nenhum animal cadastrado ainda!")
    }
}