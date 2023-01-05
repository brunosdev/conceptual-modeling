package com.brunosanttos.mc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.brunosanttos.mc.domain.enums.ClientType;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;

public class Client implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String email;
	private String CPForCNJP;
	
	private Integer clientType;
	
	private List<Adress> adresses = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name ="PHONES")
	private Set<String> phones = new HashSet<>();
	
	public Client() {
		
	}

	public Client(Integer id, String name, String email, String cPForCNJP, ClientType clientType) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.CPForCNJP = cPForCNJP;
		this.clientType = clientType.getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCPForCNJP() {
		return CPForCNJP;
	}

	public void setCPForCNJP(String cPForCNJP) {
		CPForCNJP = cPForCNJP;
	}

	public ClientType getClientType() {
		return ClientType.toEnum(clientType);
	}

	public void setClientType(ClientType clientType) {
		this.clientType = clientType.getCod();
	}
	
	public List<Adress> getAdresses() {
		return adresses;
	}
	
	public Set<String> getPhones() {
		return phones;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(id, other.id);
	}
}
