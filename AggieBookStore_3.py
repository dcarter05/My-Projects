"""
Dorian Carter Jr

Creates a program that will list the inventory and total for each genre.
"""

import csv

# Displays a menu of genres and handles user selection.
def displayMenu(options):
    # Print each genre with an assigned number
    i = 1
    for option in options:
        print(f"{i}) {option}")
        i += 1

    # Add an "Exit" option at the end of the menu
    print(f"{i}) Exit")

    # Prompt user for their choice
    choice = input("Enter your choice: ")

    # Validate that the choice is a digit within the valid range
    if choice.isdigit():
        choice = int(choice)
        if 1 <= choice <= len(options):
            return options[choice - 1]
        elif choice == len(options) + 1:
            print('Aggie Book Store')
            print('Good Bye')
            return 'Exit'

# Reads the genre options from a specified file and returns them as a list.
def readGenre(genreFile):
    # Open the genre file and read its content
    with open(genreFile, 'r') as file:
        content = file.read()
    # Split the content into individual genres and return as a list
    return content.split()

# Adds an inventory dictionary from a list of inventory lines.
def popInv(invList):
    inventory = {}
    for line in invList:
        # Split each line by commas
        parts = line.strip().split(',')
        # Skip lines that do not have exactly 5 parts
        if len(parts) != 5:
            continue
        genre, author, title, published, cost = parts
        # Skip the header or invalid rows if 'published' is not numeric
        if not published.isdigit():
            continue

        # Convert published year to integer and cost to float
        published = int(published)
        cost = float(cost)

        # Initialize the genre in the inventory dictionary
        if genre not in inventory:
            inventory[genre] = []

        # Append book information to the genre list
        inventory[genre].append({
            "title": title,
            "author": author,
            "published": published,
            "price": cost
        })
    return inventory

# Displays all books within a selected genre along with totals.
def displayGenreInv(genreOption):
    # Display genre and headers for books
    print(f"{genreOption}")
    print(f"\t{'Author':<19} {'Title':<29} {'Published':<9} {'Cost':<5}")

    print(type(genreOption))
    print(type(inventory))
    # Initializes counters for inventory and total cost
    total_inventory = 0
    total_cost = 0

    # Check if the selected genre exists in the inventory
    if genreOption in inventory:
        for book in inventory[genreOption]:
            # Collects book details
            author = book['author']
            title = book['title']
            published = book['published']
            cost = book['price']

            # Update inventory count and total cost
            total_inventory += 1
            total_cost += cost
            # Display cost as an integer if it has no decimal places
            if cost.is_integer():
                cost_display = int(cost)
            else:
                cost_display = cost
            print(f"\t{author:<19} {title:<29} {published:<9} {cost_display:<20}")

        # Print inventory summary with total count and cost
        print(f'\t{"="*33}\n\tInventory count {total_inventory} : Total ${total_cost:.2f}')
    else:
        print(f"No inventory found for genre '{genreOption}'.")

# Reads the inventory from 'Inventory.csv' file and returns a list of lines.
def readInv():
    with open('Inventory.csv', 'r') as file:
        invList = {line.strip() for line in file}
    return invList

# Input for genre file begins here
filename = input('Enter genre file: ')

# Read menu options from the specified file
menu = readGenre(filename)

# Read inventory data from 'Inventory.csv' file and adds the inventory dictionary
invList = readInv()
inventory = popInv(invList)

# Loop to display menu and selected genre inventory
while True:
    selected_genre = displayMenu(menu)
    if selected_genre == "Exit":
        break
    # Display inventory for the selected genre
    displayGenreInv(selected_genre)