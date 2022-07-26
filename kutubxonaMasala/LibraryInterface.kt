package kutubxonaMasala

interface LibraryInterface {
    //auth
    fun signUp()
    fun signIn(): User?
    fun librarianList()

    // admin
    fun addLibrarian()
    fun deleteList()
    fun deleteLibrarian()

    //Librarian
    fun addBook()
    fun editBook()
    fun deleteBook()
    fun bookList()

    fun addReader()
    fun deleteReader()
    fun editReader()

    fun giveBook()
    fun getBook()

    ///for reader


    fun takeBook(user: User?)
    fun returnBook()
    fun readerList()
    fun updateBookCount(book: Book?)


}