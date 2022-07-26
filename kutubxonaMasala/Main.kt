package kutubxonaMasala

import java.util.*

fun main(args: Array<String>) {
    val scanner=Scanner(System.`in`)
    val manager =LibraryService()


    while (true ){
        println("Welcome Library !!!")
        println()
        println("1-> Sign in")
        println("2-> Sign Up")
        println("--------------------------------------------------")
        println("Tanlang :")
        val number =scanner.nextInt()
        when(number){
            1->{
                val user=manager. signIn()
                when(user?.role){
                    Role.ADMIN->{
                       loop@while (true){
                           println("-------------------------------------")
                           println("1-> Add Librarian")
                           println("2-> Delete Librarian")
                           println("3-> LibrarianList ")
                           println("4-> Back ")
                           println("Choose :")
                           val number2=scanner.nextInt()
                           when(number2){
                               1->{
                                   manager.addLibrarian()
                               }
                               2->{
                                   manager.deleteLibrarian()
                               }
                               3->{
                                   manager.librarianList()
                               }
                               4->{
                                   break@loop
                               }
                               else ->{
                                   println("Invalid choose number !")
                                   println("----------------------------------------------")

                               }
                           }
                       }
                    }
                    Role.LIBRARIAN->{
                        loop@while (true) {
                            println("-------------------------------")
                            println("1-> Add book ")
                            println("2-> Edit book")
                            println("3-> Delete book")
                            println("4-> Add Reader")
                            println("5-> Edit Reader ")
                            println("6-> Delete Reader")
                            println("7-> Reader list ")
                            println("8-> Give Book")
                            println("9-> get Book ")
                            println("10-> Book List ")
                            println("0->Back")
                            println("Choose :")
                            val number3=scanner.nextInt()
                           when(number3){
                                1->{
                                    manager.addBook()
                                }
                                2->{
                                    manager.editBook()
                                }
                                3->{
                                    manager.deleteBook()
                                }
                                4->{
                                    manager.addReader()
                                }
                                5->{
                                    manager.editReader()
                                }
                                7->{
                                    manager.readerList()
                                }
                                8->{
                                    manager.giveBook()
                                }
                                9->{
                                    manager.getBook()
                                }
                               10->{
                                   manager.bookList()
                               }

                                0->{
                                    break@loop
                                }
                            }


                        }
                    }
                    Role.READER->{
                       loop@while (true){
                           println("----------------------------")
                           println("1<- Take book")
                           println("2<- Return book")
                           println("3<- back ")
                           println(" Choose :")
                           when(scanner.nextInt()){
                               1->{
                                   manager.takeBook(user)
                               }
                               2->{
                                   manager.returnBook()
                               }
                               3->{
                                   break@loop
                               }
                           }
                       }
                    }
                    else->{
                        println("Error ")
                        println("--------------------------------------")
                    }
                }
            }
            2->{
                manager.signUp()
            }

            else->{
                println("Notugri raqam !")
                println("-----------------------------------------------")
            }
        }
    }
}