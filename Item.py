class Item:
    def __init__(self, item_type: str, price: float, quantity: int):
        self.item_type = item_type
        self.price = price
        self.quantity = quantity

    def getType(self) -> str:
        return self.item_type

    def setType(self, item_type: str) -> None:
        self.item_type = item_type

    def getPrice(self) -> float:
        return self.price

    def setPrice(self, price: float) -> None:
        self.price = price

    def getQuantity(self) -> int:
        return self.quantity

    def setQuantity(self, quantity: int) -> None:
        self.quantity = quantity