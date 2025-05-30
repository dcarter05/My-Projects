"""
Dorian Carter Jr

This program is created for a bookstore to track the amount of books in certain genres that are in their stock.
"""

# Creates list for each genre needed for this code.
genre = ['Fiction', 'Narrative', 'Mystery', 'Biography', 'Science Fiction', 'Fantasy']

print('Welcome to Aggie bookstore.', sep='')

# Asks user for inventory input of each genre listed. This will be important for the if statements below.
fiction_inventory = int(input(f'What is the inventory count of {genre[0]}: '))
narrative_inventory = int(input(f'What is the inventory count of {genre[1]}: '))
mystery_inventory = int(input(f'What is the inventory count of {genre[2]}: '))
biography_inventory = int(input(f'What is the inventory count of {genre[3]}: '))
scifi_inventory = int(input(f'What is the inventory count of {genre[4]}: '))
fantasy_inventory = int(input(f'What is the inventory count of {genre[5]}: '))

print('We offer the following genre:')

# Creates multiple if statements to calculate which genres of books that are available depending on amount and input above.
# If amount that is input is above 0, that select genre(s) will print. If all inputs equal 0, no genres will output.
if fiction_inventory > 0:
    print("Fiction")
if narrative_inventory > 0:
    print("Narrative")
if mystery_inventory > 0:
    print("Mystery")
if biography_inventory > 0:
    print("Biography")
if scifi_inventory > 0:
    print("Science Fiction")
if fantasy_inventory > 0:
    print("Fantasy")
else:
    print('Sorry we have no genres in our inventory.')





