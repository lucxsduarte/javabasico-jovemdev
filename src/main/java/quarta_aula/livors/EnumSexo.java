package quarta_aula.livors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumSexo {
	
	MASCULINO(1, "Masculino"),
	FEMININO(2, "Feminino");
	
	private int codigo;
	private String descrição;
	
	public static EnumSexo findById(int codigo) {
		for (EnumSexo sexo : EnumSexo.values()) {
			if(codigo == sexo.codigo) {
				return sexo;
			}
		}
		return null;
	}
}
