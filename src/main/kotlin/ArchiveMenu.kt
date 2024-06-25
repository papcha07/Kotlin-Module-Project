import java.util.Scanner

class ArchiveMenu(archives: MutableList<Archive> = mutableListOf()) : BaseMenu<Archive>(archives, "архив") {
    private val scanner = Scanner(System.`in`)

    override fun getItemName(item: Archive): String {
        return item.name
    }

    override fun createItem() {
        println("Введите название архива:")
        val name = scanner.nextLine().trim()

        if (name.isEmpty()) {
            println("Имя архива не может быть пустым")
        } else {
            items.add(Archive(name))
            println("Архив ${name} успешно создан")
        }
    }

    override fun openItem(index: Int) {
        val archiveNotesMenu = ArchiveNotesMenu(items[index])
        archiveNotesMenu.showMenu()
    }
}