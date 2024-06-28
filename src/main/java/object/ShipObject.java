package object;

import java.util.Objects;

public class ShipObject {
	private int shipId;
    private String shipName;
    private String shipPrice;

    // Constructors
    public ShipObject() {
    }

	public ShipObject(int shipId, String shipName, String shipPrice) {
		super();
		this.shipId = shipId;
		this.shipName = shipName;
		this.shipPrice = shipPrice;
	}

	@Override
	public String toString() {
		return "ShipObject [shipId=" + shipId + ", shipName=" + shipName + ", shipPrice=" + shipPrice + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(shipId, shipName, shipPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShipObject other = (ShipObject) obj;
		return shipId == other.shipId && Objects.equals(shipName, other.shipName)
				&& Objects.equals(shipPrice, other.shipPrice);
	}

	public int getShipId() {
		return shipId;
	}

	public void setShipId(int shipId) {
		this.shipId = shipId;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public String getShipPrice() {
		return shipPrice;
	}

	public void setShipPrice(String shipPrice) {
		this.shipPrice = shipPrice;
	}
    
}
