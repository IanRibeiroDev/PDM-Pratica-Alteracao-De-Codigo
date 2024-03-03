package modelo

class Gato(nome: String, idade: Int, cor: Cor) : Animal(nome, idade, cor) {
    override fun emitirSom() {
        println("Miau")
    }
}