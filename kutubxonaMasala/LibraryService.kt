package kutubxonaMasala

import java.util.*

class LibraryService:LibraryInterface {

    val userList= arrayOfNulls<User>(100  )
    var countUser=0
    var bookList= arrayOfNulls<Book >(100   )
    var countBook =0
    var readerlist= arrayOfNulls<User >(100   )
    var countReader =0
    var givenBooks = arrayOfNulls<GivenBook >(100)
    var countGivenBook=0

    var scanner=Scanner(System.`in`)

    override fun signUp() {
        println("UserName :" )
        val userName=scanner.next()
        println("Password :")
        val password=scanner.next()
        println("Rule :")
        for (i in Role.values().indices){
            println("${i+1}. ${Role.values()[i]}")
        }
        println()
        println("Choose rule: ")
        val role =scanner.nextInt()
        if (role in 1..3){

            val user=User(userName,password,Role.values()[role-1])
            userList[countUser++]=user
            println("Successful")
            println("-----------------------------------------------")

        }
        else{
            println("Invalid choose number rule !")
            signUp()
        }

    }

    override fun signIn() :User?{
        println("Username :")
         val userName=scanner.next()
        println("Password :")
        val password=scanner.next()

        for (i in 0 until countUser){
            if (userList[i]?.userName==userName && userList[i]?.password==password){
                return userList[i]

            }
        }
    return null
    }

    override fun librarianList() {
        println()
        for (i in  0 until countUser){
            if (userList[i]?.role==Role.LIBRARIAN)
            println(userList[i]?.userName)
            println(userList[i]?.password)
            println(userList[i]?.role)
            println("--------------------------------")
        }
    }

    override fun addLibrarian() {
        println("LibrarianName :")
        var librarianName=scanner.next()
        println("Librarian password :")
        val password =scanner.next()
        val role=Role.LIBRARIAN
        val user=User(librarianName,password,role)
        userList[countUser++] =user
        println("Added successful")
        println("---------------------------")

    }

    override fun deleteList() {
        for (i in  0 until countUser){
            if (userList[i]?.role==Role.LIBRARIAN)
                println(userList[i]?.userName)
            println(userList[i]?.password)
            println(userList[i]?.role)
            println("--------------------------------")
        }
    }

    override fun deleteLibrarian() {
        println("Librarian Name :")
        var librarianName=scanner.next()
        println("Librarian password :")
        var password=scanner.next()
        var index=-1
        for (i in 0 until countUser){
            if (userList[i]?.userName==librarianName && userList[i]?.password==password){
                index=i
                break

            }
        }
        if (index!=-1){
            for (i in index until countUser-1){
                userList[i] =userList[i+1]

            }
            userList[countUser--]=null
            println("Delete successfully")
            println("----------------------------------------")


        }
        else{
            println("Invalid Username or password !")
            println("---------------------------------------")
        }



    }


    override fun addBook() {
        println("--------")
        println("Book name :")
        newScanner()
        var name=scanner.nextLine()
        println("Book Author :")
        newScanner()
        var author=scanner.nextLine()
        println("Book type ")
        for (i in BookType.values().indices){

            println("${i+1} .${BookType.values()[i]}")

        }
        println("-------------------------------------")
        println("Choose :")
        val m=scanner.nextInt()
        println("Count of books :")
        val count=scanner.nextInt()
        val book=Book(name,author, bookCount = count, bookType = BookType.values()[m-1])
        bookList[countBook++]=book
        println("Successfully !")


    }

    override fun editBook() {
        if (countBook==0){
            println("Books not have ! :(")

        }
        else{
            bookList()
            println("Hozirda bu funksya ishlamaydi iltimos kuting :(((")
        }

    }

    override fun deleteBook() {
        println("Book Name :")
        var librarianName=scanner.next()
        println("Book author :")
        var password=scanner.next()
        var index=-1
        for (i in 0 until countBook){
            if (bookList[i]?.name==librarianName && bookList[i]?.author==password){
                index=i
                break

            }
        }
        if (index!=-1){
            for (i in index until countBook-1){
                bookList[i] =bookList[i+1]

            }
            bookList[countBook--]=null
            println("Delete successfully")
            println("----------------------------------------")

        }
        else{
            println("Invalid Username or password !")
            println("---------------------------------------")
        }




    }

    override fun bookList() {
        println("------------------------Books----------------------------------")
        for (i in 0 until countBook){
            println("----------------------Book[${i+1}]----------------------------------------------")
            println("${i+1} .book name : ${bookList[i]?.name}")
            println("${i+1} .book author : ${bookList[i]?.author}")
        }

    }

