package es.uniovi.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("nombreValidator")
public class NombreValidator implements Validator {

	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String nombre=(String)value;
		if(nombre==null || nombre.length()<4) {
			throw new ValidatorException(
				new FacesMessage(FacesMessage.SEVERITY_ERROR, 
						"Error en nombre", "Debe tener al menos 4 letras"));
		}
	}
}
