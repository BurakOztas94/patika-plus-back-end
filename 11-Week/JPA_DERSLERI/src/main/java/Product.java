import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id",columnDefinition = "serial")
    private int id;

    @Column(name ="product_name",nullable = false)
    private String name;
    @Column(name ="product_prc",nullable = false)
    private double price;
    @Column(name ="product_stock")
    private int stock;

    @OneToOne
    @JoinColumn(name ="product_code_id",referencedColumnName = "code_id")
    private Code code;

    @ManyToOne
    @JoinColumn(name = "product_supplier_id",referencedColumnName = "supplier_id")
    private Supplier supplier;

    public Product ()
        {
        }

    public int getId ()
        {
            return id;
        }

    public void setId (int id)
        {
            this.id = id;
        }

    public String getName ()
        {
            return name;
        }

    public void setName (String name)
        {
            this.name = name;
        }

    public double getPrice ()
        {
            return price;
        }

    public void setPrice (double price)
        {
            this.price = price;
        }

    public int getStock ()
        {
            return stock;
        }

    public void setStock (int stock)
        {
            this.stock = stock;
        }

    public Code getCode ()
        {
            return code;
        }

    public void setCode (Code code)
        {
            this.code = code;
        }

    public Supplier getSupplier ()
        {
            return supplier;
        }

    public void setSupplier (Supplier supplier)
        {
            this.supplier = supplier;
        }

    @Override
    public String toString ()
        {
            return "Product{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    ", stock=" + stock +
                    ", code=" + code +
                    '}';
        }
}