    override fun addReader() {
        println("Reader Name :")
        var librarianName=scanner.next()
        println("Reader password :")
        val password =scanner.next()
        val role=Role.READER
        val user=User(librarianName,password,role)
        readerlist[countReader++] =user
        println("Added successful")
        println("--------------------------- ")
    }

    override fun deleteReader() {
        println("Reader Name :")
        var librarianName=scanner.next()
        println("Reader password :")
        var password=scanner.next()
        var index=-1
        for (i in 0 until countReader){
            if (readerlist[i]?.userName==librarianName && readerlist[i]?.password==password){
                index=i
                break

            }

    }
        if (index!=-1){
            for (i in index until countReader-1){
                readerlist[i] =readerlist[i+1]

            }
            bookList[countBook--]=null
            println("Delete successfully")
            println("----------------------------------------")

        }
        else{
            println("Invalid Username or password !")
            println("---------------------------------------")
        }

    }

    override fun editReader() {
    }

    override fun giveBook() {
        if (countBook==0){
            println("Not have books ! add books ")
            println("-------------------------------------")
        }else if (countReader==0){
            println("Add Readers !")
            println("-----------------------------------------------------")

        }
        else{
             bookList()
            println("Choose: ")
            val bookIndex=scanner.nextInt()
            readerList()
            val readerIndex=scanner.nextInt()
            if (  bookList[bookIndex-1]!!.bookCount>0) {
                val givenBook=GivenBook(readerlist[readerIndex-1]!!,bookList[bookIndex-1]!!)
                givenBooks[countGivenBook++]=givenBook
                bookList[bookIndex - 1]?.bookCount =bookList[bookIndex - 1]!!.bookCount - 1

                println("----------------------------------------------------")
            }
            else{
                println("Not have book ! ")
                println("Bu kitobdan boshqa qolmadi !!! :(")

            }




        }


    }

    override fun getBook() {

        println("-------------------------------------------")
        for (i in 0 until countGivenBook){
            println("kitob nomi :${i+1} .${givenBooks[i]?.book?.name}")
            println("Olgan shaxs :${givenBooks[i]?.user?.userName}")
        }

        println()
        println("Choose :")
        val  bookIndex =scanner.nextInt()

        val book = givenBooks[bookIndex - 1]?.book
        updateBookCount(book)
        if (bookIndex in 1..countGivenBook+1){
            for (i in bookIndex-1 until countGivenBook-1){
                givenBooks[i] =givenBooks[i+1]

            }
            givenBooks[countGivenBook--]=null
            println("Successful")
            println("------------------------------------------------")


        }else{
            println("Invalid choose number !")
        }
    }

    override fun takeBook( user:User?) {
        if (countBook==0){
            println("Not have books ! :(  ")
        }
        else{
            bookList()
            println("Choose: ")
            val bookIndex=scanner.nextInt()
            if (  bookList[bookIndex-1]!!.bookCount>0) {
                val givenBook=GivenBook(user!!,bookList[bookIndex-1]!!)
                givenBooks[countGivenBook++]=givenBook
                bookList[bookIndex - 1]?.bookCount =bookList[bookIndex - 1]!!.bookCount - 1
                println("Successful :))")
                println("------------------")

            }
            else{
                println("Not have book ! :(((")

            }




        }


    }

    override fun returnBook() {

        println("-------------------------------------------")
        for (i in 0 until countGivenBook){
            println("kitob nomi :${i+1} .${givenBooks[i]?.book?.name}")
            println("Olgan shaxs :${givenBooks[i]?.user?.userName}")
            println("kitob type : ${givenBooks[i]?.book?.bookType}")
            println("kitob muallifi :${givenBooks[i]?.book?.author}")
        }

        println()
        println("Choose :")
        val  bookIndex =scanner.nextInt()

        val book = givenBooks[bookIndex - 1]?.book
        updateBookCount(book)
        if (bookIndex in 1..countGivenBook+1){
            for (i in bookIndex-1 until countGivenBook-1){
                givenBooks[i] =givenBooks[i+1]

            }
            givenBooks[countGivenBook--]=null
            println("Successful")
            println("------------------------------------------------")


        }else{
            println("Invalid choose number !")
        }
    }

    override fun readerList() {
        println("--------------ReaderList-----------------------------")
        for (i in   0 until countReader){
            println("${i+1}.${readerlist[i]?.userName}")
        }
        println("-----------------------------------------------------")

    }

    override fun updateBookCount(book: Book?) {

        for (i in 0 until countBook){
            if (bookList[i]?.name==book?.name && bookList[i]?.author==book?.author && bookList[i]?.bookType==book?.bookType){
                bookList[i]?.bookCount=bookList[i]!!.bookCount+1
                break
            }

        }

    }

     fun newScanner(){
        scanner= Scanner(System.`in`)
    }
}