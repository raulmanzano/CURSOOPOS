package es.uniovi.log;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

public class Log implements ActionListener{
	
	public void processAction(ActionEvent actionEvent) throws AbortProcessingException {
		System.out.println(actionEvent.toString());
		
	}

}
