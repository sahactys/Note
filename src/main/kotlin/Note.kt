class Note(
    var title: String,
    var text: String,
    var deleted: Boolean = false
) {
    val comments = mutableListOf<Comment>()
}