package modelo

abstract class Animal(var nome: String, var idade: Int, var cor: Cor) {
    abstract fun emitirSom()

    open fun idadeEmAnosHumanos(): Int {
        return idade * 7
    }
}