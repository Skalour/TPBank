package tp.bank.model;

public enum OperationType {
	VieQuotidienne("Vie quotidienne"),
	Carburant("Carburant"),
	Sante("Santé"),
	Loisirs("Loisirs"),
	Logement("Logement"),
	Abonnements("Téléphonie/Internet"),
	Impots("Impôts/Taxes");
	
	private String description = "";

	OperationType(String description) {
		this.description = description;
	}
	
	public String toString() {
		return description;
	}
	
	
}
