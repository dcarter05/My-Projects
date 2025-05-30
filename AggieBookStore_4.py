import csv
from Book import Book
from Author import Author
from datetime import datetime

books = []

def displayMenu(options):
    count = 1

    for i in options:
        print(f"{count}) {i}")
        inventory.update({i: list()})
        count += 1
    print(f"{count}) Exit")

    choice = int(input("Enter your choice: "))
    if choice == 6:
        print("\nAggie Book Store\nGood Bye")
        return "Exit"
    else:
        return options[choice-1]


def displayGenreInv(genreOption, booksList):
    print(f"{genreOption}")
    header = ["Author", "Title", "Published", "QTY", "Price"]
    print(f"\t{header[0]:<20}{header[1]:<30}{header[2]:<10}{header[3]:<5}{header[4]:<10}")
    total_count = 0
    total_cost = 0.0

    for book in booksList:
        if genreOption in inventory:
            # Access attributes and convert quantity to integer
            author = book.author
            title = book.title
            try:
                quantity = int(float(book.quantity))  # Convert to float, then to integer
            except ValueError:
                quantity = 0  # Default to 0 if conversion fails
            price = book.price

            # Assuming author has first_name and last_name attributes
            author_name = f"{author.first_name} {author.last_name}"

            total_count += quantity
            total_cost += price * quantity

            price_display = f"{price:.2f}"  # Ensure 2 decimal places for price
            print(f"\t{author_name:<19} {title:<29} {book.year:<9} {quantity:<5} {price_display:<10}")

    print(f'\t{"="*33}\n\tInventory count {total_count} : Total ${total_cost}')

def readInv(file):
    with open(file, 'r') as f:
        reader = csv.reader(f)
        next(reader)
        for row in reader:
            genre, title, fname, lname, mname, dob, price, qty, isbn, year = row
            author = Author(fname, lname, mname, dob)
            book = Book(genre, title, author, float(price), qty, isbn, year)
            books.append(book)
    return books

filename = input("Enter inventory file: ").strip()
booksList = readInv(filename)

genres = sorted(set(book.getGenre() for book in booksList))

inventory = dict()
selected_option = None

while selected_option != "Exit":
    selected_option = displayMenu(genres)
    if selected_option and selected_option != "Exit":
        displayGenreInv(selected_option, books)

