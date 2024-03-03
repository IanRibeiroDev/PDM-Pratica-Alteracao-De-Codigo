import modelo.Animal
import repositorio.RepositorioAnimal
import util.Utilitarios


fun main() {
    val repositorioAnimal = RepositorioAnimal()
    var opcao = 0
    var animal: Animal?

    while (opcao != 11) {
        Utilitarios.menu()
        print("Digite a opção: ")
        opcao = readlnOrNull()?.toInt() ?:11

        when (opcao) {
            1 -> Utilitarios.cadastrarAnimal("cachorro", repositorioAnimal)
            2 -> Utilitarios.cadastrarAnimal("gato", repositorioAnimal)
            3 -> Utilitarios.cadastrarAnimal("passaro", repositorioAnimal)
            4 -> Utilitarios.cadastrarAnimal("homem", repositorioAnimal)
            5 -> Utilitarios.excluirAnimal(repositorioAnimal)
            6 -> repositorioAnimal.listar()
            7 -> Utilitarios.listarPorCor(repositorioAnimal)
            8 -> Utilitarios.listarPorIdade(repositorioAnimal)
            9 -> {
                animal = Utilitarios.buscarPorNome(repositorioAnimal)
                if(animal != null) println("${animal.javaClass.simpleName} de nome ${animal.nome} encontrado com sucesso!")
                else println("Animal não encontrado!")
            }
            10 -> repositorioAnimal.emitirSom()
            11 -> println("Obrigado por utilizar meu app :)")
        }
        Thread.sleep(3000)
    }
}
