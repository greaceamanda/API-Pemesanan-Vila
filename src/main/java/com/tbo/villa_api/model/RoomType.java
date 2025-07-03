package com.tbo.villa_api.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "room_types")
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "villa", nullable = false)
    @JsonBackReference("villa-room")
    private Villa villa;

    @NotBlank
    private String name;

    private int quantity;
    private int capacity;
    private int price;

    private String bedSize;

    private boolean hasDesk;
    private boolean hasAc;
    private boolean hasTv;
    private boolean hasWifi;
    private boolean hasShower;
    private boolean hasHotwater;
    private boolean hasFridge;

    // Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Villa getVilla() { return villa; }
    public void setVilla(Villa villa) { this.villa = villa; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public String getBedSize() { return bedSize; }
    public void setBedSize(String bedSize) { this.bedSize = bedSize; }

    public boolean isHasDesk() { return hasDesk; }
    public void setHasDesk(boolean hasDesk) { this.hasDesk = hasDesk; }

    public boolean isHasAc() { return hasAc; }
    public void setHasAc(boolean hasAc) { this.hasAc = hasAc; }

    public boolean isHasTv() { return hasTv; }
    public void setHasTv(boolean hasTv) { this.hasTv = hasTv; }

    public boolean isHasWifi() { return hasWifi; }
    public void setHasWifi(boolean hasWifi) { this.hasWifi = hasWifi; }

    public boolean isHasShower() { return hasShower; }
    public void setHasShower(boolean hasShower) { this.hasShower = hasShower; }

    public boolean isHasHotwater() { return hasHotwater; }
    public void setHasHotwater(boolean hasHotwater) { this.hasHotwater = hasHotwater; }

    public boolean isHasFridge() { return hasFridge; }
    public void setHasFridge(boolean hasFridge) { this.hasFridge = hasFridge; }
}
