class Person {
    private var notes = emptyList<Note>()

    fun add(note: Note): Note {
        notes += note
        return notes.last()
    }

    fun createComment(comment: Comment): Boolean {
        val postId = comment.component1()
        return if (postId <= notes.size) {
            notes[postId].comments.add(comment)
            true
        } else false
    }

    fun delete(noteId: Int): Boolean {
        return if (noteId <= notes.size && (!notes[noteId].deleted)) {
            notes[noteId].deleted = true
            for (comment in notes[noteId].comments) {
                comment.deleted = true
            }
            true
        } else false
    }

    fun deleteComment(noteId: Int, commentId: Int): Boolean {
        return if (!notes[noteId].deleted && !notes[noteId].comments[commentId].deleted) {
            notes[noteId].comments[commentId].deleted = true
            true
        } else false
    }

    fun edit(noteId: Int, note: Note): Boolean {
        return if (noteId <= notes.size && !notes[noteId].deleted) {
            notes[noteId].title = note.title
            notes[noteId].text = note.text
            true
        } else false
    }

    fun editComment(noteId: Int, commentId: Int, message: String): Boolean {
        return if (noteId <= notes.size &&
            commentId <= notes[noteId].comments.size &&
            !notes[noteId].comments[commentId].deleted
        ) {
            notes[noteId].comments[commentId].message = message
            true
        } else false
    }

    fun get(): List<Note> {
        return notes
    }

    fun getById(noteId: Int): Note {
        return notes[noteId]
    }

    fun getComments(noteId: Int): MutableList<Comment> {
        return notes[noteId].comments
    }

    fun restoreComment(noteId: Int, commentId: Int): Boolean {
        return if (!notes[noteId].deleted &&
            notes[noteId].comments[commentId].deleted &&
            noteId <= notes.size &&
            commentId <= notes[noteId].comments.size
        ) {
            notes[noteId].comments[commentId].deleted = false
            true
        } else false
    }
}
