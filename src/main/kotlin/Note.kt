data class Note(
    var title: String,
    var text: String,
    var comments: MutableList<Comment>,
    var deleted: Boolean = false
)