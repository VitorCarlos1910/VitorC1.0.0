
package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectFactory {
    
    public Connection getConnection() {
        
        try {
            
            
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/atv2vit", "root", "vitor1808");
            
            
            
        }catch (SQLException e) {
            
        JOptionPane.showMessageDialog(null,"Erro de Conexão");
         return null;   
        }  
    }
    
    
    
    
    
    
    
}
