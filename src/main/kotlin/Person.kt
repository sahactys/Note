class Person() {
    private val notes = mutableListOf<Note>()

    fun noteSize(): Int {
        return notes.size
    }

    fun notePrint() {
        notes.forEach {
            println("{${it.title}, ${it.text}, ${it.deleted}}")
        }
        notes.forEach {
            print("${it.comments}")
        }

    }

    fun add(note: Note): Note {
        notes.add(note)
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
        return try {
            if (noteId <= notes.size && (!notes[noteId].deleted)) {
                notes[noteId].deleted = true
                for (comment in notes[noteId].comments) {
                    comment.deleted = true
                }
                true
            } else false
        } catch (e: Exception) {
            false
        }
    }

    fun deleteComment(noteId: Int, commentId: Int): Boolean {
        return try {
            if (!notes[noteId].deleted && !notes[noteId].comments[commentId].deleted) {
                notes[noteId].comments[commentId].deleted = true
                true
            } else false
        } catch (e: Exception) {
            false
        }
    }

    fun edit(noteId: Int, note: Note): Boolean {
        return try {
            return if (noteId <= notes.size && !notes[noteId].deleted) {
                notes[noteId].title = note.title
                notes[noteId].text = note.text
                true
            } else false
        } catch (e: Exception) {
            false
        }
    }

    fun editComment(noteId: Int, commentId: Int, message: String): Boolean {
        return try {
            return if (noteId <= notes.size &&
                commentId <= notes[noteId].comments.size &&
                !notes[noteId].comments[commentId].deleted
            ) {
                notes[noteId].comments[commentId].message = message
                true
            } else false
        } catch (e: Exception) {
            false
        }
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
        return try {
            return if (!notes[noteId].deleted &&
                notes[noteId].comments[commentId].deleted &&
                noteId <= notes.size &&
                commentId <= notes[noteId].comments.size
            ) {
                notes[noteId].comments[commentId].deleted = false
                true
            } else false
        } catch (e: Exception) {
            false
        }
    }
}
