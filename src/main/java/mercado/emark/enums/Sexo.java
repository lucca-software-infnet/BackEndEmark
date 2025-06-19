package mercado.emark.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Getter;

@Getter
public enum Sexo {
    MASCULINO("Masculino"),
    FEMININO("Feminino");

    private final String displayName;

    Sexo(String displayName) {
        this.displayName = displayName;
    }

    @JsonValue
    public String getDisplayName() {
        return displayName;
    }

    @JsonCreator
    public static Sexo fromString(String value) {
        for (Sexo sexo : Sexo.values()) {
            if (sexo.displayName.equalsIgnoreCase(value) || sexo.name().equalsIgnoreCase(value)) {
                return sexo;
            }
        }
        throw new IllegalArgumentException("Sexo inválido: " + value);
    }
}

