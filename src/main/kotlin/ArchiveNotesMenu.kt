import java.util.Scanner

class ArchiveNotesMenu(archive: Archive) : BaseMenu<Note>(archive.notes, "заметки в архиве '${archive.name}'") {
    private val scanner = Scanner(System.`in`)

    override fun getItemName(item: Note): String {
        return item.title
    }

    override fun createItem() {
        println("Введите название заметки:")

        val title = scanner.nextLine().trim()
        if (title.isEmpty()) {
            println("Название не может быть пустым")
            return
        }

        println("Введите текст заметки")
        val text = scanner.nextLine()

        if (text.isEmpty()) {
            println("Текст не может быть пустым")
            return
        }

        items.add(Note(title, text))
        println("Заметка ${title} создана")
    }

    override fun openItem(index: Int) {
        val note = items[index]
        println("Заметка '${note.title}':")
        println(note.content)
        println("1.Назад")
        checkInput(1)
    }
}


