

fun main(){
    val person1 = Person()
    person1.add(Note("qwe","eqwe"))
    person1.add(Note("asd","asdf"))
    person1.createComment(Comment(0,"123"))
    person1.createComment(Comment(0,"546"))
    person1.delete(1)
    person1.notePrint()

}