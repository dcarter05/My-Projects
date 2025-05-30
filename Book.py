from xmlrpc.client import DateTime

from Item import Item
from Author import Author
from datetime import datetime
    
class Book(Item):
    def __init__(self, _genre: str, _title: str, author: Author, price, QTY, isbn: str, year: DateTime):
        self._genre = _genre
        self._title = _title
        self.author = author
        self.isbn = isbn
        self.year = year
        self.price = price
        self.quantity = QTY

    def getGenre(self) -> str:
        return self._genre

    def getTitle(self) -> str:
        return self._title

    def getAuthor(self) -> Author:
        return self.author

    def getISBN(self) -> str:
        return self.isbn

    def getYear(self) -> DateTime:
        return self.year


