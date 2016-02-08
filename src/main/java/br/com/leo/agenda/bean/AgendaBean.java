package br.com.leo.agenda.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.leo.agenda.dao.ContadoDAO;
import br.com.leo.agenda.entity.Contato;

@ViewScoped
@ManagedBean(name="agendaBean")
public class AgendaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Contato contato;
    private List<Contato> contatos;

    @PostConstruct
    private void init(){
    	contatos = new ContadoDAO().listAll();
    }
     
    public void merge(){
    	try{
    		new ContadoDAO().merge(contato);
    		Messages.addGlobalInfo("Sucesso!");
    	    init();
    	}catch(RuntimeException e){
    		Messages.addGlobalError("Erro!", e.getMessage());
    	}
    }
    
    public void delete(ActionEvent e){
    	contato = (Contato) e.getComponent().getAttributes().get("selected");
    	if(new ContadoDAO().delete(contato.getId())){
    		Messages.addGlobalInfo("Contato removido com sucesso!");
    	}else{
    		Messages.addGlobalError("Erro ao remover contato!");
    	}
    	init();
    }
    
	public void novoContato(){
		contato = new Contato();
	}
    
    public void edit(ActionEvent e){
    	contato = (Contato) e.getComponent().getAttributes().get("selected");
    }
    
    
    
    
    public Contato getContato(){
		return contato;
	}

	public void setContato(Contato contato){
		this.contato = contato;
	}

	public List<Contato> getContatos(){
		return contatos;
	}

	public void setContatos(List<Contato> contatos){
		this.contatos = contatos;
	}
    
	
}