package ua.edu.lntu.cw4.data

import ua.edu.lntu.cw4.model.ItemList

class Datasource {
    fun loadInformation(): List<ItemList> {
        return listOf<ItemList>(
            ItemList("Somename", 1),
            ItemList("Somename", 2),
            ItemList("Somename", 3),
            ItemList("Somename", 4),
            ItemList("Somename", 5),
            ItemList("Somename", 6),
            ItemList("Somename", 7),
            ItemList("Somename", 8),
            ItemList("Somename", 9),
            ItemList("Somename", 10),
            ItemList("Somename", 11),
            ItemList("Somename", 12),
        )

    }
}
