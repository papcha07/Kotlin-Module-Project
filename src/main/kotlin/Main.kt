fun main(args: Array<String>) {

    val archives = mutableListOf<Archive>()
    val archiveMenu = ArchiveMenu(archives)
    archiveMenu.showMenu()
}