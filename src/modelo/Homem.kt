package modelo

class Homem(nome: String, idade: Int, cor: Cor) : Animal(nome, idade, cor){
    override fun emitirSom() {
        println("Olá")
    }

    override fun idadeEmAnosHumanos(): Int {
        return idade
    }
}