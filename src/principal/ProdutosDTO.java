package principal;
import java.util.ArrayList;
import java.util.List;


public class ProdutosDTO {
    private String id;
    private String nome;
    private String valor;
    private String status;
    
     public static List<ProdutosDTO> lista = new ArrayList<>();
    
    public ProdutosDTO() {
    }   

    
    public ProdutosDTO(String id, String nome, String valor, String status) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.status = status;
    }
    
    
 

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getValor() {
        return valor;
    }

    public String getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
       static List<ProdutosDTO> getLista() {
        return lista;
    }
    
    public void addProdutos (){
        lista.add(this);
    }  
    
    
    
    
    
    
    
    
    
    
}
