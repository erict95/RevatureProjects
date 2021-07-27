package userModels;

public class Reimbursement {
	private Integer id;
	private Integer amount;
	private String submit;
	private String resolve;
	private String Description = "";
	private Integer Author;
	private Integer Resolver = 0;
	private Integer SID =1;
	private Integer TID;
	private String status;
	private String first;
	private String last;
	private String email;
	private String type;
	
	public Reimbursement() {
		super();
	}

	public Reimbursement(Integer id) {
		super();
		this.id = id;
	}
	
	public Reimbursement(Integer resolver, Integer sID) {
		super();
		Resolver = resolver;
		SID = sID;
	}

	public Reimbursement(Integer amount, String description, Integer author, Integer tID) {
		super();
		this.amount = amount;
		Description = description;
		Author = author;
		TID = tID;
	}
	
	public Reimbursement(String type, String resolve, Integer id, String description, String status, String first) {
		super();
		this.type = type;
		this.resolve = resolve;
		this.id = id;
		Description = description;
		this.status = status;
		this.first = first;
	}
	
	public Reimbursement(Integer id, Integer amount, String submit, String resolve, String description, Integer author,
			Integer resolver, Integer sID, Integer tID) {
		super();
		this.id = id;
		this.amount = amount;
		this.submit = submit;
		this.resolve = resolve;
		this.Description = description;
		this.Author = author;
		this.Resolver = resolver;
		this.SID = sID;
		this.TID = tID;
	}

	public Reimbursement(Integer id, String first, String last, String email, String type, 
			String description, Integer amount, String status, String submit) {
		super();
		this.id = id;
		this.amount = amount;
		this.submit = submit;
		Description = description;
		this.status = status;
		this.first = first;
		this.last = last;
		this.email = email;
		this.type = type;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public String getResolve() {
		return resolve;
	}

	public void setResolve(String resolve) {
		this.resolve = resolve;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Integer getAuthor() {
		return Author;
	}

	public void setAuthor(Integer author) {
		Author = author;
	}

	public Integer getResolver() {
		return Resolver;
	}

	public void setResolver(Integer resolver) {
		Resolver = resolver;
	}

	public Integer getSID() {
		return SID;
	}

	public void setSID(Integer sID) {
		SID = sID;
	}

	public Integer getTID() {
		return TID;
	}

	public void setTID(Integer tID) {
		TID = tID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "/nReimbursement [id=" + id + ", amount=" + amount + ", submit=" + submit + ", resolve=" + resolve
				+ ", Description=" + Description + ", Author=" + Author + ", Resolver=" + Resolver + ", SID=" + SID
				+ ", TID=" + TID + "]";
	}

	public Reimbursement(Integer id, Integer amount, String submit, String resolve, String description, Integer author,
			Integer resolver, Integer sID, Integer tID, String status, String first, String last, String email, String type) {
		super();
		this.id = id;
		this.amount = amount;
		this.submit = submit;
		this.resolve = resolve;
		Description = description;
		Author = author;
		Resolver = resolver;
		SID = sID;
		TID = tID;
		this.status = status;
		this.first = first;
		this.last = last;
		this.email = email;
		this.type = type;
	}

	
}
