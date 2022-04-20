import org.junit.Assert.*
import org.junit.Test

class PersonTest {
    private val person1 = Person()


    @Test
    fun add(){
        person1.add(Note(title = "qwe", text = "qwee"))
        val result = person1.noteSize()
        assertEquals(1,result)
    }

    @Test
    fun createCommentTrue(){
        person1.add(Note(title = "qwe", text = "qwee"))
        val result = person1.createComment(Comment(0, "asd"))
        assertTrue(result)
    }

    @Test
    fun createCommentFalse(){
        person1.add(Note(title = "qwe", text = "qwee"))
        val result = person1.createComment(Comment(2, "asd"))
        assertFalse(result)
    }

    @Test
    fun deleteTrue(){
        person1.add(Note(title = "qwe", text = "qwee"))
        val result = person1.delete(0)
        assertTrue(result)
    }

    @Test
    fun deleteFalse(){
        person1.add(Note(title = "qwe", text = "qwee"))
        val result = person1.delete(3)
        assertFalse(result)
    }

    @Test
    fun deleteCommentTrue(){
        person1.add(Note(title = "qwe", text = "qwee"))
        person1.createComment(Comment(0, "asd"))
        val result = person1.deleteComment(0,0)
        assertTrue(result)
    }

    @Test
    fun deleteCommentFalse(){
        person1.add(Note(title = "qwe", text = "qwee"))
        person1.createComment(Comment(0, "asd"))
        val result = person1.deleteComment(1,1)
        assertFalse(result)
    }

    @Test
    fun editTrue(){
        person1.add(Note(title = "qwe", text = "qwee"))
        person1.createComment(Comment(0, "asd"))
        val result = person1.edit(0, Note("ads", "zxc"))
        assertTrue(result)
    }

    @Test
    fun editFalse(){
        person1.add(Note(title = "qwe", text = "qwee"))
        person1.createComment(Comment(0, "asd"))
        val result = person1.edit(1, Note("ads", "zxc"))
        assertFalse(result)
    }

    @Test
    fun editCommentTrue(){
        person1.add(Note(title = "qwe", text = "qwee"))
        person1.createComment(Comment(0, "asd"))
        val result = person1.editComment(0,0,"asd")
        assertTrue(result)
    }

    @Test
    fun editCommentFalse(){
        person1.add(Note(title = "qwe", text = "qwee"))
        person1.createComment(Comment(0, "asd"))
        val result = person1.editComment(1,1,"asd")
        assertFalse(result)
    }

    @Test
    fun restoreCommentTrue(){
        person1.add(Note(title = "qwe", text = "qwee"))
        person1.createComment(Comment(0, "asd"))
        person1.deleteComment(0,0)
        val result = person1.restoreComment(0,0)
        assertTrue(result)
    }

    @Test
    fun restoreCommentFalse(){
        person1.add(Note(title = "qwe", text = "qwee"))
        person1.createComment(Comment(0, "asd"))
        person1.deleteComment(0,0)
        val result = person1.restoreComment(1,0)
        assertFalse(result)
    }




}