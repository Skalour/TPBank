//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.2 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2020.04.13 à 09:19:45 PM CEST 
//


package tp.bank.soap;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tp.bank.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tp.bank.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RefundAccountRequest }
     * 
     */
    public RefundAccountRequest createRefundAccountRequest() {
        return new RefundAccountRequest();
    }

    /**
     * Create an instance of {@link RefundAccountResponse }
     * 
     */
    public RefundAccountResponse createRefundAccountResponse() {
        return new RefundAccountResponse();
    }

    /**
     * Create an instance of {@link ChargeAccountRequest }
     * 
     */
    public ChargeAccountRequest createChargeAccountRequest() {
        return new ChargeAccountRequest();
    }

    /**
     * Create an instance of {@link ChargeAccountResponse }
     * 
     */
    public ChargeAccountResponse createChargeAccountResponse() {
        return new ChargeAccountResponse();
    }

}
