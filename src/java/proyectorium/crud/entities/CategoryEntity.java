/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectorium.crud.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ruth
 */
@NamedQueries({
    @NamedQuery(
            name = "listCategoriesbyPegi",
            query = "SELECT c FROM CategoryEntity c ORDER BY c.pegi ASC"
    )
    ,
    @NamedQuery(
            name = "listCategoriesbyCreationDate",
            query = "SELECT c FROM CategoryEntity c ORDER BY c.creationDate DESC"
    )
    ,
    @NamedQuery(
            name = "findCategoriesByDescriptionLengthAndPegi18",
            query = "SELECT c FROM CategoryEntity c WHERE LENGTH(c.description) < 50 AND c.pegi = proyectorium.crud.entities.Pegi.PEGI_18 ORDER BY c.name"
    )
})

@Entity
@Table(schema = "proyectorium", name = "Category")
@XmlRootElement
public class CategoryEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Lob
    private byte[] icon;
    private String name;
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Enumerated(EnumType.STRING)
    private Pegi pegi;

    public CategoryEntity() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getIcon() {
        return icon;
    }

    public void setIcon(byte[] icon) {
        this.icon = icon;
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

    public Pegi getPegi() {
        return pegi;
    }

    public void setPegi(Pegi pegi) {
        this.pegi = pegi;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoryEntity)) {
            return false;
        }
        CategoryEntity other = (CategoryEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectorium.crud.entities.CategoryEntity[ id=" + id + " ]";
    }

}
