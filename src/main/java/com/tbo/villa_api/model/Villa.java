package com.tbo.villa_api.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "villas")
public class Villa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    private String address;

    @OneToMany(mappedBy = "villa", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("villa-room")
    private List<RoomType> rooms;

    // Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public List<RoomType> getRooms() { return rooms; }
    public void setRooms(List<RoomType> rooms) { this.rooms = rooms; }
}
