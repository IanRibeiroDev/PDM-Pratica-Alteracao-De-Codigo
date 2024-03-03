package modelo

class Passaro(nome: String, idade: Int, cor: Cor) : Animal(nome, idade, cor) {
    override fun emitirSom() {
        println("Piu piu")
    }
}