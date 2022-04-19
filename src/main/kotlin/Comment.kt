data class Comment(
    val noteId: Int,
    var message: String,
    var deleted: Boolean = false
)