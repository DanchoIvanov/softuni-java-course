package restaurant.repositories;

import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.TableRepository;

public class TableRepositoryImpl extends Data<Table> implements TableRepository<Table> {

    @Override
    public Table byNumber(int tableNumber){
        for (Table currentTable : this.getAllEntities()){
            if (currentTable.getTableNumber() == tableNumber){
                return currentTable;
            }
        }
        return null;
    }
}
