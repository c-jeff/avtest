package pe.edu.upc.avinka.model.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "Products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;
	
	@NotEmpty(message = "Prueba de error")
	@Column( name = "name", length = 100 , nullable = false)
	private String name;
	
	@Column(name = "description", length = 300)
	private String description;
	
	
	@Column(name = "stock", length = 500)
	private String stock;
	
	
	@Column(name = "price", columnDefinition = "DECIMAL(5,2)")
	private float price;
	
	@Column(name = "tipoEnvase", length = 500)
	private String tipoEnvase;
	
	@Column(name = "tiempoVida", length = 500)
	private String tiempoVida;
	
	@Column(name = "almacenamiento", length = 500)
	private String almacenamiento;
	
	@Column(name = "reconstitucion", length = 500)
	private String reconstitucion;
	
	@Column(name = "consumidorFinal", length = 500)
	private String consumidorFinal;
	
	@Column(name = "imagen")
	private String imagen;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	


	public String getImagen() {
		return imagen;
	}




	public void setImagen(String imagen) {
		this.imagen = imagen;
	}




	public String getTipoEnvase() {
		return tipoEnvase;
	}




	public void setTipoEnvase(String tipoEnvase) {
		this.tipoEnvase = tipoEnvase;
	}




	public String getTiempoVida() {
		return tiempoVida;
	}




	public void setTiempoVida(String tiempoVida) {
		this.tiempoVida = tiempoVida;
	}




	public String getAlmacenamiento() {
		return almacenamiento;
	}




	public void setAlmacenamiento(String almacenamiento) {
		this.almacenamiento = almacenamiento;
	}




	public String getReconstitucion() {
		return reconstitucion;
	}




	public void setReconstitucion(String reconstitucion) {
		this.reconstitucion = reconstitucion;
	}




	public String getConsumidorFinal() {
		return consumidorFinal;
	}




	public void setConsumidorFinal(String consumidorFinal) {
		this.consumidorFinal = consumidorFinal;
	}




	public Product(Integer id, Category category, @NotEmpty(message = "Prueba de error") String name,
			String description, String stock, float price, String tipoEnvase, String tiempoVida, String almacenamiento,
			String reconstitucion, String consumidorFinal, String imagen) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.description = description;
		this.stock = stock;
		this.price = price;
		this.tipoEnvase = tipoEnvase;
		this.tiempoVida = tiempoVida;
		this.almacenamiento = almacenamiento;
		this.reconstitucion = reconstitucion;
		this.consumidorFinal = consumidorFinal;
		this.imagen = imagen;
	}




	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getStock() {
		return stock;
	}


	public void setStock(String stock) {
		this.stock = stock;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
}
