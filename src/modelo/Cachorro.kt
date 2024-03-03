package modelo

class Cachorro(nome: String, idade: Int, cor: Cor) : Animal(nome, idade, cor) {
    override fun emitirSom() {
        println("Au au")
    }
}