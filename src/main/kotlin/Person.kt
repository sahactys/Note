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
        } else {
            println("Комментарий не создан ")
            false
        }
    }

    fun delete(noteId: Int): Boolean {
        return try {
            if (noteId <= notes.size && (!notes[noteId].deleted)) {
                notes[noteId].deleted = true
                for (comment in notes[noteId].comments) {
                    comment.deleted = true
                }
                true
            } else {
                println("Заметка не найдена или уже удалена ")
                false
            }
        } catch (e: Exception) {
            println("Заметка не найдена или уже удалена ")
            false
        }
    }

    fun deleteComment(noteId: Int, commentId: Int): Boolean {
        return try {
            if (!notes[noteId].deleted && !notes[noteId].comments[commentId].deleted) {
                notes[noteId].comments[commentId].deleted = true
                true
            } else {
                println("Комментарий не найден или уже удален")
                false
            }
        } catch (e: Exception) {
            println("Комментарий не найден или уже удален")
            false
        }
    }

    fun edit(noteId: Int, note: Note): Boolean {
        return try {
            return if (noteId <= notes.size && !notes[noteId].deleted) {
                notes[noteId].title = note.title
                notes[noteId].text = note.text
                true
            } else {
                println("Заметка не найдена или удалена")
                false
            }
        } catch (e: Exception) {
            println("Заметка не найдена или удалена")
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
            } else {
                println("Комментарий не найден или удален")
                false
            }
        } catch (e: Exception) {
            println("Комментарий не найден или удален")
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
            } else {
                println("Комментарий не найден или не был удален")
                false
            }
        } catch (e: Exception) {
            println("Комментарий не найден или не был удален")
            false
        }
    }
}
