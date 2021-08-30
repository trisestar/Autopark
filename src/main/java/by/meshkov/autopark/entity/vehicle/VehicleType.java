package by.meshkov.autopark.entity.vehicle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleType {
    public int typeId;
    private String typeName;
    private double taxCoefficient;

    public VehicleType(int typeId) {
        this.typeId = typeId;
    }
}
