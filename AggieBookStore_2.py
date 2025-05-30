"""
Dorian Carter Jr

This program is created for a bookstore to track the amount of books in certain genres that are in their stock.
This program also will list the book titles for each genre.
"""

# Creates list for each genre needed for this code.
genre = ['Fiction', 'Narrative', 'Mystery', 'Biography', 'Science Fiction', 'Fantasy']

print('Welcome to Aggie bookstore.', sep='')

# Creates dictionary named inventory that holds genre keys and empty list values
inventory = {
    'Fiction':[],
    'Narrative':[],
    'Mystery':[],
    'Biography':[],
    'Science Fiction':[],
    'Fantasy':[]
}

# Loops through every genre stored and asks the user for the inventory count of each genre.
for g in genre:
    inv_count = int((input(f'What is the inventory count of {g}: ')))
    genreList = []
    # While loop for the user to input a specific book title(s) based on the number of books in that genre.
    while inv_count > 0:
        title = input(f'What is the {inv_count} book title: ')
        genreList.append(title)
        inv_count -= 1
    inventory[g] = genreList


print('We offer the following genre book titles:', end='')
# Prints the genre and book title(s) if needed. Else will print there aren't any books available.
for genre, titles in inventory.items():
    if titles:
        print(f'\n{genre}', end='')
        for title in titles:
            print(f'\n\t{title}', end='')
    else:
        print(f'\n{genre}\n\tSorry we have no books in our inventory.', end='')

