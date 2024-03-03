package util

import modelo.*
import repositorio.RepositorioAnimal
import kotlin.system.exitProcess

object Utilitarios {
    fun menu() {
        println("1 - Cadastrar cachorro")
        println("2 - Cadastrar gato")
        println("3 - Cadastrar pássaro")
        println("4 - Cadastrar homem")
        println("5 - Excluir animal")
        println("6 - Listar animais")
        println("7 - Listar animais por cor")
        println("8 - Listar animais por idade")
        println("9 - Listar animais por nome")
        println("10 - Emitir som")
        println("11 - Sair")
    }

    fun inputNome(): String {
        print("Digite o nome do animal: ")
        return readlnOrNull()?:""
    }

    fun inputIdade(): Int {
        print("Digite a idade do animal em anos: ")
        var idade = readlnOrNull()?.toInt() ?:-1

        while(idade < 0) {
            print("Informe um valor positivo: ")
            idade = readlnOrNull()?.toInt() ?:exitProcess(1)
        }
        return idade
    }

    fun inputCor(): Cor {
        print("Digite a cor do animal: ")
        var cor = readlnOrNull()?.uppercase() ?:""

        while(!validarCor(cor)) {
            println("As cores permitidas são: ")
            exibirCores()
            print("Informe uma cor valida: ")
            cor = readlnOrNull()?.uppercase() ?: exitProcess(1)
        }
        return converterCor(cor)
    }

    fun validarCor(cor: String): Boolean {
        Cor.entries.forEach { if(it.name == cor) return true }
        return false
    }

    fun exibirCores() {
        Cor.entries.forEach { println(it.name) }
    }

    fun converterCor(cor: String): Cor {
        return Cor.entries.first { it.name == cor }
    }

    fun cadastrarAnimal(tipoAnimal: String, repositorio: RepositorioAnimal) {
        val nome = inputNome()
        val idade = inputIdade()
        val cor = inputCor()

        when(tipoAnimal) {
            "cachorro" -> repositorio.adicionar(Cachorro(nome, idade, cor))
            "gato" -> repositorio.adicionar(Gato(nome, idade, cor))
            "passaro" -> repositorio.adicionar(Passaro(nome, idade, cor))
            "homem" -> repositorio.adicionar(Homem(nome, idade, cor))
        }
        println("\nCadastrado com sucesso!\n")
    }

    fun excluirAnimal(repositorio: RepositorioAnimal) {
        val nome = inputNome()

        if(nome != "") {
            val animal = repositorio.buscarNome(nome)
            if(repositorio.remover(animal)) {
                println("Animal $nome removido com sucesso!")
            } else {
                println("Animal $nome não foi encontrado")
            }
        }
    }

    fun listarPorCor(repositorio: RepositorioAnimal) {
        val cor = inputCor()
        val animais = repositorio.listarPorCor(cor)

        if(animais.isNotEmpty()) animais.forEach {println("${it.javaClass.simpleName}: ${it.nome}")}
        else println("Nenhum animal ${cor.name.lowercase()} cadastrado ainda!")
    }

    fun listarPorIdade(repositorio: RepositorioAnimal) {
        val idade = inputIdade()
        val animais = repositorio.listarPorIdade(idade)

        if(animais.isNotEmpty()) animais.forEach {println("${it.javaClass.simpleName}: ${it.nome}")}
        else println("Nenhum animal de idade $idade cadastrado ainda!")
    }

    fun buscarPorNome(repositorio: RepositorioAnimal): Animal? {
        val nome = inputNome()
        return repositorio.buscarNome(nome)
    }
}