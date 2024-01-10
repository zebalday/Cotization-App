
package Classes;

import javax.swing.*;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListDataListener;

public class ResultSetComboBoxModel implements ComboBoxModel<String> {
    
    private List<String> data = new ArrayList<>();
    private Object selectedValue;
    
    public ResultSetComboBoxModel(ResultSet resultset, String column) {        
        try {
            while(resultset.next()){
                String name = resultset.getString(column);
                data.add(name);
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(ResultSetComboBoxModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSetComboBoxModel(ResultSet resultset, String column1, String column2) {        
        try {
            while(resultset.next()){
                String name = resultset.getString(column1);
                String mail = resultset.getString(column2);
                data.add(name + " - " + mail);
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(ResultSetComboBoxModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSetComboBoxModel(List list){
        for (Object name: list){
            data.add((String) name);
        }
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedValue = anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedValue;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public String getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        //
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        //
    }
}
