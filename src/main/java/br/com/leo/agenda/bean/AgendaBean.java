package br.com.leo.agenda.bean;

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
public class AgendaBean {

    private Contato contato;
    private List<Contato> contatos;

    @PostConstruct
    private void init(){
    	contatos = new ContadoDAO().listAll();
    }
    
	public void novoContato(){
		contato = new Contato();
	}
    
    public void save(){
    	if(new ContadoDAO().save(contato)){
    		Messages.addGlobalInfo("Contato adicionado com sucesso!");
    	}else{
    		Messages.addGlobalError("Erro ao adicionar contato!");
    	}
    	init();
    	novoContato();
    }
    
    public void delete(ActionEvent e){
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